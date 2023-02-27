package utils

import exceptions.CommandException
import commands.*

class CommandManager(interactor: Interactor, storage: Storage) {
    val commands = mapOf<String, Command>(
        "help" to Help(interactor, storage),
        "info" to Info(interactor, storage),
        "show" to Show(interactor, storage),
        "clear" to Clear(interactor, storage),
        "insert" to Insert(interactor, storage),
        "update" to Update(interactor, storage),
        "remove_key" to RemoveKey(interactor, storage),
        "save" to Save(interactor, storage),
        "execute_script" to ExecuteScript(interactor, storage),
        "exit" to Exit(interactor, storage),
        "remove_greater" to RemoveGreater(interactor, storage),
        "replace_if_lowe" to ReplaceIfLowe(interactor, storage),
        "remove_greater_key" to RemoveGreaterKey(interactor, storage),
        "count_greater_than_description" to CountGreaterThanDescription(interactor, storage),
        "filter_less_than_genre" to FilterLessThanGenre(interactor, storage)
    )
    fun getCommand(name: String): Command {
        return commands[name] ?: throw CommandException("Такой команды не существует")
    }
}