package commands
import utils.*

class InsertNull(interactor: Interactor, storage: Storage) : Command(interactor, storage) {
    override fun execute() {
        interactor.showMessage("Выполняется команда insert")
        storage.insertNull(interactor.getInt(), interactor.getMusicBand())
}}