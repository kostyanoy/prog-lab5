package utils

import commands.Command
import commands.CommandType

class CommandManager(val interactor: Interactor, val storage: Storage) {
    val commands = mapOf<String, Command>()

    fun getCommand(name: String) : Command{
        return object : Command(interactor, storage) {
            override fun execute() {
                TODO("Not yet implemented")
            }
        }
    }

}