package commands

import exceptions.ParameterException
import utils.*

class Update(interactor: Interactor, storage: Storage) : Command(interactor, storage) {
    override fun execute() {
        interactor.showMessage("Выполняется команда update")
        val userKey = interactor.getInt()
        val collection = storage.getCollection()
        if (userKey !in collection.keys) {
            throw ParameterException("Элемента с таким ключом не существует")
        }
        storage.update(interactor.getInt(), interactor.getMusicBand())
    }
}
