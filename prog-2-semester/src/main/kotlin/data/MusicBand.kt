package data

import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable
import java.time.ZonedDateTime
import kotlin.random.Random

@Serializable
data class MusicBand(
    val name: String, //Поле не может быть null, Строка не может быть пустой
    val coordinates: Coordinates, //Поле не может быть null
    val numberOfParticipants: Int, //Значение поля должно быть больше 0
    val albumsCount: Long?, //Поле может быть null, Значение поля должно быть больше 0
    val description: String, //Поле не может быть null
    val genre: MusicGenre,  //Поле не может быть null
    val bestAlbum: Album?, //Поле может быть null
    val id: Int = generateId(),
    @Contextual
    val creationTime: ZonedDateTime = ZonedDateTime.now()
) : Comparable<MusicBand> {


    override fun compareTo(other: MusicBand): Int {
        return id - other.id;
    }
}

fun generateId(): Int {
    return Random.nextInt(0, Int.MAX_VALUE)
}
