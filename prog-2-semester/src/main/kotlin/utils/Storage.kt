package utils

import data.MusicBand

interface Storage {
    fun getCollection(): LinkedHashMap<Int, MusicBand>
    fun add(element: MusicBand)

}