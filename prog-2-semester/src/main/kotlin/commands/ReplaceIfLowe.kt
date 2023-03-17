package commands

import exceptions.ParameterException
import utils.CommandResult

/**
 * The command replaces the value by the key if the new value is less than the old one
 *
 * The condition is used to check the value by the key
 * @exception [ParameterException] used if the element with the specified key does not exist
 */
class ReplaceIfLowe: StorageCommand() {
    override fun execute(): CommandResult {
        val userKey = interactor.getInt()
        val collection = storage.getCollection { true }
        if (userKey !in collection.keys) {
            return CommandResult.Failure("Replace_if_lowe", ParameterException("Элемента с таким ключом не существует"))
        }
        val userElement = interactor.getMusicBand()
        if (userElement < collection[userKey]!!) {
            storage.update(userKey, userElement)
        }
        return CommandResult.Success("Replace_if_lowe")
    }
}


