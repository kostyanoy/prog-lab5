package commands

import kotlin.text.StringBuilder

/**
 * The command outputs all the elements of the collection in a string representation to the standard output stream
 */
class Show : StorageCommand() {
    override fun execute() {
        interactor.showMessage("Выполняется команда show")
        val message = StringBuilder("Коллекция содержит: ")
        for (musicBand in storage.getCollection()) {
            message.append("\n$musicBand")
        }
        interactor.showMessage(message.toString())
    }
}
