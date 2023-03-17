package commands

import exceptions.ParameterException
import utils.ArgumentType
import utils.CommandResult

/**
 * The command removes an item from the collection by its key
 *
 * @exception [ParameterException] used if the element with the specified key does not exist
 */
class RemoveKey : UndoableCommand() {
    override fun execute(args: ArrayList<Any>): CommandResult {
        val userKey = args[0] as Int
        val collection = storage.getCollection { true }
        if (userKey !in collection.keys) {
            return CommandResult.Failure("Remove_greater", ParameterException("Элемента с таким ключом не существует"))
        }
        previousKey = userKey
        previousElement = collection[userKey]
        storage.removeKey(userKey)
        return CommandResult.Success("Remove_key")
    }

    override fun getArgumentTypes(): Array<ArgumentType> {
        return arrayOf(ArgumentType.INT)
    }

    override fun undo(): CommandResult {
        previousElement?.let { storage.insert(previousKey!!, it) }
        return CommandResult.Success("Undo Remove_key")
    }
}
