package commands
import utils.*

class FilterLessThanGenre(interactor: Interactor, storage: Storage) : Command(interactor, storage) {
    override fun execute() {
        interactor.showMessage("Выполняется команда filter_less_than_genre")
        val collection = storage.getCollection()
        val userElement = interactor.getMusicBand()
        for (value in collection.values) {
            if (userElement.genre > value.genre) {
                interactor.showMessage(value.toString())
            }
        }
    }
}