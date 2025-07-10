import gleam/list
import gleam/int

pub type Category {
  Ones
  Twos
  Threes
  Fours
  Fives
  Sixes
  FullHouse
  FourOfAKind
  LittleStraight
  BigStraight
  Choice
  Yacht
}

pub fn add(a,b) {
  a + b
}

pub fn score_full_house(dice: List(Int)) {
  case dice {
    [a, _, b, c, d] if a == b && b != c && c == d -> list.fold(dice, 0, add)
    [a, b, c, _, d] if a == b && b != c && c == d -> list.fold(dice, 0, add)
    _ -> 0
  }
}

pub fn score_four_of_a_kind(dice: List(Int)) -> Int {
  case dice {
    [x, _, _, y, _] | [_, x, _, _, y] if x == y -> 4 * x
    _ -> 0
  }
}

pub fn score_little_straight(dice: List(Int)) {
  case dice {
    [1, 2, 3, 4, 5]  -> 30
    _ -> 0
  }
}

pub fn score_big_straight(dice: List(Int)) {
  case dice {
    [2, 3, 4, 5, 6]  -> 30
    _ -> 0
  }
}
pub fn score_yacht(dice: List(Int)) {
  case dice {
    [x, _, _, _, y] if x == y -> 50
    _ -> 0
  }
}

pub fn score(category: Category, dice: List(Int)) -> Int {
  case category {
    Ones -> dice |> list.filter(fn(x) {x == 1}) |> list.fold(0,add)
    Twos -> dice |> list.filter(fn(x) {x == 2}) |> list.fold(0,add)
    Threes -> dice |> list.filter(fn(x) {x == 3}) |> list.fold(0,add)
    Fours -> dice |> list.filter(fn(x) {x == 4}) |> list.fold(0,add)
    Fives -> dice |> list.filter(fn(x) {x == 5}) |> list.fold(0,add)
    Sixes -> dice |> list.filter(fn(x) {x == 6}) |> list.fold(0,add)
    FullHouse -> dice |> list.sort(int.compare) |> score_full_house
    FourOfAKind -> dice |> list.sort(int.compare) |> score_four_of_a_kind
    LittleStraight -> dice |> list.sort(int.compare) |> score_little_straight
    BigStraight -> dice |> list.sort(int.compare) |> score_big_straight
    Choice -> dice |> list.fold(0, add)
    Yacht -> dice |> list.sort(int.compare) |> score_yacht
    _ -> 0
  }
}
