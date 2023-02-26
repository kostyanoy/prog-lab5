package utils
import Exceptions.CommandException
import commands.*

class CommandManager(interactor: Interactor, storage: Storage){
    val commands = mapOf<String, Command>(
    "help" to Help(interactor, storage),
    "info" to Info(interactor, storage),
    "show" to Show(interactor, storage),
    "clear" to Clear(interactor, storage),
    "insert" to InsertNull(interactor, storage),
    "update" to UpdateId(interactor, storage),
    "remove_key" to RemoveKey(interactor, storage),
    "save" to Save(interactor, storage),
    "execute_script" to ExecuteScript(interactor, storage),
    "exit" to Exit(interactor, storage),
    "remove_greater" to RemoveGreater(interactor, storage),
    "replace_if_lowe" to ReplaceIfLowe(interactor, storage),
    "remove_greater_key" to RemoveGreaterKey(interactor, storage),
    "count_greater_than_description" to CountGreaterThanDescription(interactor, storage),
    "filter_less_than_genre" to FilterLessThanGenre(interactor, storage))
    fun getCommand(command:String): String {
        if(command in Command){
            return command}
        else {
            throw CommandException()
        }
    }
}