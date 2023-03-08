package commands
import utils.*
/**
 * The command outputs elements whose genre field value is less than the specified one
 *
 * The condition is used to compare the [genre] field from the collection and the one set by the user
 */
class FilterLessThanGenre(interactor: Interactor, storage: Storage) : Command(interactor, storage) {
    override fun execute() {
        interactor.showMessage("Выполняется команда filter_less_than_genre")
        val collection = storage.getCollection()
        val userGenre = interactor.getGenre()
        for (value in collection.values) {
            if (userGenre > value.genre) {
                interactor.showMessage(value.toString())
            }
        }
    }
}