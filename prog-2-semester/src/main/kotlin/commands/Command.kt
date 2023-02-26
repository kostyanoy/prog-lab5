package commands

import utils.Interactor
import utils.Storage

abstract class Command(val interactor: Interactor, val storage: Storage) {
    abstract fun execute()
}