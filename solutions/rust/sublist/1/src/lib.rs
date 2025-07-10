#[derive(Debug, PartialEq, Eq)]
pub enum Comparison {
    Equal,
    Sublist,
    Superlist,
    Unequal,
}

pub fn sublist<T: PartialEq>(first_list: &[T], second_list: &[T]) -> Comparison {
    if first_list.len() < second_list.len() {
        match first_list.len() {
            0 => Comparison::Sublist,
            _ => {
                    for i in 0..=(second_list.len()-first_list.len()){
                        if first_list[..] == second_list[i..i+first_list.len()] {
                            return Comparison::Sublist;
                        }                        
                    }
                    return Comparison::Unequal;
            },
        }
    } else if second_list.len() < first_list.len() {
        for i in 0..=(first_list.len()-second_list.len()){
            if second_list[..] == first_list[i..i+second_list.len()] {
                return Comparison::Superlist;
            }                    
        }
        return Comparison::Unequal;
    } else {
        if first_list == second_list {
            return Comparison::Equal;
        } else {
            return Comparison::Unequal;
        }
    }
}
