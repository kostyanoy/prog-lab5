package utils

import data.MusicBand

/**
 * Interface for interacting with the collection
 */
interface Storage {
    fun getCollection(predicate: Map.Entry<Int, MusicBand>.() -> Boolean): LinkedHashMap<Int, MusicBand>
    fun removeKey(id: Int)
    fun getInfo(): String
    fun insert(id: Int, element: MusicBand)
    fun update(id: Int, element: MusicBand)
    fun clear()
}