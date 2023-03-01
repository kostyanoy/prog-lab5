package utils

import data.MusicBand
import data.MusicGenre

interface Interactor {
    fun start()
    fun exit()
    fun save(collection: LinkedHashMap<Int, MusicBand>)
    fun load(): LinkedHashMap<Int, MusicBand>
    fun showMessage(message: String)
    fun showInvitation(message: String)
    fun getString(): String
    fun getInt(): Int
    fun getGenre(): MusicGenre
    fun getMusicBand(): MusicBand
    fun executeCommandFile(path: String)
}
