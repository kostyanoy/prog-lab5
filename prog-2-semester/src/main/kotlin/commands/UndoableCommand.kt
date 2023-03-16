package commands

import data.MusicBand
/**

An abstract class that represents an undoable command that operates on a storage of music bands.

It extends the [StorageCommand] class and provides an [undo] method to reverse the effects of the command.

@property [previousKey] The key of the element that was affected by the command, used to undo the command.

@property [previousElement] The previous element that was removed or modified by the command, used to undo the command.
 */
abstract class UndoableCommand : StorageCommand() {
    var previousKey: Int? = null
    var previousElement: MusicBand? = null
    abstract fun undo()
}