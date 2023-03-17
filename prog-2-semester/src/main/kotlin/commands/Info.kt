package commands

import utils.CommandResult

/**
 * The command outputs information about the collection to the standard output stream
 */
class Info : StorageCommand() {
    override fun execute(): CommandResult {
        return CommandResult.Success("Info", storage.getInfo())
    }
}
