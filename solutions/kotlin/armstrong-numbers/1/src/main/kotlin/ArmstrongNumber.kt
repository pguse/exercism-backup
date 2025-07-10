import kotlin.math.pow

object ArmstrongNumber {

    fun check(input: Int): Boolean {
        input.toString().run {
            val sum = this.sumOf { it.digitToInt().toDouble().pow(this.length) }
            return input == sum.toInt()
        }
    }
}
