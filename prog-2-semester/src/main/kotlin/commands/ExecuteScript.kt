package commands

import exceptions.FileException
import org.jetbrains.kotlin.konan.file.File
import utils.ArgumentType
import utils.CommandResult

/**
 * The command reads and executes the script from the specified file
 *
 * @exception [FileException] used if no file is found
 */

class ExecuteScript : Command() {
    override fun execute(args: ArrayList<Any>): CommandResult {
        val path = args[0] as String
        if (!File(path).exists) {
            return CommandResult.Failure("Execute_script", FileException("Файла команд не обнаружено"))
        }
        try {
            interactor.executeCommandFile(path)
        } catch (e: Throwable) {
            return CommandResult.Failure("Execute_script", e)
        }
        return CommandResult.Success("Execute_script")
    }

    override fun getArgumentTypes(): Array<ArgumentType> {
        return arrayOf(ArgumentType.STRING)
    }
}
