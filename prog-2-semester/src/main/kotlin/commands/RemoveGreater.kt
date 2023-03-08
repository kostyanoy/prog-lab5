package commands

import utils.*

/**
 * The command removes from the collection all items that exceed the specified
 *
 * The loop and condition are used to validate the key
 */
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
