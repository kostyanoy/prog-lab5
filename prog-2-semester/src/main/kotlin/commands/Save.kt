package commands

/**
 * The command saves the collection to a file
 */
class Save : StorageCommand() {
    override fun execute() {
        interactor.showMessage("Выполняется команда save")
        interactor.save(storage.getCollection { true })
    }
}