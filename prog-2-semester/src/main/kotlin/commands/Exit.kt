package commands

import utils.CommandResult

/**
 * The command terminates the program
 */
class Exit : Command() {
    override fun execute(): CommandResult {
        interactor.exit()
        return CommandResult.Success("Exit")
    }
}
