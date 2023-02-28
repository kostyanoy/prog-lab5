package commands

import utils.*

class ReplaceIfLowe(interactor: Interactor, storage: Storage) : Command(interactor, storage) {
    override fun execute() {
        interactor.showMessage("Выполняется команда replace_if_lowe")
        val collection = storage.getCollection()
        val userKey = interactor.getInt()
        val userElement = interactor.getMusicBand()
        if (userElement < collection[userKey]!!) {
            storage.update(userKey, userElement)
        }
    }
}

