package commands
import Exceptions.ParameterException
import utils.*

class RemoveGreater(interactor: Interactor, storage: Storage) : Command(interactor, storage) {
    override fun execute() {
        interactor.showMessage("Выполняется команда remove_greater")
        val collection = storage.getCollection()
        val element = interactor.getMusicBand()
        try {
            for(value in collection.values){
                if (element < value){
                    storage.remove(interactor.getInt(), element)} } }
        catch (e: ParameterException){ (e.message) }}}
