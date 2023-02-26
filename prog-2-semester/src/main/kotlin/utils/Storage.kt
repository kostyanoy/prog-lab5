package utils

import data.MusicBand
import data.MusicGenre

interface Storage {
    fun getCollection():LinkedHashMap<Int, MusicBand>
    fun removeKey(id: Int)
    fun countGreaterThanDesc(element: MusicBand): Int
    fun filterLess(element: MusicBand): MusicGenre
    fun clear()
    fun getInfo()
    fun show()
    fun insertNull(id: Int, element: MusicBand)
    fun update(id: Int, element: MusicBand)
    fun remove(id:Int, element: MusicBand)
}