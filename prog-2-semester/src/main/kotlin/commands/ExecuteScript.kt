package commands

import exceptions.FileException
import org.jetbrains.kotlin.konan.file.File
import utils.Interactor
import utils.Storage

/**
 * The command reads and executes the script from the specified file
 *
 * @exception [FileException] used if no file is found
 */
class ExecuteScript(interactor: Interactor, storage: Storage) : Command(interactor, storage) {
    override fun execute() {
        interactor.showMessage("Выполняется команда execute")
        val path = interactor.getString()
        if (!File(path).exists) {
            throw FileException("Файла команд не обнаружено")
        }
        interactor.executeCommandFile(path)
    }
}