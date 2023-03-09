package utils

import data.MusicBand

/**
 * Saves and loads [LinkedHashMap] collection
 */
interface Saver {
    /**
     * Save [collection] for loading in the future
     *
     * @param collection that must be saved
     */
    fun save(collection: LinkedHashMap<Int, MusicBand>)

    /**
     * Loads saved [LinkedHashMap] collection
     *
     * @return loaded previously saved collection
     */
    fun load(): LinkedHashMap<Int, MusicBand>
}