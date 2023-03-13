package commands

import utils.Interactor
import utils.Storage

/**
 * The command removes from the collection all items whose key exceeds the specified one
 *
 * The loop and condition are used to validate the key
 */
class RemoveGreaterKey(interactor: Interactor, storage: Storage) : Command(interactor, storage) {
    override fun execute() {
        interactor.showMessage("Выполняется команда remove_greater_key")
        val userKey = interactor.getInt()
        storage.getCollection { userKey < key }
            .forEach { storage.removeKey(it.key) }
    }
}