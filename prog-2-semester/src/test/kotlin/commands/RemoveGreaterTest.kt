package commands

import data.Coordinates
import data.MusicBand
import data.MusicGenre
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import utils.Interactor
import utils.StorageManager

internal class RemoveGreaterTest {
    private val m1 = MusicBand("name1", Coordinates(1.0F, 1.0), 1, 1, "", MusicGenre.HIP_HOP, null)
    private val m2 = MusicBand("name2", Coordinates(2.0F, 2.0), 2, 2, "", MusicGenre.POST_PUNK, null)
    @Test
    fun `RemoveGreater removes all elements with greater keys`() {
        val interactor = mockk<Interactor>(relaxed = true)
        val storage = StorageManager()

        storage.insert(1, m1)
        storage.insert(2, m2)

        every { interactor.getInt() }.returns(1)
        every { interactor.getMusicBand() }.returns(m1)

        val removeGreaterCommand = RemoveGreater(interactor, storage)
        removeGreaterCommand.execute()

        assertEquals(1, storage.getCollection().size)
        assertTrue(storage.getCollection().containsKey(1))
        assertFalse(storage.getCollection().containsKey(2))
    }

}