package commands

import exceptions.ParameterException

/**
 * The command that updates the value of a collection item whose id is equal to the specified one.
 *
 * @exception [ParameterException] used if the element with the specified key does not exist.
 */
class Update : UndoableCommand() {
    /**
    Returns a description of the command.
     */
    override fun getDescription() {
        interactor.showMessage("update : обновить значение элемента коллекции, id которого равен заданному")
    }
    override fun execute() {
        previousPair.clear()
        interactor.showMessage("Выполняется команда update")
        val userKey = interactor.getInt()
        val collection = storage.getCollection { true }
        if (userKey !in collection.keys) {
            throw ParameterException("Элемента с таким ключом не существует")
        }
        previousPair.add(userKey to collection[userKey]!!)
        storage.update(userKey, interactor.getMusicBand())
    }
    override fun undo() {
        interactor.showMessage("Отменяется команда update")
        previousPair.forEach { (key, value) ->
            storage.update(key, value)
        }
        previousPair.clear()
    }
}
