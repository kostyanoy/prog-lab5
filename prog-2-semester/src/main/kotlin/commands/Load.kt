package commands

import utils.*

class Load(interactor: Interactor, storage: Storage) : Command(interactor, storage) {
    override fun execute() {
        interactor.showMessage("Выполняется команда load")
        val savedCollection = interactor.load()
        storage.clear()
        for ((key, value) in savedCollection){
            storage.insert(key, value)
        }
    }
}