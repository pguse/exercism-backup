import gleam/regex.{Match}
import gleam/option.{Some, None}

pub fn is_valid_line(line: String) -> Bool {
  let assert Ok(re) = regex.from_string("^\\[(DEBUG|INFO|WARNING|ERROR)\\]")
  regex.check(with: re, content: line)
}

pub fn split_line(line: String) -> List(String) {
  let assert Ok(re) = regex.from_string("<[-=*~]*>")
  regex.split(with: re, content: line)
}

pub fn tag_with_user_name(line: String) -> String {
  let assert Ok(re) = regex.from_string(".*User[\\s|\\t]+([\\w|!|🙂]+)")
  let user = regex.scan(with: re, content: line)
  case user {
    [Match(content: _, submatches: [Some(user)])] -> "[USER] " <> user <> " " <> line
    _ -> line
  }
}
