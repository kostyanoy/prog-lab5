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
import org.junit.jupiter.api.extension.RegisterExtension
import org.koin.core.component.inject
import org.koin.dsl.module
import org.koin.test.KoinTest
import org.koin.test.junit5.KoinTestExtension
import utils.Interactor
import utils.Storage
import utils.StorageManager

internal class InsertTest : KoinTest {
    private val m = MusicBand("name", Coordinates(1.0F, 1.0), 1, 1, "", MusicGenre.HIP_HOP, null)

    private val storage: Storage<LinkedHashMap<Int, MusicBand>, Int, MusicBand> by inject()

    @JvmField
    @RegisterExtension
    val koinTestExtension = KoinTestExtension.create {
        modules(module {
            single<Interactor> {
                val interactor = mockk<Interactor>(relaxed = true)
                every { interactor.getInt() }.returns(1)
                every { interactor.getMusicBand() }.returns(m)
                interactor
            }
            single<Storage<LinkedHashMap<Int, MusicBand>, Int, MusicBand>> { StorageManager() }
        })
    }


    @Test
    fun `Insert MusicBand into empty collection`() {
        val insertCommand = Insert()
        insertCommand.execute()

        assertEquals(m, storage.getCollection { true }[1])
        assertEquals(1, storage.getCollection { true }.count())
    }

    @Test
    fun `Insert throws ParameterException if exists`() {
        val insertCommand = Insert()
        insertCommand.execute()

        assertThrows<ParameterException> {
            insertCommand.execute()
        }
    }
}