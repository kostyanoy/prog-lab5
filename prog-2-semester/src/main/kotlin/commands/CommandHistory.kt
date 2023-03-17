package commands

import exceptions.CommandException
import utils.CommandResult

class CommandHistory {
    private val history = mutableListOf<UndoableCommand>()
    fun executedCommand(command: Command) {
        if(command !is UndoableCommand){
            return
        }
        history.add(command)
    }
    fun undoLastCommand() : CommandResult {
        if (history.isNotEmpty()) {
            val last = history.removeLast()
            return last.undo()
        }
        return CommandResult.Failure("Undo", CommandException("Нечего отменять"))
    }
}