package commands

import utils.CommandResult

/**
 * The command that clears the collection
 */
class Clear : StorageCommand() {
    override fun execute(): CommandResult {
        storage.clear()
        return CommandResult.Success("Clear")
    }
}