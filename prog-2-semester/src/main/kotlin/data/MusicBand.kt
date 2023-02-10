package data

import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable
import java.time.ZonedDateTime

@Serializable
data class MusicBand(
    val id: Int, //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    val name: String, //Поле не может быть null, Строка не может быть пустой
    val coordinates: Coordinates, //Поле не может быть null
    @Contextual
    val creationDate: ZonedDateTime, //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    val numberOfParticipants: Int, //Значение поля должно быть больше 0
    val albumsCount: Long?, //Поле может быть null, Значение поля должно быть больше 0
    val description: String, //Поле не может быть null
    val genre: MusicGenre,  //Поле не может быть null
    val bestAlbum: Album? //Поле может быть null
) : Comparable<MusicBand> {

    override fun compareTo(other: MusicBand): Int {
        return id - other.id;
    }
}