package commands

/**
 * The command removes from the collection all items whose key exceeds the specified one.
 *
 * The loop and condition are used to validate the key.
 */
class RemoveGreaterKey : UndoableCommand() {
    /**
    Returns a description of the command.
     */
    override fun getDescription() {
        interactor.showMessage("remove_greater_key : удалить из коллекции все элементы, ключ которых превышает заданный")
    }

    override fun execute() {
        interactor.showMessage("Выполняется команда remove_greater_key")
        val userKey = interactor.getInt()
        storage.getCollection { userKey < key }
            .forEach {
                previousKey = it.key
                previousElement = it.value
                storage.removeKey(it.key)
            }
    }

    override fun undo() {
        interactor.showMessage("Отменяется команда remove_greater_key")
        previousElement?.let { storage.insert(previousKey!!, it) }
    }

}