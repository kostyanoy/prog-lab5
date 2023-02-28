package data

import kotlinx.serialization.Serializable

@Serializable
data class Coordinates(
    val x: Float,
    val y: Double
)