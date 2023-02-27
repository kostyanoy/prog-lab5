package commands

import utils.*

class RemoveGreaterKey(interactor: Interactor, storage: Storage) : Command(interactor, storage) {
    override fun execute() {
        interactor.showMessage("Выполняется команда remove_greater_key")
        val collection = storage.getCollection()
        val userKey = interactor.getInt()
        for (key in collection.keys) {
            if (key > userKey) {
                storage.removeKey(key)
            }
        }
    }
}