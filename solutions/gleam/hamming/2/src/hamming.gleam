import gleam/string
import gleam/order
import gleam/list

pub fn distance(strand1: String, strand2: String) -> Result(Int, Nil) {
  case string.length(strand1) == string.length(strand2) {
    False -> Error(Nil)
    True  -> list.zip( string.to_graphemes(strand1), string.to_graphemes(strand2) )
             |> list.fold(0, fn(acc: Int, pair: #(String,String)) {
                                  case pair {
                                   #(x,y) if x != y -> acc + 1
                                   #(_,_) -> acc
                                  }
                } )
              |> Ok
  }
}
