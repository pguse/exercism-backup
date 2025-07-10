import gleam/string
import gleam/list

pub fn hey(remark: String) -> String {
  let text =
    remark
    |> string.trim()
    |> string.to_graphemes()
    |> list.filter(fn(x) { is_alpha(x) || x == "?" })
    |> string.concat()
  case string.last(text) {
    Ok("?") ->
      case string.uppercase(text) == text && text != "?" {
        True -> "Calm down, I know what I'm doing!"
        False -> "Sure."
      }
    Error(Nil) ->
      case string.length(string.trim(remark)) {
        0 -> "Fine. Be that way!"
        _ -> "Whatever."
      }
    _ ->
      case string.uppercase(text) == text {
        True -> "Whoa, chill out!"
        False -> "Whatever."
      }
  }
}

pub fn is_alpha(char: String) -> Bool {
  case string.lowercase(char) {
    "a" | "b" | "c" | "d" | "e" | "f" | "g" | "h" | "i" -> True
    "j" | "k" | "l" | "m" | "n" | "o" | "p" | "q" | "r" -> True
    "s" | "t" | "u" | "v" | "w" | "x" | "y" | "z" -> True
    _ -> False
  }
}
