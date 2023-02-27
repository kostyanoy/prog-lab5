package utils

import data.MusicBand

interface Storage {
    fun getCollection():LinkedHashMap<Int, MusicBand>
    fun removeKey(id: Int)
    fun getInfo()
    fun insertNull(id: Int, element: MusicBand)
    fun update(id: Int, element: MusicBand)

}