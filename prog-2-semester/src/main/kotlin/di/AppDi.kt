package di

import org.koin.dsl.module
import utils.*
import utils.console.ConsoleManager
import utils.file.FileManager
import utils.file.FileSaver

val appModule = module {
    factory<ReaderWriter> {
        ConsoleManager()
    }

    factory<Saver> {
        FileSaver()
    }

    factory {
        FileManager()
    }

    single<Storage> {
        StorageManager()
    }

    factory<Interactor> {
        InteractionManager(userManager = get(), saver = get(), fileManager = get(), storage = get())
    }
}