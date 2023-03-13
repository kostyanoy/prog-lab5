package commands

/**
 * The command removes from the collection all items that exceed the specified
 *
 * The loop and condition are used to validate the key
 */
class RemoveGreater : UndoCommand() {
    override fun execute() {
        interactor.showMessage("Выполняется команда remove_greater")
        val collection = storage.getCollection()
        val userElement = interactor.getMusicBand()
        for (key in collection.keys) {
            if (userElement < collection[key]!!) {
                previousKey = key
                storage.removeKey(key)
            }
        }
    }

    override fun undo() {
        interactor.showMessage("Отменяется команда remove_greater")
        previousKey?.let { previousElement?.let { it1 -> storage.insert(it, it1) } }
    }

}
