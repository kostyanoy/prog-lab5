package di

import data.MusicBand
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

    factory<Serializer<LinkedHashMap<Int, MusicBand>>> {
        SerializeManager()
    }

    factory<Saver<LinkedHashMap<Int, MusicBand>>> {
        FileSaver("save.txt", serializer = get(), fileManager = get())
    }

    factory {
        FileManager()
    }

    single<Storage<LinkedHashMap<Int, MusicBand>, Int, MusicBand>> {
        StorageManager()
    }
        //да
    single<Interactor> {
        InteractionManager(userManager = get(), saver = get(), fileManager = get(), storage = get())
    }
}