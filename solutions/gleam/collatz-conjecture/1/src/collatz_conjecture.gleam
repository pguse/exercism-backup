pub type Error {
  NonPositiveNumber
}

pub fn steps(number: Int) -> Result(Int, Error) {
  case number > 0 {
    True -> Ok(rec_steps(number))
    False -> Error(NonPositiveNumber)
  }
}

pub fn rec_steps(number: Int) -> Int {
  case number {
    1 -> 0
    _ -> case number % 2 == 0 {
          True -> 1 + rec_steps(number/2)
          False -> 1 + rec_steps(3*number+1)
         }
  }
}