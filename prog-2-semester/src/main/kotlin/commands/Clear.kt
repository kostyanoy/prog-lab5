package commands

/**
 * The command that clears the collection
 */
class Clear : StorageCommand() {
    override fun execute() {
        interactor.showMessage("Выполняется команда clear")
        storage.clear()
    }
}