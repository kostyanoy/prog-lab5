package commands

import utils.*
import kotlin.text.StringBuilder

class Show(interactor: Interactor, storage: Storage) : Command(interactor, storage) {
    override fun execute() {
        interactor.showMessage("Выполняется команда show")
        val message = StringBuilder("Коллекция содержит: ")
        for (musicBand in storage.getCollection()) {
            message.append("\n$musicBand")
        }
        interactor.showMessage(message.toString())
    }
}
