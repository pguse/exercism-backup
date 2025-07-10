pub fn collatz(n: u64) -> Option<u64> {
    let mut num = n;
    let mut steps = 0;

    if num == 0 { return None; }

    while num != 1 {
        if num % 2 == 0 {
            num = num / 2;
        } else if num <= (u64::MAX - 1) / 3 {
            num = 3*num + 1;
        } else {
            return None;
        }
        steps += 1;
    }

    Some(steps)
}
