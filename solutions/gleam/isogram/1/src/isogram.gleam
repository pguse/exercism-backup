import gleam/string
import gleam/list

pub fn is_isogram(phrase phrase: String) -> Bool {
  let letters =
    phrase
    |> string.lowercase()
    |> string.to_graphemes()
    |> list.filter(fn(x) { x != " " && x != "-" })
  let unique_letters =
    letters
    |> list.unique
  list.length(letters) == list.length(unique_letters)
}
