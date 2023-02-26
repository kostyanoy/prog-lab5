package utils.console

import utils.Reader


class ConsoleReader : Reader {
    override fun readLine(): String = readln()
}