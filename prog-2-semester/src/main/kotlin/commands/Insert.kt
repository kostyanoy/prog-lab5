package commands

import exceptions.ParameterException
import utils.*

/**
 * The command adds a new element with the specified key
 *
 * @exception [ParameterException] used if the element with the specified key already exist
 */
class Insert(interactor: Interactor, storage: Storage) : Command(interactor, storage) {
    override fun execute() {
        interactor.showMessage("Выполняется команда insert")
        val userKey = interactor.getInt()
        val collection = storage.getCollection()
        if (userKey in collection.keys) {
            throw ParameterException("Элемент с таким ключом уже существует")
        }
        storage.insert(userKey, interactor.getMusicBand())
    }
}