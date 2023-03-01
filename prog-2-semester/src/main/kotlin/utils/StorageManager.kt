package utils

import data.MusicBand
import java.time.LocalDateTime

class StorageManager() : Storage {
    private val date: LocalDateTime = LocalDateTime.now()
    val musicBandCollection = LinkedHashMap<Int, MusicBand>()

    override fun getInfo(): String {
        return ("Коллекция  ${this.javaClass} \nтип: LinkedHashMap количество элементов  ${musicBandCollection.size} \nдата инициализации $date")
    }

    override fun insert(id: Int, element: MusicBand) {
        musicBandCollection[id] = element
    }

    override fun update(id: Int, element: MusicBand) {
        musicBandCollection[id] = element
    }

    override fun clear() {
        musicBandCollection.clear()
    }

    override fun removeKey(id: Int) {
        musicBandCollection.remove(id)
    }

    override fun getCollection(): LinkedHashMap<Int, MusicBand> {
        return musicBandCollection
    }
}


