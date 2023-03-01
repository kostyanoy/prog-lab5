package utils

import data.Album
import data.Coordinates
import data.MusicBand
import data.MusicGenre
import exceptions.FileException

class FileInteractor(
    private val interactor: Interactor,
    private val storage: Storage,
    private val lines: List<String>
) : Interactor by interactor {
    var index = 0
    var lastArgument: String? = null
    val commandManager = CommandManager(this, storage)

    override fun start() {
        while (hasNext()) {
            interact(lines[index])
            index++
        }
    }

    override fun exit() {
        interactor.exit()
        index = lines.count()
    }

    private fun interact(stringCommand: String) {
        val input = stringCommand.split(" ")
        if (input.count() > 2) {
            throw FileException("Слишком много аргументов в строке")
        }

        try {
            val command = commandManager.getCommand(input[0])
            lastArgument = if (input.count() == 2) input[1] else null
            command.execute()
        } catch (e: FileException) {
            throw e
        } catch (e: Throwable){
            throw FileException(e.message)
        }
    }


    override fun getString(): String {
        return lastArgument ?: throw FileException("Нет аргумента")
    }

    override fun getInt(): Int {
        return lastArgument?.toIntOrNull() ?: throw FileException("Не Int")
    }

    override fun getMusicBand(): MusicBand {
        val name = next()
        val coordinates = Coordinates(
            next().toFloatOrNull() ?: throw FileException("Не Float"),
            next().toDoubleOrNull() ?: throw FileException("Не Double")
        )
        val numberOfParticipants = next().toIntOrNull() ?: throw FileException("Не Int")
        val albumsCount = next().toLongOrNull()
        val description = next()
        val genre = MusicGenre.valueOfOrNull(next()) ?: throw FileException("Не MusicBand")
        var album: Album? = null
        val albumName = next()
        if (albumName.isNotEmpty()) {
            val albumLength = next().toLongOrNull() ?: throw FileException("Не Long")
            album = Album(albumName, albumLength)
        }
        return MusicBand(
            name = name,
            coordinates = coordinates,
            numberOfParticipants = numberOfParticipants,
            albumsCount = albumsCount,
            description = description,
            genre = genre,
            bestAlbum = album
        )
    }

    fun next(): String {
        if (hasNext()) return lines[index++]
        throw FileException("Недостаточно строк")
    }

    fun hasNext(): Boolean = (index < lines.count())
}