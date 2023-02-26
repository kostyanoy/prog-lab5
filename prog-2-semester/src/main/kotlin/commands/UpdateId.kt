package commands
import Exceptions.ParameterException
import utils.*

class UpdateId(interactor: Interactor, storage: Storage) : Command(interactor, storage){
    override fun execute() {
        interactor.showMessage("Выполняется команда update")
        try {storage.update(interactor.getInt(), interactor.getMusicBand()) }
        catch (e:ParameterException){ (e.message) } }}