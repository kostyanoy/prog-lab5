package commands

import exceptions.ParameterException

/**
 * The command that updates the value of a collection item whose id is equal to the specified one
 *
 * @exception [ParameterException] used if the element with the specified key does not exist
 */
class Update : UndoCommand() {
    override fun execute() {
        interactor.showMessage("Выполняется команда update")
        val userKey = interactor.getInt()
        val collection = storage.getCollection()
        if (userKey !in collection.keys) {
            throw ParameterException("Элемента с таким ключом не существует")
        }
        previousKey = userKey
        previousElement = collection[userKey]
        storage.update(userKey, interactor.getMusicBand())
    }
    override fun undo() {
        interactor.showMessage("Отменяется команда update")
        previousKey?.let { previousElement?.let { it1 -> storage.update(it, it1) } }
    }
}
