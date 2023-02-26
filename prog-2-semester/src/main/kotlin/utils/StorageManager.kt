package utils

import data.MusicBand

class StorageManager : Storage {
    val hashMap = LinkedHashMap<Int, MusicBand>()

    override fun getCollection(): LinkedHashMap<Int, MusicBand> = hashMap;
    override fun add(element: MusicBand) {
        TODO("Not yet implemented")
    }

    override fun insert() {
        TODO("Not yet implemented")
    }

    override fun remove() {
        TODO("Not yet implemented")
    }

    override fun clear() {
        TODO("Not yet implemented")
    }

}