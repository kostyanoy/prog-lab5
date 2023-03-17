package commands

import utils.ArgumentType
import utils.CommandResult

/**
 * The command saves the collection to a file
 */
class Save : StorageCommand() {
    override fun execute(args: ArrayList<Any>): CommandResult {
        interactor.save(storage.getCollection { true })
        return CommandResult.Success("Save")
    }

    override fun getArgumentTypes(): Array<ArgumentType> {
        return arrayOf()
    }
}