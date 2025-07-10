pub fn is_armstrong_number(num: u32) -> bool {
    let num_str: String = num.to_string();
    let n = num_str.len() as u32;
    let mut total: u32 = 0;

    for ch in num_str.chars() {
        match total.checked_add( ch.to_digit(10).unwrap().pow(n) ) {
            Some(v) => total = v,
            None => return false,
        }
    }
    
    num == total
}
