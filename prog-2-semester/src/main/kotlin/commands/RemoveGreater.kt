package commands

import utils.*

class RemoveGreater(interactor: Interactor, storage: Storage) : Command(interactor, storage) {
    override fun execute() {
        interactor.showMessage("Выполняется команда remove_greater")
        val collection = storage.getCollection()
        val useElement = interactor.getMusicBand()
        for (key in collection.keys) {
            if (useElement > collection[key]!!) {
                storage.removeKey(key)
            }
        }
    }
}
