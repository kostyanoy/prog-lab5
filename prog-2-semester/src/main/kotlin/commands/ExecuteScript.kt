package commands

import exceptions.FileException
import org.jetbrains.kotlin.konan.file.File

/**
 * The command reads and executes the script from the specified file.
 *
 * @exception [FileException] used if no file is found.
 */

class ExecuteScript() : Command() {
    /**
    Returns a description of the command.
     */
    override fun getDescription() {
        interactor.showMessage("execute_script : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.")
    }

    override fun execute() {
        interactor.showMessage("Выполняется команда execute")
        val path = interactor.getString()
        if (!File(path).exists) {
            throw FileException("Файла команд не обнаружено")
        }
        interactor.executeCommandFile(path)
    }
}
