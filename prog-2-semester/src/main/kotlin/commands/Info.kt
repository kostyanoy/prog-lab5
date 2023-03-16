package commands

/**
 * The command outputs information about the collection to the standard output stream
 */
class Info : StorageCommand() {
    /**
    Returns a description of the command.
     */
    override fun getDescription() {
        interactor.showMessage("info : вывести в стандартный поток вывода информацию о коллекции")
    }

    override fun execute() {
        interactor.showMessage("Выполняется команда info")
        storage.getInfo()
    }
}
