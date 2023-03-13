package commands

/**
 * The command outputs information about the collection to the standard output stream
 */
class Info : StorageCommand() {
    override fun execute() {
        interactor.showMessage("Выполняется команда info")
        storage.getInfo()
    }
}
