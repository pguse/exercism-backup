pub fn factors(n: u64) -> Vec<u64> {
    
    match n {
        1 => vec![],
        2 => vec![2],
        3 => vec![3],
        _ => {
            let mut factors = Vec::new();
            let mut num = n;

            let mut value = 2;
            while num != 1  {
                while num % value == 0 { 
                    factors.push(value); 
                    num = num / value;
                }
                value += 1;
             }
        
             factors
        }
    }
}