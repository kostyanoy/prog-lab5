package commands

import utils.*

/**
 * The command outputs the number of elements whose description field value is greater than the specified one
 *
 * @property [countDescription] counts the number of elements of the [description] field
 * The condition is used to compare the [description] field from the collection and the one set by the user
 */
class CountGreaterThanDescription : StorageCommand() {
    override fun execute(): CommandResult {
        val userDescription = interactor.getString()
        val countDescription = storage.getCollection { userDescription < value.description }
            .count()
        return CommandResult.Success("Count_greater_than_description", "$countDescription")
    }
}

