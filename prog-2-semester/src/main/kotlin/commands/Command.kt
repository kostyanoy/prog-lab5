package commands

import utils.*

abstract class Command(val interactor: Interactor, val storage: Storage) {
    abstract fun execute()

}
