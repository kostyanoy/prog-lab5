package commands

import utils.CommandResult

/**
 * The command saves the collection to a file
 */
class Save : StorageCommand() {
    override fun execute(): CommandResult {
        interactor.save(storage.getCollection { true })
        return CommandResult.Success("Save")
    }
}