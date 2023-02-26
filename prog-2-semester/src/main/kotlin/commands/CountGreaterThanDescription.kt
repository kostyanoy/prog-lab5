package commands
import Exceptions.ParameterException
import utils.*

class CountGreaterThanDescription(interactor: Interactor, storage: Storage) : Command(interactor, storage){
    override fun execute() {
        interactor.showMessage("Выполняется команда count_greater_than_description")
        val collection = storage.getCollection()
        val element = interactor.getMusicBand()
        try {
            for(value in collection.values){
                if (element > value){
                    storage.countGreaterThanDesc(element)}}}
        catch (e: ParameterException){ (e.message) }}}
