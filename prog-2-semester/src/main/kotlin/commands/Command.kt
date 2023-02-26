package commands
import utils.*

abstract class Command(open val interactor: Interactor, open val storage: Storage,) {
    abstract fun execute()
}
