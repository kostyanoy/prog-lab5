package utils.file

import data.MusicBand
import utils.Saver
import utils.serialize.SerializeManager
import utils.serialize.Serializer

/**
 * Implements the [Saver] interface with file
 *
 * @param pathToSaveFile the path to the save file
 * @param serializer implementation of the [Serializer] interface used to serialize the collection
 * @param fileManager used to work with files
 */
class FileSaver(
    private val pathToSaveFile: String = "save.txt",
    private val serializer: Serializer = SerializeManager(),
    private val fileManager: FileManager = FileManager()
) : Saver {
    /**
     * Loads the [LinkedHashMap] collection from the save file
     *
     * @return [LinkedHashMap] collection deserialized from the content of the save file
     */
    override fun load(): LinkedHashMap<Int, MusicBand> =
        serializer.deserialize(fileManager.readFile(pathToSaveFile))

    /**
     * Saves the [LinkedHashMap] collection to the save file, serializes the collection
     *
     * @param collection the [LinkedHashMap] that should be saved to file
     */
    override fun save(collection: LinkedHashMap<Int, MusicBand>) {
        fileManager.writeFile(pathToSaveFile, serializer.serialize(collection))
    }
}