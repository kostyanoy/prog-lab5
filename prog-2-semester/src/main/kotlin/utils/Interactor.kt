package utils

import data.MusicBand

interface Interactor {
    fun start()
    fun exit()
    fun save()
    fun load(): LinkedHashMap<Int, MusicBand>
    fun getString() : String
    fun getInt() : Int
    fun getMusicBand(): MusicBand
    fun showMessage(message: String)
    fun getCommand()
    fun getCollection()
}