package utils.file

import data.MusicBand
import utils.Loader
import utils.Saver
import java.io.BufferedWriter
import java.io.File
import java.io.FileOutputStream
import java.io.OutputStreamWriter
import java.lang.StringBuilder
import java.util.Scanner

class FileManager : Loader, Saver {
    private val serializer: Serializer = SerializeManager()
    private val file = File("save.txt")

    override fun load(): LinkedHashMap<Int, MusicBand> =
        serializer.deserialize(Scanner(file).nextLine())

    override fun save(collection: LinkedHashMap<Int, MusicBand>) {
        FileOutputStream(file).use { fos ->
            OutputStreamWriter(fos, Charsets.UTF_8).use { osw ->
                BufferedWriter(osw).use { bf -> bf.write(serializer.serialize(collection)) }
            }
        }
    }

    fun readFile(path: String): String {
        val scanner = Scanner(File(path))
        return buildString {
            while (scanner.hasNextLine()){
                append(scanner.nextLine() + "\n")
            }
        }
    }
}