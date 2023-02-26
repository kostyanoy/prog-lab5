package commands
import Exceptions.ParameterException
import utils.*

class RemoveGreaterKey(interactor: Interactor, storage: Storage) : Command(interactor, storage){
    override fun execute() {
        interactor.showMessage("Выполняется команда remove_greater_key")
        val collection = storage.getCollection()
        val element = interactor.getMusicBand()
        try {
            for(key in collection.keys){
                if (element > collection[key]!!){
                    storage.removeKey(interactor.getInt())}}}
        catch (e: ParameterException){ (e.message) }}}