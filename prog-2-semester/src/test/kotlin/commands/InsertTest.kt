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
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.context.GlobalContext.startKoin
import org.koin.dsl.module
import utils.Interactor
import utils.StorageManager

internal class InsertTest : KoinComponent {
    private val m = MusicBand("name", Coordinates(1.0F, 1.0), 1, 1, "", MusicGenre.HIP_HOP, null)

    @Test
    fun `Insert MusicBand into empty collection`() {
        startKoin(
            module {
                single {
                    val interactor = mockk<Interactor>(relaxed = true)
                    every { interactor.getInt() }.returns(1)
                    every { interactor.getMusicBand() }.returns(m)
                    interactor
                }
                single { StorageManager() }
            })

        val insertCommand = Insert()
        insertCommand.execute()

<<<<<<< HEAD
        val storage = inject<StorageManager>()
        assertEquals(m, inject<StorageManager>().getCollection()[1])
=======
        assertEquals(m, storage.getCollection { true }[1])
>>>>>>> bfee7e0 (Storage.getCollection now takes lambda for filtering values)
    }

    @Test
    fun `Insert throws ParameterException if exists`() {
        val interactor = mockk<Interactor>(relaxed = true)
        val storage = StorageManager()

        every { interactor.getInt() }.returns(1)
        every { interactor.getMusicBand() }.returns(m)

        val insertCommand = Insert()
        insertCommand.execute()

        assertThrows<ParameterException> { insertCommand.execute() }
    }
}