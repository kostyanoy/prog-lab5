package commands

import io.mockk.mockk
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import utils.CommandManager
import utils.Interactor
import utils.StorageManager

class CommandManagerTest {
    /**
     * Checking for the existence of a command
     */
    @Test
    fun testGetExistingCommand() {
        val interactor = mockk<Interactor>(relaxed = true)
        val storage = StorageManager()
        val commandManager = CommandManager(interactor, storage)
        val command = commandManager.getCommand("help")
        assertNotNull(command)
    }
}