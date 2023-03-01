package commands

import utils.*

class Save(interactor: Interactor, storage: Storage) : Command(interactor, storage) {
    override fun execute() {
        interactor.showMessage("Выполняется команда save")
        interactor.save(storage.getCollection())
    }
}