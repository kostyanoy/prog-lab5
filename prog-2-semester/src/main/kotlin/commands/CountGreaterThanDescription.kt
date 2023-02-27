package commands

import utils.*

class CountGreaterThanDescription(interactor: Interactor, storage: Storage) : Command(interactor, storage) {
    override fun execute() {
        interactor.showMessage("Выполняется команда count_greater_than_description")
        val collection = storage.getCollection()
        val element = interactor.getMusicBand()
        var countDescription = 0
        for (value in collection.values) {
            if (element.description > value.description) {
                countDescription++
            }
        }
        interactor.showMessage(countDescription.toString())
    }
}

