
object ResistorColorDuo {

    fun value(vararg colours: Color): Int {
        return (colours[0].ordinal.toString() + colours[1].ordinal.toString()).toInt()
    }
}
