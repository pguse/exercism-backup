import gleam/string
import gleam/list
import gleam/set

pub fn is_pangram(sentence: String) -> Bool {
  let letters =
    sentence
    |> string.lowercase()
    |> string.to_graphemes()
    |> list.filter(fn(x) { is_alpha(x) })
    |> set.from_list()
  set.size(letters) == 26
}

// Determine whether a single character
// string is [a-z]
pub fn is_alpha(letter: String) -> Bool {
  case letter {
    "a" | "b" | "c" | "d" | "e" | "f" -> True
    "g" | "h" | "i" | "j" | "k" | "l" -> True
    "m" | "n" | "o" | "p" | "q" | "r" -> True
    "s" | "t" | "u" | "v" | "w" | "x" | "y" | "z" -> True
    _ -> False
  }
}
