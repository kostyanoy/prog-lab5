package utils

import commands.Command

class InteractionManager(val reader: Reader, val writer: Writer) : Interactor {

    override fun getCommand(): Command {
        TODO("Not yet implemented")
    }
}