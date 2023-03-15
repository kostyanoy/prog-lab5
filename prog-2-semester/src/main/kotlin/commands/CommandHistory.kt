package commands

class CommandHistory {
    private val history = mutableListOf<UndoableCommand>()
    fun executedCommand(command: Command) {
        if(command !is UndoableCommand){
            return
        }
        history.add(command)
    }
    fun undoLastCommand() {
        if (history.isNotEmpty()) {
            val last = history.removeLast()
            last.undo()
        }
    }
}