package commands

import exceptions.ParameterException
import utils.*

class RemoveKey(interactor: Interactor, storage: Storage) : Command(interactor, storage) {
    override fun execute() {
        interactor.showMessage("Выполняется команда removeKey")
        val userKey = interactor.getInt()
        val collection = storage.getCollection()
        storage.removeKey(interactor.getInt())
        if (userKey !in collection.keys) {
            throw ParameterException("Элемента с таким ключом не существует")
        }

    }
}
