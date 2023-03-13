package commands

import exceptions.ParameterException
import utils.Interactor
import utils.Storage

/**
 * The command that updates the value of a collection item whose id is equal to the specified one
 *
 * @exception [ParameterException] used if the element with the specified key does not exist
 */
class Update(interactor: Interactor, storage: Storage) : Command(interactor, storage) {
    override fun execute() {
        interactor.showMessage("Выполняется команда update")
        val userKey = interactor.getInt()
        val collection = storage.getCollection { true }
        if (userKey !in collection.keys) {
            throw ParameterException("Элемента с таким ключом не существует")
        }
        storage.update(interactor.getInt(), interactor.getMusicBand())
    }
}
