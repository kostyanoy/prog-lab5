package data

import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable
import java.time.ZonedDateTime

@Serializable
data class MusicBand(
    val id: Int,
    val name: String,
    val coordinates: Coordinates,
    @Contextual
    val creationDate: ZonedDateTime,
    val numberOfParticipants: Int,
    val albumsCount: Long?,
    val description: String,
    val genre: MusicGenre,
    val bestAlbum: Album?,
) : Comparable<MusicBand> {
    override fun compareTo(other: MusicBand): Int {
        return id - other.id;
}}