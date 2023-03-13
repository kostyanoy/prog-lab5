package commands

import data.MusicBand
abstract class UndoCommand : StorageCommand() {
    var previousKey: Int? = null
    var previousElement: MusicBand? = null
    abstract fun undo()
}