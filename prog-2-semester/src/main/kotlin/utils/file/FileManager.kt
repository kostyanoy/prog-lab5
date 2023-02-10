package utils.file

import data.MusicBand
import utils.Loader
import utils.Reader
import utils.Saver

class FileManager : Loader, Saver {
    val serializer: Serializer = SerializeManager();

    override fun load(): LinkedHashMap<Int, MusicBand> {
        TODO("Not yet implemented")
    }

    override fun save(collection: LinkedHashMap<Int, MusicBand>) {
        TODO("Not yet implemented")
    }

    fun readFile(path: String): String {
        TODO("Not yet implemented")
    }
}