pub fn find(array: &[i32], key: i32) -> Option<usize> {
    if array.is_empty() { return None;}
    let mut lower: usize = 0;
    let mut upper: usize = array.len() - 1;
    while lower <= upper {
        let middle = (lower + upper) / 2;
        if array[middle] > key {
            if middle > 0 {upper = middle - 1;}
            else {break;}
        } else if array[middle] < key {
            lower = middle + 1;
        } else {
            return Some(middle);
        }
    }
    None
}