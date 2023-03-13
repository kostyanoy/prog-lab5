package commands

import data.MusicBand
import org.koin.core.component.inject
import utils.Storage

abstract class StorageCommand : Command() {
    val storage: Storage<LinkedHashMap<Int, MusicBand>, Int, MusicBand> by inject()
}