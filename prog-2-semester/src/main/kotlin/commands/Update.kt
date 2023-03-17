package commands

import exceptions.ParameterException
import utils.CommandResult

/**
 * The command that updates the value of a collection item whose id is equal to the specified one
 *
 * @exception [ParameterException] used if the element with the specified key does not exist
 */
class Update : UndoableCommand() {
    override fun execute(): CommandResult {
        val userKey = interactor.getInt()
        val collection = storage.getCollection { true }
        if (userKey !in collection.keys) {
            return CommandResult.Failure("Update", ParameterException("Элемента с таким ключом не существует"))
        }
        previousKey = userKey
        previousElement = collection[userKey]
        storage.update(userKey, interactor.getMusicBand())
        return CommandResult.Success("Update")
    }

    override fun undo(): CommandResult {
        previousKey?.let { previousElement?.let { it1 -> storage.update(it, it1) } }
        return CommandResult.Success("Undo Update")
    }
}
