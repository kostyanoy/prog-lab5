package commands

/**
 * The command outputs all the elements of the collection in a string representation to the standard output stream
 */
class Show : StorageCommand() {
    /**
    Returns a description of the command.
     */
    override fun getDescription() {
        interactor.showMessage("show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении")
    }
    override fun execute() {
        interactor.showMessage("Выполняется команда show")
        val message = buildString {
            appendLine("Коллекция содержит: ")
            storage.getCollection { true }
                .forEach { appendLine(it.value) }
        }
        interactor.showMessage(message)
    }
}
