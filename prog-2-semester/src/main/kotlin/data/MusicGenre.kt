package data

import kotlinx.serialization.Serializable

@Serializable
enum class MusicGenre {
    PROGRESSIVE_ROCK, HIP_HOP, PSYCHEDELIC_CLOUD_RAP, SOUL, POST_PUNK;

    companion object {
        fun valueOfOrNull(name: String): MusicGenre? {
            return values().firstOrNull { it.name == name }
        }
    }
}