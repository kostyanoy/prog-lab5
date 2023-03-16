package commands

import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import utils.Interactor


/**
 * An abstract class for defining commands.
 */
abstract class Command : KoinComponent {
    /**
    Returns a description of the command.
     */
    abstract fun getDescription()
    val interactor: Interactor by inject()
    abstract fun execute()
}
