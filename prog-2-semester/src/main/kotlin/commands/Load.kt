package commands

import exceptions.FileException
import org.jetbrains.kotlin.konan.file.File
import utils.Interactor
import utils.Storage

/**
 * The command loads the file with the collection
 *
 * * @exception [FileException] used if no saved file is found
 */
class Load(interactor: Interactor, storage: Storage) : Command(interactor, storage) {
    override fun execute() {
        interactor.showMessage("Выполняется команда load")
        if (!File("save.txt").exists) {
            throw FileException("Сохраненного файла не обнаружено")
        }
        val savedCollection = interactor.load()
        storage.clear()
        for ((key, value) in savedCollection) {
            storage.insert(key, value)
        }
    }
}