package commands

import utils.*

class Info(interactor: Interactor, storage: Storage) : Command(interactor, storage) {
    override fun execute() {
        interactor.showMessage("Выполняется команда info")
        storage.getInfo()
    }
}
