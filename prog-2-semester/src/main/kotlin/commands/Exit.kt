package commands

import utils.*

/**
 * The command terminates the program
 */
class Exit(interactor: Interactor, storage: Storage) : Command(interactor, storage) {
    override fun execute() {
        interactor.showMessage("Выполняется команда exit")
        interactor.exit()
    }
}