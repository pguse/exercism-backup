#![allow(unused)]

use std::collections::HashMap;

pub fn can_construct_note(magazine: &[&str], note: &[&str]) -> bool {
    let mut magazine_words: HashMap<&str, u32> = HashMap::new();
    let mut note_words: HashMap<&str, u32> = HashMap::new();

    // Fill HashMap for magazine words
    for word in magazine {
        *magazine_words.entry(word).or_insert(0) += 1;
    }
    // Fill HashMap for note words
    for word in note {
        *note_words.entry(word).or_insert(0) += 1;
    }

    //println!("{:?}", magazine_words);
    //println!("{:?}", note_words);
    
    let mut construct = true;
    for (word, &num) in note_words.iter() {
        match magazine_words.get(word) {
            Some(&number) => if number < num { construct = false; break;},
            _ => {construct = false; break;}
        }
    }
    construct
}