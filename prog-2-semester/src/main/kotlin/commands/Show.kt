package commands

import utils.*
import kotlin.text.StringBuilder

/**
 * The command outputs all the elements of the collection in a string representation to the standard output stream
 */
class Show(interactor: Interactor, storage: Storage) : Command(interactor, storage) {
    override fun execute() {
        interactor.showMessage("Выполняется команда show")
        val message = buildString {
            appendLine("Коллекция содержит: ")
            storage.getCollection { true }
                .forEach { appendLine(it.value) }
        }
        interactor.showMessage(message)
    }
}
