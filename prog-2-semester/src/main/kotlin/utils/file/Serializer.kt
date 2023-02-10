package utils.file

import data.MusicBand

interface Serializer {
    fun serialize(collection: LinkedHashMap<Int, MusicBand>): String;
    fun deserialize(json: String): LinkedHashMap<Int, MusicBand>
}