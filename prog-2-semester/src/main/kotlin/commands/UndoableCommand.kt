package commands

import data.MusicBand
import utils.CommandResult

abstract class UndoableCommand : StorageCommand() {
    var previousKey: Int? = null
    var previousElement: MusicBand? = null
    abstract fun undo() : CommandResult
}