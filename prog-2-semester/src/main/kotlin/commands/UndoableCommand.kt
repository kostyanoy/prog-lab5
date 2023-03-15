package commands

import data.MusicBand
abstract class UndoableCommand : StorageCommand() {
    var previousKey: Int? = null
    var previousElement: MusicBand? = null
    abstract fun undo()
}