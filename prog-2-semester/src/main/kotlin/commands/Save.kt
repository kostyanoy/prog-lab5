package commands

/**
 * The command saves the collection to a file.
 */
class Save : StorageCommand() {
    /**
    Returns a description of the command.
     */
    override fun getDescription() {
        interactor.showMessage("save : сохранить коллекцию в файл")
    }

    override fun execute() {
        interactor.showMessage("Выполняется команда save")
        interactor.save(storage.getCollection { true })
    }
}