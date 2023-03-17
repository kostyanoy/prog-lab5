package commands

import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import utils.ArgumentType
import utils.CommandResult
import utils.Interactor

abstract class Command : KoinComponent {
    val interactor: Interactor by inject()
    abstract fun execute(args: ArrayList<Any>) : CommandResult
    abstract fun getArgumentTypes() : Array<ArgumentType>
}
