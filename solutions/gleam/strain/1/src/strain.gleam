import gleam/list

pub fn keep(list: List(t), predicate: fn(t) -> Bool) -> List(t) {
  case list.first(list) {
    Error(Nil) -> []
    Ok(f) ->
      case list.rest(list) {
        Error(Nil) -> []
        Ok(r) ->
          case predicate(f) {
            True -> [f, ..keep(r, predicate)]
            False -> keep(r, predicate)
          }
      }
  }
}

pub fn discard(list: List(t), predicate: fn(t) -> Bool) -> List(t) {
  case list.first(list) {
    Error(Nil) -> []
    Ok(f) ->
      case list.rest(list) {
        Error(Nil) -> []
        Ok(r) ->
          case predicate(f) {
            False -> [f, ..discard(r, predicate)]
            True -> discard(r, predicate)
          }
      }
  }
}
