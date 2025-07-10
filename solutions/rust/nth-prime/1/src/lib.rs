pub fn nth(n: u32) -> u32 {
    match n {
        0 => 2,
        _ => {
            let primes = sieve(20*n as usize);
            primes[n as usize] as u32
        }
    }
}

pub fn sieve(n: usize) -> Vec<usize> {
    let mut primes: Vec<bool> = vec![true; n];
    primes[0] = false;
    primes[1] = false;
    for i in 2..((n as f64).sqrt() as usize) {
        if primes[i] {
            for j in (i.pow(2)..n).step_by(i) {
                primes[j] = false;
            }
        }
    }
    primes.iter().enumerate().filter( |(_,e)| **e).map( |(i, _)| i).collect()
}