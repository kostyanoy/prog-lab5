package utils

import data.MusicBand

/**
 * Interface for interacting with the collection
 */
interface Storage<T, K, V> {
    fun getCollection():T
    fun removeKey(id: K)
    fun getInfo(): String
    fun insert(id: K, element: V)
    fun update(id: K, element: V)
    fun clear()
}