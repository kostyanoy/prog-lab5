package commands

import org.koin.core.component.inject
import utils.CommandManager

/**
 * The command displays help for available commands
 */
class Help() : Command() {
    val commandManager: CommandManager by inject()

    /**
    Returns a description of the command.
     */
    override fun getDescription() {
        println("help : вывести справку по доступным командам")
    }

    override fun execute() {
        for (command in commandManager.commands.values) {
            command.getDescription()
        }
    }
}