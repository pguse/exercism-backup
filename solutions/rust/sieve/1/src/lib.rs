pub fn primes_up_to(upper_bound: u64) -> Vec<u64> {
    // Create a vector of integers from 2 to upper_bound
    let mut values: Vec<u64>= (2..=upper_bound).collect();
    // Sieve of Primes - Non-primes set to zero
    for i in 0..values.len() {
        if values[i] != 0 {
            let n = values[i] as usize;
            for j in ((i+n)..values.len()).step_by(n) {
                values[j] = 0;
            }
        }
    }
    // Create a vector of primes remaining
    // in the sieve
    let mut primes: Vec<u64> = Vec::new();
    for n in values {
        if n != 0 {
            primes.push(n);
        }
    }
    primes
}