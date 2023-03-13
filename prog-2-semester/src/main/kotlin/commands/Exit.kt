package commands

/**
 * The command terminates the program
 */
class Exit : Command() {
    override fun execute() {
        interactor.showMessage("Выполняется команда exit")
        interactor.exit()
    }
}
