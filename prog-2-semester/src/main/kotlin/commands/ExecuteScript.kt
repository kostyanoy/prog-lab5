package commands

import exceptions.FileException
import org.jetbrains.kotlin.konan.file.File
import utils.Interactor
import utils.Storage

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