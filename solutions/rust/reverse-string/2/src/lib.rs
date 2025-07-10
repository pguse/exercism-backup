use unicode_segmentation::UnicodeSegmentation;

pub fn reverse(input: &str) -> String {
    let graphemes = input.graphemes(true).collect::<Vec<&str>>();
    let mut s = String::new();
    for g in graphemes.iter().rev() {
        s.push_str(&g);
    }
    s
}
