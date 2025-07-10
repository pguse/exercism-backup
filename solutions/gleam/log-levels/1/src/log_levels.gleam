import gleam/string

pub fn message(log_line: String) -> String {
  case string.split(log_line, ":") {
    [_, message] -> string.trim(message)
    _ -> "invalid format"
  }
}

pub fn log_level(log_line: String) -> String {
  case string.split(log_line, "]:") {
    [level, _] ->
      level
      |> string.replace("[", " ")
      |> string.trim()
      |> string.lowercase()
    _ -> "invalid format"
  }
}

pub fn reformat(log_line: String) -> String {
  message(log_line)
  <> " ("
  <> log_line
  |> log_level()
  <> ")"
}
