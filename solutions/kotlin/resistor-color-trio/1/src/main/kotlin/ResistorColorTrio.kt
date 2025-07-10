import kotlin.math.pow

object ResistorColorTrio {
    fun text(vararg input: Color): String {
        val resistance = (input[0].ordinal * 10 + input[1].ordinal) * 10.0.pow(input[2].ordinal)
        return when {
            resistance >= 10.0.pow(6) -> "${(resistance / 10.0.pow(6)).toInt()} megaohms"
            resistance >= 10.0.pow(3) -> "${(resistance / 10.0.pow(3)).toInt()} kiloohms"
            else -> "${resistance.toInt()} ohms"
        }
    }
}
