package commands

import utils.*

class Clear(interactor: Interactor, storage: Storage) : Command(interactor, storage) {
    override fun execute() {
        interactor.showMessage("Выполняется команда clear")
        storage.clear()
    }
}