package commands
import Exceptions.ParameterException
import utils.*

class RemoveKey(interactor: Interactor, storage: Storage) : Command(interactor, storage){
    override fun execute() {
        interactor.showMessage("Выполняется команда removeKey")
        try {storage.removeKey(interactor.getInt()) }
        catch (e: ParameterException){ (e.message) } }}