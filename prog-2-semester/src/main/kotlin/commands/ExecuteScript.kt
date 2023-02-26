package commands
import utils.*

class ExecuteScript(interactor: Interactor, storage: Storage) : Command(interactor, storage) {
    override fun execute() {
        interactor.showMessage("Выполняется команда execute")
        interactor.load()
    }
}