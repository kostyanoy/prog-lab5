package commands

import exceptions.ParameterException
import utils.*

/**
 * The command removes an item from the collection by its key
 *
 * @exception [ParameterException] used if the element with the specified key does not exist
 */
class RemoveKey(interactor: Interactor, storage: Storage) : Command(interactor, storage) {
    override fun execute() {
        interactor.showMessage("Выполняется команда removeKey")
        val userKey = interactor.getInt()
        val collection = storage.getCollection()
        if (userKey !in collection.keys) {
            throw ParameterException("Элемента с таким ключом не существует")
        }
        storage.removeKey(interactor.getInt())
    }
}
