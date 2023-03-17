package commands

/**
 * The command removes from the collection all items that exceed the specified.
 *
 * The loop and condition are used to validate the key.
 */
class RemoveGreater : UndoableCommand() {
    /**
    Returns a description of the command.
     */
    override fun getDescription() {
        interactor.showMessage("remove_greater : удалить из коллекции все элементы, превышающие заданный")
    }

    override fun execute() {
        previousPair.clear()
        interactor.showMessage("Выполняется команда remove_greater")
        val userElement = interactor.getMusicBand()
        storage.getCollection { userElement < value }
            .forEach {
                previousPair.add(it.key to it.value)
                storage.removeKey(it.key)
            }
    }

    override fun undo() {
        interactor.showMessage("Отменяется команда remove_greater")
        previousPair.forEach { (key, value) ->
            storage.insert(key, value)
        }
        previousPair.clear()
    }

}
