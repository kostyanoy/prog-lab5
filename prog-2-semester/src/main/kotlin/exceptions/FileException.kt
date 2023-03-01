package exceptions

class FileException(message: String?) : Throwable("Ошибка в файле команд: $message") {}