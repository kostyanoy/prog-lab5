package commands

import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertTimeout
import org.junit.jupiter.api.function.Executable
import utils.Interactor
import utils.Storage
import java.time.Duration

internal class ExecuteScriptTest{
    @Test
    fun `Prevent cycle of files`() {
        val interactor = mockk<Interactor>(relaxed = true)
        val storage = mockk<Storage>()

        every { interactor.getString() } returns "src/test/kotlin/script1.txt"

        val command = ExecuteScript(interactor, storage)

        assertTimeout(Duration.ofSeconds(1), Executable { command.execute() })
    }
}