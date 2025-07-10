import gleam/list

pub fn accumulate(list: List(a), fun: fn(a) -> b) -> List(b) {
  case list.first(list) {
    Error(Nil) -> []
    Ok(f) ->
      case list.rest(list) {
        Error(Nil) -> []
        Ok(r) -> [fun(f), ..accumulate(r, fun)]
      }
  }
}
