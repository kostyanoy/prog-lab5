package commands

/**
 * The command terminates the program.
 */
class Exit : Command() {
    /**
    Returns a description of the command.
     */
    override fun getDescription() {
        interactor.showMessage("exit : завершить программу (без сохранения в файл)")
    }

    override fun execute() {
        interactor.showMessage("Выполняется команда exit")
        interactor.exit()
    }
}
