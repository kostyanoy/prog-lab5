package commands

import org.koin.core.component.inject
import utils.ArgumentType
import utils.CommandResult

class Undo: Command() {
    val history: CommandHistory by inject()
    override fun execute(args: ArrayList<Any>): CommandResult {
        return history.undoLastCommand()
    }

    override fun getArgumentTypes(): Array<ArgumentType> {
        return arrayOf()
    }

}