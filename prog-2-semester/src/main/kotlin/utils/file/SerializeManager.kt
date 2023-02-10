package utils.file

import data.MusicBand

class SerializeManager : Serializer {
    override fun serialize(collection: LinkedHashMap<Int, MusicBand>): String {
        TODO("Not yet implemented")
    }

    override fun deserialize(json: String): LinkedHashMap<Int, MusicBand> {
        TODO("Not yet implemented")
    }
}