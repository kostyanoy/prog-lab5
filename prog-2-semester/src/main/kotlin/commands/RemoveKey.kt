package commands

import exceptions.ParameterException

/**
 * The command removes an item from the collection by its key
 *
 * @exception [ParameterException] used if the element with the specified key does not exist
 */
class RemoveKey : UndoableCommand() {
    override fun getDescription() {
        interactor.showMessage("removeKey : удалить элемент из коллекции по его ключу")
    }
    override fun execute() {
        previousPair.clear()
        interactor.showMessage("Выполняется команда removeKey")
        val userKey = interactor.getInt()
        val collection = storage.getCollection { true }
        if (userKey !in collection.keys) {
            throw ParameterException("Элемента с таким ключом не существует")
        }
        previousPair.add(userKey to collection[userKey]!!)
        storage.removeKey(interactor.getInt())
    }

    override fun undo() {
        interactor.showMessage("Отменяется команда removeKey")
        previousPair.forEach { (key, value) ->
            storage.insert(key, value)
        }
        previousPair.clear()
    }
}
