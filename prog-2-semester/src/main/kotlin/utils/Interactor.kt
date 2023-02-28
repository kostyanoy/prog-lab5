package utils

import commands.Command
import data.MusicBand

interface Interactor {
    fun start()
    fun exit()
    fun save(collection: LinkedHashMap<Int, MusicBand>)
    fun load(): LinkedHashMap<Int, MusicBand>
    fun getString() : String
    fun getInt() : Int
    fun getMusicBand():MusicBand
    fun showMessage(message: String)
    //fun readCommandFile()

    fun showInvitation(message: String)
}
