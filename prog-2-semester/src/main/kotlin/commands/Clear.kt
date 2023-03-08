package commands

import utils.*

/**
 * The command that clears the collection
 */
class Clear(interactor: Interactor, storage: Storage) : Command(interactor, storage) {
    override fun execute() {
        interactor.showMessage("Выполняется команда clear")
        storage.clear()
    }
}