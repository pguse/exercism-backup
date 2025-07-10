import gleam/string
import gleam/list

pub fn first_letter(name: String) {
  let first =
    name
    |> string.trim()
    |> string.first()

  case first {
    Ok(letter) -> letter
    Error(_) -> ""
  }
}

pub fn initial(name: String) {
  name
  |> first_letter()
  |> string.uppercase()
  <> "."
}

pub fn initials(full_name: String) {
  let initials =
    full_name
    |> string.split(" ")
    |> list.map(initial)
    |> list.reduce(fn(a, b) { a <> " " <> b })

  case initials {
    Ok(initials) -> initials
    Error(_) -> ""
  }
}

pub fn pair(full_name1: String, full_name2: String) {
  "
     ******       ******
   **      **   **      **
 **         ** **         **
**            *            **
**                         **
**     "
  <> initials(full_name1)
  <> "  +  "
  <> initials(full_name2)
  <> "     **
 **                       **
   **                   **
     **               **
       **           **
         **       **
           **   **
             ***
              *
"
}
