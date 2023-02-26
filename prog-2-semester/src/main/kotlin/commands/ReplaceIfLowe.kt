package commands
import Exceptions.ParameterException
import utils.*

class ReplaceIfLowe(interactor: Interactor, storage: Storage) : Command(interactor, storage){
    override fun execute() {
        interactor.showMessage("Выполняется команда replace_if_lowe")
        val collection = storage.getCollection()
        val element = interactor.getMusicBand()
        try {
            for(value in collection.values){
                if (element < value){
                    storage.update(interactor.getInt(), element)} }
        }
        catch (e: ParameterException){ (e.message) }}}