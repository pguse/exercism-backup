package collatz_conjecture

// Returns the number of steps to get to a value of 1.
steps :: proc(start: int) -> (result: int, ok: bool) {
    //Edge Case #1: Non-positive starting values
    if start <= 0 {
        return 0, false
    }
    //Edge Case #2: Starting value of 1
    if start == 1 {
        return 0, true
    }
    // Appropriate starting values
    n := start
    for {
        if n % 2 == 0 {
            n /= 2
            result += 1
        } else {
            n = 3 * n + 1
            result += 1
        }
        if n == 1 {
            break
        }
    }
	return result, true
}
