/// Determine whether a sentence is a pangram.
use std::collections::HashSet;

pub fn is_pangram(sentence: &str) -> bool {
    let mut letters = HashSet::new();

    sentence.chars()
        .filter(|character| character.is_ascii_alphabetic())
        .map(|letter| letter.to_ascii_lowercase())
        .for_each(|letter| {letters.insert(letter);});
    
    letters.len() == 26

}
