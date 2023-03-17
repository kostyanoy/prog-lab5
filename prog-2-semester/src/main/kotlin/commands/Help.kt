package commands

import utils.ArgumentType
import utils.CommandResult

/**
 * The command displays help for available commands
 */
class Help : Command() {
    override fun execute(args: ArrayList<Any>): CommandResult {
        return CommandResult.Success("Help",
            "Выполняется команда help" +
                    "\nhelp : вывести справку по доступным командам" +
                    "\ninfo : вывести в стандартный поток вывода информацию о коллекции" +
                    "\nshow : вывести в стандартный поток вывода все элементы коллекции в строковом представлении" +
                    "\ninsert : добавить новый элемент с заданным ключом" +
                    "\nupdate : обновить значение элемента коллекции, id которого равен заданному" +
                    "\nremoveKey : удалить элемент из коллекции по его ключу" +
                    "\nclear : очистить коллекцию" +
                    "\nsave : сохранить коллекцию в файл" +
                    "\nload : загрузить коллекцию из файла" +
                    "\nexecute_script : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме." +
                    "\nexit : завершить программу (без сохранения в файл)" +
                    "\nremove_greater : удалить из коллекции все элементы, превышающие заданный" +
                    "\nreplace_if_lowe : заменить значение по ключу, если новое значение меньше старого" +
                    "\nremove_greater_key : удалить из коллекции все элементы, ключ которых превышает заданный" +
                    "\ncount_greater_than_description : вывести количество элементов, значение поля description которых больше заданного" +
                    "\nfilter_less_than_genre : вывести элементы, значение поля genre которых меньше заданного"
        )
    }

    override fun getArgumentTypes(): Array<ArgumentType> {
        return arrayOf()
    }
}
//getDisc