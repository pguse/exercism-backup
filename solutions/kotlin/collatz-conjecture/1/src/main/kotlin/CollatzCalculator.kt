object CollatzCalculator {
    fun computeStepCount(start: Int): Int {
        require(start > 0) { "Only positive numbers allowed" }
        var steps = 0
        var n = start
        while (n != 1) {
            if (n % 2 == 0) {
                n /= 2
                steps++
            } else {
                n = 3 * n + 1
                steps++
            }
        }

        return steps
    }
}
