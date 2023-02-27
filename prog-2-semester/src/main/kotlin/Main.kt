import di.appModule
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.context.startKoin
import utils.Interactor


fun main(args: Array<String>) {
    startKoin {
        modules(appModule)
    }

    Application().start()
}

class Application : KoinComponent {
    private val interactor by inject<Interactor>()

    fun start() {
        interactor.start()
    }
}

