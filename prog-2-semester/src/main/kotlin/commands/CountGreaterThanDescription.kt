package commands

import utils.*

class CountGreaterThanDescription(interactor: Interactor, storage: Storage) : Command(interactor, storage) {
    override fun execute() {
        interactor.showMessage("Выполняется команда count_greater_than_description")
        val collection = storage.getCollection()
        val userDescription = interactor.getString()
        var countDescription = 0
        for (value in collection.values) {
            if (userDescription < value.description) {
                countDescription++
            }
        }
        interactor.showMessage(countDescription.toString())
    }
}

