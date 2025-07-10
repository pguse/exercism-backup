import gleam/set.{type Set}
import gleam/list
import gleam/string

pub fn new_collection(card: String) -> Set(String) {
  set.from_list([card])
}

pub fn add_card(collection: Set(String), card: String) -> #(Bool, Set(String)) {
  #(set.contains(collection, card), set.insert(collection, card))
}

pub fn trade_card(
  my_card: String,
  their_card: String,
  collection: Set(String),
) -> #(Bool, Set(String)) {
  let possible_trade = set.contains(collection, my_card) && !set.contains(collection, their_card)
  let new_collection = set.insert(collection, their_card) |> set.delete(my_card)
  #(possible_trade, new_collection)
}

pub fn boring_cards(collections: List(Set(String))) -> List(String) {
  let cards = collections
  |> list.reduce( fn(a,b) {set.intersection(a,b)})

  case cards {
    Ok(c) -> c |> set.to_list() |> list.sort(string.compare)
    _ -> []
  }
}

pub fn total_cards(collections: List(Set(String))) -> Int {
  let cards = collections
  |> list.reduce( fn(a,b) {set.union(a,b) })

  case cards {
    Ok(c) -> c |> set.size()
    _ -> 0
  }
}

pub fn shiny_cards(collection: Set(String)) -> Set(String) {
  collection
  |> set.filter( 
      fn(a) {
        case a {
          "Shiny" <> _ -> True
          _ -> False
        }
      })
}
