package utils

import commands.Command

interface Interactor {
    fun getCommand(): Command
    fun start()
}
