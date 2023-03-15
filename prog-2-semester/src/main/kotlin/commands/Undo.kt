package commands

import org.koin.core.component.inject

class Undo: Command() {
    val history: CommandHistory by inject()
    override fun execute() {
        history.undoLastCommand()
    }

}