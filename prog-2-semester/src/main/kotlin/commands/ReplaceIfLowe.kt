package commands

import exceptions.ParameterException

/**
 * The command replaces the value by the key if the new value is less than the old one.
 *
 * The condition is used to check the value by the key.
 * @exception [ParameterException] used if the element with the specified key does not exist.
 */
class ReplaceIfLowe : StorageCommand() {
    /**
    Returns a description of the command.
     */
    override fun getDescription() {
        interactor.showMessage("replace_if_lowe : заменить значение по ключу, если новое значение меньше старого")
    }

    override fun execute() {
        interactor.showMessage("Выполняется команда replace_if_lowe")
        val userKey = interactor.getInt()
        val collection = storage.getCollection { true }
        if (userKey !in collection.keys) {
            throw ParameterException("Элемента с таким ключом не существует")
        }
        val userElement = interactor.getMusicBand()
        if (userElement < collection[userKey]!!) {
            storage.update(userKey, userElement)
        }
    }
}


