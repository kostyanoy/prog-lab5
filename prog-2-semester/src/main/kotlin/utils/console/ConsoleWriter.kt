package utils.console

import utils.Writer

class ConsoleWriter: Writer {
    override fun writeLine(text: String) = println(text)
    override fun write(text: String) = print(text)
}