package utils.file

import data.MusicBand
import utils.Saver
import utils.serialize.SerializeManager
import utils.serialize.Serializer
import java.util.*

class FileSaver(
    private val pathToSaveFile: String = "save.txt",
    private val serializer: Serializer = SerializeManager(),
    private val fileManager: FileManager = FileManager()
) : Saver {

    override fun load(): LinkedHashMap<Int, MusicBand> =
        serializer.deserialize(fileManager.readFile(pathToSaveFile))

    override fun save(collection: LinkedHashMap<Int, MusicBand>) {
        fileManager.writeFile(pathToSaveFile, serializer.serialize(collection))
    }
}