package commands

import exceptions.ParameterException

/**
 * The command adds a new element with the specified key.
 *
 * @exception [ParameterException] used if the element with the specified key already exist.
 */
class Insert : UndoableCommand() {
    /**
    Returns a description of the command.
     */
    override fun getDescription() {

        interactor.showMessage("insert : добавить новый элемент с заданным ключом")
    }

    override fun execute() {
        previousPair.clear()
        interactor.showMessage("Выполняется команда insert")
        val userKey = interactor.getInt()
        val collection = storage.getCollection { true }
        if (userKey in collection.keys) {
            throw ParameterException("Элемент с таким ключом уже существует")
        }
        previousPair.add(userKey to collection[userKey]!!)
        storage.insert(userKey, interactor.getMusicBand())
    }

    override fun undo() {
        interactor.showMessage("Отменяется команда insert")
        previousPair.forEach { (key) ->
            storage.removeKey(key)
        }
        previousPair.clear()
    }

}