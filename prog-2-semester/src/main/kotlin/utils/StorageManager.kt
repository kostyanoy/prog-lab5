package utils

import data.MusicBand
import java.time.LocalDateTime

class StorageManager(interactor: Interactor) : Storage {
    private val date: LocalDateTime = LocalDateTime.now()
    val musicBandCollection = LinkedHashMap<Int, MusicBand>()

    override fun getInfo() {
        println("Коллекция  ${this.javaClass} \nтип: LinkedHashMap количество элементов  ${musicBandCollection.size} \nдата инициализации $date")
    }

    override fun insertNull(id: Int, element: MusicBand) {
        musicBandCollection.put(id, element)
    }

    override fun update(id: Int, element: MusicBand) {
        musicBandCollection.set(id, element)
    }

    override fun removeKey(id: Int) {
        musicBandCollection.remove(id)
    }

    override fun getCollection(): LinkedHashMap<Int, MusicBand> {
        return musicBandCollection
    }
}


