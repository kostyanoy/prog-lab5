package commands

import utils.ArgumentType
import utils.CommandResult

/**
 * The command outputs information about the collection to the standard output stream
 */
class Info : StorageCommand() {
    override fun execute(args: ArrayList<Any>): CommandResult {
        return CommandResult.Success("Info", storage.getInfo())
    }

    override fun getArgumentTypes(): Array<ArgumentType> {
        return arrayOf()
    }
}
