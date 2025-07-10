import gleam/string
import gleam/list

pub fn find_anagrams(word: String, candidates: List(String)) -> List(String) {
  candidates
  |> list.filter(fn(x) {
    string.lowercase(word) != string.lowercase(x) && letters(word) == letters(x)
  })
}

// Sorted list of letters
fn letters(text: String) -> List(String) {
  text
  |> string.lowercase()
  |> string.to_graphemes()
  |> list.sort(string.compare)
}
