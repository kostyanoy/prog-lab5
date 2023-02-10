package utils

import data.MusicBand

interface Loader {
    fun load(): LinkedHashMap<Int, MusicBand>}