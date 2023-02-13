package data

import kotlinx.serialization.Serializable

@Serializable
data class Coordinates(
    val x: Float, //Максимальное значение поля: 552, Поле не может быть null
    val y: Double //Поле не может быть null
)