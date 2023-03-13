package commands

import utils.*

/**
 * The command outputs the number of elements whose description field value is greater than the specified one
 *
 * @property [countDescription] counts the number of elements of the [description] field
 * The condition is used to compare the [description] field from the collection and the one set by the user
 */
class CountGreaterThanDescription : StorageCommand() {
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

