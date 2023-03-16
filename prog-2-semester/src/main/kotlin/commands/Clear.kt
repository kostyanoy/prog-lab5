package commands

/**
 * The command that clears the collection.
 */
class Clear : StorageCommand() {
    /**
    Returns a description of the command.
     */
    override fun getDescription() {
        interactor.showMessage("clear : очистить коллекцию")
    }
    override fun execute() {
        interactor.showMessage("Выполняется команда clear")
        storage.clear()
    }
}