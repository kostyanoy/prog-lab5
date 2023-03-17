package commands

import exceptions.ParameterException
import utils.CommandResult

/**
 * The command adds a new element with the specified key
 *
 * @exception [ParameterException] used if the element with the specified key already exist
 */
class Insert : UndoableCommand() {
    override fun execute(): CommandResult {
        val userKey = interactor.getInt()
        previousKey = userKey
        val collection = storage.getCollection { true }
        if (userKey in collection.keys) {
            return CommandResult.Failure("Insert", ParameterException("Элемент с таким ключом уже существует"))
        }
        storage.insert(userKey, interactor.getMusicBand())
        return CommandResult.Success("Insert")
    }

    override fun undo(): CommandResult {
        previousKey?.let { storage.removeKey(it) }
        return CommandResult.Success("Undo Insert")
    }

}