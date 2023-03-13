package commands

import utils.Interactor
import utils.Storage

/**
 * The command saves the collection to a file
 */
class Save(interactor: Interactor, storage: Storage) : Command(interactor, storage) {
    override fun execute() {
        interactor.showMessage("Выполняется команда save")
        interactor.save(storage.getCollection { true })
    }
}