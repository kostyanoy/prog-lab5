package commands

import org.koin.core.component.inject
/**
Represents an undo command that undoes the previous executed command.
*/
class Undo: Command() {
    /**
    Returns a description of the command.
     */
    override fun getDescription() {
        interactor.showMessage("undo : отмена последней выполненной команды")
    }
    val history: CommandHistory by inject()
    override fun execute() {
        history.undoLastCommand()
    }

}