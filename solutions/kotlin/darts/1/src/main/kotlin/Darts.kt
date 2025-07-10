import kotlin.math.sqrt
import kotlin.math.pow

object Darts {

    fun score(x: Number, y: Number): Int {
        val distance = sqrt(x.toDouble().pow(2.0) + y.toDouble().pow(2.0))
        return when {
            distance > 10.0 -> 0
            distance > 5.0 -> 1
            distance > 1.0 -> 5
            else -> 10
        }
    }
}
