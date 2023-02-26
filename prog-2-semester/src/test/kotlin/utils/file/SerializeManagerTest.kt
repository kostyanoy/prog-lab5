package utils.file

import data.Coordinates
import data.MusicBand
import data.MusicGenre
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import utils.serialize.SerializeManager
import java.time.ZonedDateTime

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class SerializeManagerTest{
    val serializer = SerializeManager()
    val band = MusicBand(
        1,
        "s",
        Coordinates(1.0f, 2.0),
        ZonedDateTime.now(),
        1,
        1,
        "s",
        MusicGenre.HIP_HOP,
        null
    )

    @Test
    fun `Serialized MusicBand should be equal to original`(){
        val serialized = serializer.serialize(linkedMapOf(1 to band))
        assertEquals(band, serializer.deserialize(serialized)[1])
    }

}