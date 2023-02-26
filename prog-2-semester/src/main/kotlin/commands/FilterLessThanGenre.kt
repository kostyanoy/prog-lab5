package commands
import Exceptions.ParameterException
import utils.*

class FilterLessThanGenre(interactor: Interactor, storage: Storage) : Command(interactor, storage){
    override fun execute() {
        interactor.showMessage("Выполняется команда filter_less_than_genre")
        val collection = storage.getCollection()
        val element = interactor.getMusicBand()
        try {
            for(value in collection.values){
                if (element < value){
                    storage.filterLess(element)}}}
        catch (e: ParameterException){ (e.message) }}}