package utils

import data.MusicBand
import data.MusicGenre
import exceptions.FileException
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import utils.file.FileManager

/**
 * Implements [Interactor] interface. Executes load command on start
 *
 * @param userManager used to show messages to user and get input from user
 * @param saver used to load and save collection
 * @param fileManager used to ececute command file
 * @param storage used to interact with collection
 */
class InteractionManager (
    private val userManager: ReaderWriter,
    private val saver: Saver<LinkedHashMap<Int, MusicBand>>,
    private val fileManager: FileManager,
    private val storage: Storage<LinkedHashMap<Int, MusicBand>, Int, MusicBand>,
) : KoinComponent, Interactor, Saver<LinkedHashMap<Int, MusicBand>> by saver {

    private val validator: Validator by inject()
    private val commandManager: CommandManager by inject()
    private val invitation = ">>>"
    private var isActive = true
    private var lastArgument: String? = null
    private val executingFiles = ArrayDeque<String>()
    override fun start() {
        try {
            commandManager.getCommand("load").execute()
            showMessage("Загружена коллекция из файла сохранения!")
        } catch (e: FileException) {
            showMessage(e.message ?: "")
        }
        userManager.writeLine("Здрасьте, для вывода списка команд введите help")
        while (isActive) {
            interact()
        }
    }

    override fun exit() {
        isActive = false
    }

    override fun showMessage(message: String) = userManager.writeLine(message)
    override fun showInvitation(message: String) = userManager.write(message)

    override fun getString(): String = lastArgument ?: validator.getString()
    override fun getInt(): Int = lastArgument?.toIntOrNull() ?: validator.getInt()
    override fun getGenre(): MusicGenre = lastArgument?.let { MusicGenre.valueOfOrNull(it) } ?: validator.getGenre()
    override fun getMusicBand(): MusicBand = validator.getMusicBand()

    override fun executeCommandFile(path: String) {
        val text = fileManager.readFile(path)
        if (path in executingFiles) {
            showMessage("Предотвращение зацикливания!")
            return
        }
        executingFiles.add(path)
        FileInteractor(this, storage, text.lines()).start()
        executingFiles.removeLast()
    }

    private fun interact() {
        userManager.write(invitation)
        val input = userManager.readLine().split(" ")
        if (input.count() > 2) {
            showMessage("Слишком много аргументов в строке")
            return
        }
            //костя моментс
        try {
            val command = commandManager.getCommand(input[0])
            lastArgument = if (input.count() == 2) input[1] else null
            command.execute()
        } catch (e: Throwable) {
            showMessage(e.message ?: "")
        } finally {
            executingFiles.clear()
        }
    }
}