package commands

import exceptions.CommandException
import io.mockk.mockk
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import utils.CommandManager
import utils.Interactor
import utils.StorageManager

class CommandManagerTest {
    @Test
    fun `Get existing command`() {
        val interactor = mockk<Interactor>(relaxed = true)
        val storage = StorageManager()
        val commandManager = CommandManager(interactor, storage)

        val command = "info"
        val expectedCommand = Info(interactor, storage)

        val realCommand = commandManager.getCommand(command)

        assertEquals(expectedCommand.javaClass, realCommand.javaClass)
    }

    @Test
    fun `CommandManager throws CommandException if command does not exist `() {
        val interactor = mockk<Interactor>(relaxed = true)
        val storage = StorageManager()
        val commandManager = CommandManager(interactor, storage)

        val command = "unknown"

        assertThrows<CommandException> { commandManager.getCommand(command) }
    }
}