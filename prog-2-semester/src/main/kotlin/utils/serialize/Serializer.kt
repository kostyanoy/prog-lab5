package utils.serialize

import data.MusicBand

/**
 * Interface for serialization of [LinkedHashMap]
 */
interface Serializer {
    /**
     * Serialize [LinkedHashMap] collection to [String]
     *
     * @param collection the [LinkedHashMap] collection that will be serialized
     * @return serialized [String]
     */
    fun serialize(collection: LinkedHashMap<Int, MusicBand>): String

    /**
     * Deserialize [LinkedHashMap] collection from [String]
     *
     * @param serialized the serialized [String] that will be deserialized
     * @return deserialized [LinkedHashMap] collection
     */
    fun deserialize(serialized: String): LinkedHashMap<Int, MusicBand>
}