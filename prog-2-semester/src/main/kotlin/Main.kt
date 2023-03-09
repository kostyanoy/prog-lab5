import di.appModule
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.context.startKoin
import utils.Interactor

/**
 * Main function that starts the application
 */
fun main(args: Array<String>) {
    startKoin {
        modules(appModule)
    }

    Application().start()
}

/**
 * Class of the application, uses the DI to get parameters
 */
class Application : KoinComponent {
    private val interactor by inject<Interactor>()

    fun start() {
        interactor.start()
    }
}

