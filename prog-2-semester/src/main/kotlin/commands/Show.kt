package commands
import utils.*

class Show(interactor: Interactor, storage: Storage) : Command(interactor, storage){
    override fun execute() {
        interactor.showMessage("Выполняется команда show")
        storage.show()
}}
