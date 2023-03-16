package commands

/**
 * Class that stores the history of executed commands.
 */
class CommandHistory {
    /**
     * List of executed commands.
     */
    private val history = mutableListOf<UndoableCommand>()

    /**
     * Add executed command to history.
     * @param [command] Executed command.
     */
    fun executedCommand(command: Command) {
        if (command !is UndoableCommand) {
            return
        }
        history.add(command)
    }

    /**
     * Undo the last executed command.
     */
    fun undoLastCommand() {
        if (history.isNotEmpty()) {
            val last = history.removeLast()
            last.undo()
        }
    }
}