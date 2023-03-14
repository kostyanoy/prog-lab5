package commands

import utils.*

/**
 * The command outputs elements whose genre field value is less than the specified one
 *
 * The condition is used to compare the [genre] field from the collection and the one set by the user
 */
class FilterLessThanGenre : StorageCommand() {
    override fun execute() {
        interactor.showMessage("Выполняется команда filter_less_than_genre")
        val userGenre = interactor.getGenre()
        val message = buildString {
            storage.getCollection { userGenre > value.genre }
                .forEach(::appendLine)
        }
        interactor.showMessage(message)
    }
}