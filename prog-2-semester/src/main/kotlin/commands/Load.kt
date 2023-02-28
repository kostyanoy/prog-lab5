package commands

import utils.*

class Load(interactor: Interactor, storage: Storage) : Command(interactor, storage) {
    override fun execute() {
        interactor.showMessage("Выполняется команда load")
        interactor.load()
    }
}