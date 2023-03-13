package commands

import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import utils.Interactor

abstract class Command : KoinComponent {
    val interactor: Interactor by inject()
    abstract fun execute()
}
