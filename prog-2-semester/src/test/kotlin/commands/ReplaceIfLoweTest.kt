package commands

import data.Coordinates
import data.MusicBand
import data.MusicGenre
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import utils.Interactor
import utils.StorageManager

internal class ReplaceIfLoweTest {
    private val m1 = MusicBand("name1", Coordinates(1.0F, 1.0), 1, 1, "", MusicGenre.HIP_HOP, null)
    private val m2 = MusicBand("name2", Coordinates(2.0F, 2.0), 2, 2, "", MusicGenre.POST_PUNK, null)

    @Test
    fun `Replace MusicBand if user element is lower than current element`() {
        val interactor = mockk<Interactor>(relaxed = true)
        val storage = StorageManager()

        every { interactor.getInt() }.returns(1)
        every { interactor.getMusicBand() }.returns(m1)

        storage.insert(1,m2)

        val replaceIfLowerCommand = ReplaceIfLowe(interactor, storage)
        replaceIfLowerCommand.execute()

        assertEquals(m1, storage.getCollection()[1])
    }
}