package commands

import utils.*

class Show(interactor: Interactor, storage: Storage) : Command(interactor, storage) {
    override fun execute() {
        interactor.showMessage("Выполняется команда show")
        for (musicBand in storage.getCollection()) {
            interactor.showMessage(musicBand.toString())
        }
    }
}
