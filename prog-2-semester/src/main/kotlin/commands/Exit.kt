package commands

import utils.ArgumentType
import utils.CommandResult

/**
 * The command terminates the program
 */
class Exit : Command() {
    override fun execute(args: ArrayList<Any>): CommandResult {
        interactor.exit()
        return CommandResult.Success("Exit")
    }

    override fun getArgumentTypes(): Array<ArgumentType> {
        return arrayOf()
    }
}
