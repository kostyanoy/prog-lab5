package data

import kotlinx.serialization.Serializable
import javax.management.InvalidAttributeValueException

@Serializable
class Coordinates {
    constructor(_x: Float, _y: Double){
        x = _x
        y = _y
    }

    var x: Float
        set(value) {
            if (value > 552)
                throw InvalidAttributeValueException("Значение должно быть меньше 552!")
            field = value
        }  //Максимальное значение поля: 552, Поле не может быть null
    val y: Double //Поле не может быть null
}