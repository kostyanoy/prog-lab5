package exceptions

class CommandFileException(message: String?) : Throwable("Ошибка в файле команд: $message") {}