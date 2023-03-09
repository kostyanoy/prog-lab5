package di

import org.koin.dsl.module
import utils.*
import utils.console.ConsoleManager
import utils.file.FileManager
import utils.file.FileSaver
import utils.serialize.SerializeManager
import utils.serialize.Serializer

val appModule = module {
    factory<ReaderWriter> {
        ConsoleManager()
    }

    factory<Serializer> {
        SerializeManager()
    }

    factory<Saver> {
        FileSaver("save.txt", serializer = get(), fileManager = get())
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