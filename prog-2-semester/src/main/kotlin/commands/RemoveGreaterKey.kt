package commands

import utils.ArgumentType
import utils.CommandResult

/**
 * The command removes from the collection all items whose key exceeds the specified one
 *
 * The loop and condition are used to validate the key
 */
class RemoveGreaterKey : UndoableCommand() {
    override fun execute(args: ArrayList<Any>): CommandResult {
        val userKey = args[0] as Int
        storage.getCollection { userKey < key }
            .forEach {
                previousKey = it.key
                previousElement = it.value
                storage.removeKey(it.key)
            }
        return CommandResult.Success("Remove_greater_key")
    }

    override fun getArgumentTypes(): Array<ArgumentType> {
        return arrayOf(ArgumentType.INT)
    }

    override fun undo(): CommandResult {
        previousElement?.let { storage.insert(previousKey!!, it) }
        return CommandResult.Success("Undo Remove_greater_key")
    }

}