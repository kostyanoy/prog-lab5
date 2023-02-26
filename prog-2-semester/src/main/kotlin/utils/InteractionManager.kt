package utils

import data.Album
import data.Coordinates
import data.MusicBand
import data.MusicGenre
import utils.console.ConsoleManager
import utils.file.FileManager
import utils.file.FileSaver

class InteractionManager(
    private val userManager: ReaderWriter = ConsoleManager(),
    private val saver: Saver = FileSaver(),
    private val fileManager: FileManager = FileManager(),
    private val storage: Storage = StorageManager(),
) : Interactor {

    private val commandManager: CommandManager = CommandManager(this, storage)
    private val invitation = ">>>"
    private var isActive = true
    private var lastArgument: String? = null

    override fun start() {
        userManager.writeLine("Здрасьте, для вывода списка команд введите help")
        while (isActive) {
            interact()
        }
    }

    override fun exit() {
        isActive = false
    }

    override fun save(collection: LinkedHashMap<Int, MusicBand>) = saver.save(collection)

    override fun load(): LinkedHashMap<Int, MusicBand> = saver.load()

    override fun getString(): String {
        while (lastArgument == null) {
            showInvitation("Вы должны ввести аргумент типа строка: ")
            lastArgument = userManager.readLine()
        }
        return lastArgument as String
    }

    override fun getInt(): Int {
        var res = lastArgument?.toIntOrNull()
        while (res == null) {
            showInvitation("Вы должны ввести аргумент типа число: ")
            res = userManager.readLine().toIntOrNull()
        }
        return res
    }

    override fun getMusicBand(): MusicBand {
        val name = userManager.getValidatedValue("Введите название банды: ") {
            it.isNotEmpty()
        }
        val coordX = userManager.getValidatedValue("Введите координату Х: ") {
            (it.toFloatOrNull() ?: return@getValidatedValue false) <= 552
        }.toFloat()
        val coordY = userManager.getValidatedValue("Введите координату Y: ") {
            it.toDoubleOrNull() != null
        }.toDouble()
        val coord = Coordinates(coordX, coordY)
        val participants = userManager.getValidatedValue("Введите количество участников: ") {
            (it.toIntOrNull() ?: return@getValidatedValue false) > 0
        }.toInt()
        val albumCount = userManager.getValidatedValue("Введите количество альбомов (может быть пустым): ") {
            it.isEmpty() || (it.toIntOrNull() ?: return@getValidatedValue false) > 0
        }.toLongOrNull()
        val description = userManager.getValidatedValue("Введите описание банды: ") { true }
        val genre =
            userManager.getValidatedValue("Введите жанр (PROGRESSIVE_ROCK, HIP_HOP, PSYCHEDELIC_CLOUD_RAP, SOUL, POST_PUNK): ") {
                MusicGenre.valueOfOrNull(it.uppercase()) != null
            }
        val albumName = userManager.getValidatedValue("Введите название лучшего альбома: (может быть пустым)") { true }
        var album: Album? = null
        if (albumName.isNotEmpty()) {
            val albumLength = userManager.getValidatedValue("Введите длительность альбома: ") {
                (it.toLongOrNull() ?: return@getValidatedValue false) > 0
            }
            album = Album(albumName, albumLength.toLong())
        }

        return MusicBand(
            name = name,
            coordinates = coord,
            numberOfParticipants = participants,
            albumsCount = albumCount,
            description = description,
            genre = MusicGenre.valueOf(genre.uppercase()),
            bestAlbum = album
        )
    }

    override fun showMessage(message: String) = userManager.writeLine(message)
    override fun showInvitation(message: String) = userManager.write(message)

    private fun interact() {
        userManager.write(invitation)
        val input = userManager.readLine().split(" ")
        if (input.count() > 2) {
            showMessage("Слишком много аргументов в строке")
            return
        }

        //val command = commandManager.getCommand(input[0])
        lastArgument = if (input.count() == 2) input[1] else null
        //command.execute()

    }
}