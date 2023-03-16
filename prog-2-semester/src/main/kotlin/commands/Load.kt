package commands

import exceptions.FileException
import org.jetbrains.kotlin.konan.file.File
/**
 * The command loads the file with the collection
 *
 * * @exception [FileException] used if no saved file is found
 */
class Load : StorageCommand() {
    /**
    Returns a description of the command.
     */
    override fun getDescription() {
        interactor.showMessage("load : загрузить коллекцию из файла")
    }
    override fun execute() {
        interactor.showMessage("Выполняется команда load")
        if (!File("save.txt").exists) {
            throw FileException("Сохраненного файла не обнаружено")
        }
        storage.clear()
        interactor.load()
            .forEach { storage.insert(it.key, it.value) }
    }
}