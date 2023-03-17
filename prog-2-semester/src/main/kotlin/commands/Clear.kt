package commands

import utils.ArgumentType
import utils.CommandResult

/**
 * The command that clears the collection
 */
class Clear : StorageCommand() {
    override fun execute(args: ArrayList<Any>): CommandResult {
        storage.clear()
        return CommandResult.Success("Clear")
    }

    override fun getArgumentTypes(): Array<ArgumentType> {
        return arrayOf()
    }
}