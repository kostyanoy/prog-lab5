package commands

import exceptions.ParameterException

/**
 * The command adds a new element with the specified key
 *
 * @exception [ParameterException] used if the element with the specified key already exist
 */
class Insert : UndoCommand() {
    override fun execute() {
        interactor.showMessage("Выполняется команда insert")
        val userKey = interactor.getInt()
        previousKey = userKey
        val collection = storage.getCollection { true }
        if (userKey in collection.keys) {
            throw ParameterException("Элемент с таким ключом уже существует")
        }
        storage.insert(userKey, interactor.getMusicBand())
    }
    override fun undo() {
        interactor.showMessage("Отменяется команда insert")
        previousKey?.let { storage.removeKey(it) }
    }

}