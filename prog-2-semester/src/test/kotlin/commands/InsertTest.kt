package commands

import data.Coordinates
import data.MusicBand
import data.MusicGenre
import exceptions.ParameterException
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import utils.Interactor
import utils.StorageManager

internal class InsertTest {
    private val m = MusicBand("name", Coordinates(1.0F, 1.0), 1, 1, "", MusicGenre.HIP_HOP, null)

    @Test
    fun `Insert MusicBand into empty collection`() {
        val interactor = mockk<Interactor>(relaxed = true)
        val storage = StorageManager()

        every { interactor.getInt() }.returns(1)
        every { interactor.getMusicBand() }.returns(m)

        val insertCommand = Insert(interactor, storage)
        insertCommand.execute()

        assertEquals(m, storage.getCollection { true }[1])
    }

    @Test
    fun `Insert throws ParameterException if exists`() {
        val interactor = mockk<Interactor>(relaxed = true)
        val storage = StorageManager()

        every { interactor.getInt() }.returns(1)
        every { interactor.getMusicBand() }.returns(m)

        val insertCommand = Insert(interactor, storage)
        insertCommand.execute()

        assertThrows<ParameterException> { insertCommand.execute() }
    }
}