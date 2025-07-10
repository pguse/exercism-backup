
enum class Classification {
    DEFICIENT, PERFECT, ABUNDANT
}

fun sumOfFactors(n: Int) : Int {
    require(n > 0) { "Only natural numbers can have a sum of factors" }
    return (1..n/2).filter { n % it == 0 }.sum()
}

fun classify(naturalNumber: Int): Classification =
    sumOfFactors(naturalNumber).let { sum ->
        when {
            naturalNumber < sum -> Classification.ABUNDANT
            naturalNumber > sum -> Classification.DEFICIENT
            else -> Classification.PERFECT
        }
    }
