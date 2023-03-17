package commands

import data.MusicBand
import exceptions.ParameterException
import utils.ArgumentType
import utils.CommandResult

/**
 * The command replaces the value by the key if the new value is less than the old one
 *
 * The condition is used to check the value by the key
 * @exception [ParameterException] used if the element with the specified key does not exist
 */
class ReplaceIfLowe: StorageCommand() {
    override fun execute(args: ArrayList<Any>): CommandResult {
        val userKey = args[0] as Int
        val collection = storage.getCollection { true }
        if (userKey !in collection.keys) {
            return CommandResult.Failure("Replace_if_lowe", ParameterException("Элемента с таким ключом не существует"))
        }
        val userElement = args[1] as MusicBand
        if (userElement < collection[userKey]!!) {
            storage.update(userKey, userElement)
        }
        return CommandResult.Success("Replace_if_lowe")
    }

    override fun getArgumentTypes(): Array<ArgumentType> {
        return arrayOf(ArgumentType.INT, ArgumentType.MUSIC_BAND)
    }
}


