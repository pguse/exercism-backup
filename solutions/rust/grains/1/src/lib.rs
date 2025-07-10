pub fn square(s: u32) -> u64 {
    match s {
        s if (1..=64).contains(&s) => 2_u64.pow(s-1),
        _ => panic!("Square must be between 1 and 64"),
    }
}

pub fn total() -> u64 {
    (1..=64).map( |x| 2_u64.pow(x-1)).sum()
}
