package commands

import utils.Interactor
import utils.Storage

class ExecuteScript(interactor: Interactor, storage: Storage) : Command(interactor, storage) {
    override fun execute() {
        interactor.showMessage("Выполняется команда execute")
        val path = interactor.getString()
        interactor.executeCommandFile(path)
    }
}