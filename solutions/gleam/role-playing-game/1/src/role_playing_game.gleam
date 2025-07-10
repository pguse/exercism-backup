import gleam/option.{type Option, None, Some}

pub type Player {
  Player(name: Option(String), level: Int, health: Int, mana: Option(Int))
}

pub fn introduce(player: Player) -> String {
  case player.name {
    Some(name) -> name
    None -> "Mighty Magician"
  }
}

pub fn revive(player: Player) -> Option(Player) {
  case player.health {
    0 if player.level >= 10 ->
      Some(Player(player.name, player.level, 100, Some(100)))
    0 -> Some(Player(player.name, player.level, 100, player.mana))
    _ -> None
  }
}

pub fn cast_spell(player: Player, cost: Int) -> #(Player, Int) {
  case player.mana {
    Some(mana) if mana >= cost -> #(
      Player(player.name, player.level, player.health, Some(mana - cost)),
      2
      * cost,
    )
    Some(_mana) -> #(player, 0)
    None if player.health >= cost -> #(
      Player(player.name, player.level, player.health - cost, None),
      0,
    )
    None -> #(Player(player.name, player.level, 0, None), 0)
  }
}
