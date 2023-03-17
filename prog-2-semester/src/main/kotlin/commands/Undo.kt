package commands

import org.koin.core.component.inject
import utils.CommandResult

class Undo: Command() {
    val history: CommandHistory by inject()
    override fun execute(): CommandResult {
        return history.undoLastCommand()
    }

}