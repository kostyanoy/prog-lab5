package commands

class CommandHistory {
    private val history = mutableListOf<UndoCommand>()
    fun executeCommand(command: UndoCommand) {
        command.execute()
        history.add(command)
    }
    fun undoLastCommand() {
        if (history.isNotEmpty()) {
            val last = history.removeLast()
            last.undo()
        }
    }
}