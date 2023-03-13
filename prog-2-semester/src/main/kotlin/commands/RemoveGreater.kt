package commands

import utils.Interactor
import utils.Storage

/**
 * The command removes from the collection all items that exceed the specified
 *
 * The loop and condition are used to validate the key
 */
class RemoveGreater(interactor: Interactor, storage: Storage) : Command(interactor, storage) {
    override fun execute() {
        interactor.showMessage("Выполняется команда remove_greater")
        val userElement = interactor.getMusicBand()
        storage.getCollection { userElement < value }
            .forEach { storage.removeKey(it.key) }
    }
}
