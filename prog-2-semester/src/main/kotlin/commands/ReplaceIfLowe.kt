package commands

import exceptions.ParameterException
import utils.*

/**
 * The command replaces the value by the key if the new value is less than the old one
 *
 * The condition is used to check the value by the key
 * @exception [ParameterException] used if the element with the specified key does not exist
 */
class ReplaceIfLowe(interactor: Interactor, storage: Storage) : Command(interactor, storage) {
    override fun execute() {
        interactor.showMessage("Выполняется команда replace_if_lowe")
        val collection = storage.getCollection()
        val userKey = interactor.getInt()
        val userElement = interactor.getMusicBand()
        if (userKey !in collection.keys) {
            throw ParameterException("Элемента с таким ключом не существует")
        }
        if (userElement < collection[userKey]!!) {
            storage.update(userKey, userElement)
        }
    }
}


