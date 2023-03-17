package commands

import utils.CommandResult

/**
 * The command outputs all the elements of the collection in a string representation to the standard output stream
 */
class Show : StorageCommand() {
    override fun execute(): CommandResult {
        val message = buildString {
            appendLine("Коллекция содержит: ")
            storage.getCollection { true }
                .forEach { appendLine(it.value) }
        }
        return CommandResult.Success("Show", message)
    }
}
