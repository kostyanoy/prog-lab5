package commands

import utils.*

class RemoveGreater(interactor: Interactor, storage: Storage) : Command(interactor, storage) {
    override fun execute() {
        interactor.showMessage("Выполняется команда remove_greater")
        val collection = storage.getCollection()
        val element = interactor.getMusicBand()
        for (key in collection.keys) {
            if (element > collection[key]!!) {
                storage.removeKey(key)
            }
        }
    }
}
