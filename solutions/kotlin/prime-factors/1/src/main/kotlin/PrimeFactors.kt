object PrimeFactorCalculator {

    fun primeFactors(int: Int): List<Int> {
        var number = int
        val factors = mutableListOf<Int>()
        var divisor = 2
        while (divisor * divisor <= number) {
            while (number % divisor == 0) {
                factors.add(divisor)
                number /= divisor
            }
            divisor++
        }
        if (number > 1) factors.add(number)
        return factors
    }

    fun sieve(limit: Int): List<Int> {
        val isPrime = BooleanArray(limit + 1) { true }
        isPrime[0] = false
        isPrime[1] = false
        for (i in 2..Math.sqrt(limit.toDouble()).toInt()) {
            if (isPrime[i]) {
                for (j in i * i..limit step i) {
                    isPrime[j] = false
                }
            }
        }
        return isPrime.indices.filter { isPrime[it] }
    }
    
    fun primeFactors(long: Long): List<Long> {
        var number = long
        val primes = sieve(Math.sqrt(number.toDouble()).toInt())
        val factors = mutableListOf<Long>()
        for (prime in primes) {
            while (number % prime == 0L) {
                factors.add(prime.toLong())
                number /= prime
            }
            if (number == 1L) break
        }
        if (number > 1) factors.add(number)
        return factors
    }
}
