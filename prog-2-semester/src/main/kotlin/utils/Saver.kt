package utils

import data.MusicBand

interface Saver {
    fun save(collection: LinkedHashMap<Int, MusicBand>)
}