package commands

import utils.*

/**
 * The command outputs information about the collection to the standard output stream
 */
class Info(interactor: Interactor, storage: Storage) : Command(interactor, storage) {
    override fun execute() {
        interactor.showMessage("Выполняется команда info")
        storage.getInfo()
    }
}
