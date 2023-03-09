package commands

import data.Coordinates
import data.MusicBand
import data.MusicGenre
import exceptions.ParameterException
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import utils.Interactor
import utils.StorageManager

internal class RemoveKeyTest {
    private val m1 = MusicBand("name1", Coordinates(1.0F, 1.0), 1, 1, "", MusicGenre.HIP_HOP, null)
    private val m2 = MusicBand("name2", Coordinates(2.0F, 2.0), 2, 2, "", MusicGenre.POST_PUNK, null)

    @Test
    fun `Remove key from non-empty collection`() {
        val interactor = mockk<Interactor>(relaxed = true)
        val storage = StorageManager()

        storage.insert(1, m1)
        storage.insert(2, m2)

        every { interactor.getInt() }.returns(2)

        val removeKeyCommand = RemoveKey(interactor, storage)
        removeKeyCommand.execute()

        assertNull(storage.getCollection()[2])
    }

    @Test
    fun `Remove key from empty collection throws ParameterException`() {
        val interactor = mockk<Interactor>(relaxed = true)
        val storage = StorageManager()

        every { interactor.getInt() }.returns(1)

        val removeKeyCommand = RemoveKey(interactor, storage)

        assertThrows<ParameterException> { removeKeyCommand.execute() }
    }
}