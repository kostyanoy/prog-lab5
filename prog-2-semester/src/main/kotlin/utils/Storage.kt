package utils

import data.MusicBand

/**
 * Interface for interacting with the collection
 */
interface Storage {
    fun getCollection(): LinkedHashMap<Int, MusicBand>
    fun removeKey(id: Int)
    fun getInfo(): String
    fun insert(id: Int, element: MusicBand)
    fun update(id: Int, element: MusicBand)
    fun clear()
}