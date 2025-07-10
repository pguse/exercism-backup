import gleam/string
import gleam/list
import gleam/result

pub type Robot {
  Robot(direction: Direction, position: Position)
}

pub type Direction {
  North
  East
  South
  West
}

pub type Position {
  Position(x: Int, y: Int)
}

pub fn create(direction: Direction, position: Position) -> Robot {
  Robot(direction, position)
}

pub fn move_left(robot: Robot) -> Robot {
  let position = robot.position
  case robot.direction {
    North -> Robot(West, position)
    East  -> Robot(North, position)
    South -> Robot(East, position)
    West  -> Robot(South, position)
  }
}

pub fn move_right(robot: Robot) -> Robot {
  let position = robot.position
  case robot.direction {
    North -> Robot(East, position)
    West  -> Robot(North, position)
    South -> Robot(West, position)
    East  -> Robot(South, position)
  }
}

pub fn advance(robot: Robot) -> Robot {
  let x = robot.position.x
  let y = robot.position.y
  case robot.direction {
    North -> Robot(North, Position(x, y+1))
    South -> Robot(South, Position(x, y-1))
    East  -> Robot(East, Position(x+1, y))
    West  -> Robot(West, Position(x-1, y))
  }
}

pub fn do_move(instructions: List(String), robot: Robot) -> Robot {
  let rest = result.unwrap( list.rest(instructions), [""])
  case list.first(instructions) {
    Ok("L") -> do_move(rest, move_left(robot))
    Ok("R") -> do_move(rest, move_right(robot))
    Ok("A") -> do_move(rest, advance(robot))
    _       -> robot
  }
}

pub fn move(direction: Direction, position: Position, instructions: String) -> Robot {
  instructions
  |> string.to_graphemes
  |> do_move(Robot(direction, position))
}