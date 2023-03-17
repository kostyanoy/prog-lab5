package commands

import data.MusicBand
import utils.ArgumentType
import utils.CommandResult

/**
 * The command removes from the collection all items that exceed the specified
 *
 * The loop and condition are used to validate the key
 */
class RemoveGreater : UndoableCommand() {
    override fun execute(args: ArrayList<Any>): CommandResult {
        val userElement = args[0] as MusicBand
        storage.getCollection { userElement < value }
            .forEach {
                previousKey = it.key
                storage.removeKey(it.key)
            }
        return CommandResult.Success("Remove_greater")
    }

    override fun getArgumentTypes(): Array<ArgumentType> {
        return arrayOf(ArgumentType.MUSIC_BAND)
    }

    override fun undo(): CommandResult {
        previousKey?.let { previousElement?.let { it1 -> storage.insert(it, it1) } }
        return CommandResult.Success("Undo Remove_greater")
    }

}
