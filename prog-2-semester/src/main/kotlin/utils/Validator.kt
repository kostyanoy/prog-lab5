package utils

import data.MusicBand
import data.MusicGenre

interface Validator {
    fun getInt(): Int
    fun getString(): String
    fun getGenre(): MusicGenre
    fun getMusicBand(): MusicBand
}