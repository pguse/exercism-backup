object SumOfMultiples {

    fun sum(factors: Set<Int>, limit: Int): Int {
        return factors.filter { it > 0 }.map { it..<limit step it }.flatten().toSet().sum()
    }
}
