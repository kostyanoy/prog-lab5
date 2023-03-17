package commands

import data.MusicBand
import exceptions.ParameterException
import utils.ArgumentType
import utils.CommandResult

/**
 * The command adds a new element with the specified key
 *
 * @exception [ParameterException] used if the element with the specified key already exist
 */
class Insert : UndoableCommand() {
    override fun execute(args: ArrayList<Any>): CommandResult {
        val userKey = args[0] as Int
        previousKey = userKey
        val collection = storage.getCollection { true }
        if (userKey in collection.keys) {
            return CommandResult.Failure("Insert", ParameterException("Элемент с таким ключом уже существует"))
        }
        storage.insert(userKey, args[1] as MusicBand)
        return CommandResult.Success("Insert")
    }

    override fun getArgumentTypes(): Array<ArgumentType> {
        return arrayOf(ArgumentType.INT, ArgumentType.MUSIC_BAND)
    }

    override fun undo(): CommandResult {
        previousKey?.let { storage.removeKey(it) }
        return CommandResult.Success("Undo Insert")
    }

}