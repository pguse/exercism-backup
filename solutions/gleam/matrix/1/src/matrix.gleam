import gleam/string
import gleam/list
import gleam/int
import gleam/result

pub fn row(index: Int, string: String) -> Result(List(Int), Nil) {
  let row =
    string
    |> string.split("\n")
    |> list.at(index - 1)
  case row {
    Ok(r) ->
      r
      |> string.split(" ")
      |> list.map(fn(x) { int.parse(x) })
      |> result.all()
    Error(Nil) -> Error(Nil)
  }
}

pub fn column(index: Int, string: String) -> Result(List(Int), Nil) {
  let col =
    string
    |> string.split("\n")
    |> list.map(fn(x) {
      x
      |> string.split(" ")
      |> list.at(index - 1)
    })
    |> result.all()
  case col {
    Ok(c) ->
      c
      |> list.map(fn(x) { int.parse(x) })
      |> result.all()
    Error(Nil) -> Error(Nil)
  }
}
