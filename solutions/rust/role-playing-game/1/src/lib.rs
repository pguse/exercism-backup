pub struct Player {
    pub health: u32,
    pub mana: Option<u32>,
    pub level: u32,
}

impl Player {
    pub fn revive(&self) -> Option<Player> {
        if self.health == 0 && self.level >= 10 {
            Some(Player{health: 100, mana: Some(100), level: self.level})
        } else if self.health == 0 && self.level < 10 {
            Some(Player{health: 100, mana: None, level: self.level})
        } else {
            None
        }
    }

    pub fn cast_spell(&mut self, mana_cost: u32) -> u32 {
        match self.mana {
            None       =>   {
                                if mana_cost <= self.health {self.health -= mana_cost;}
                                else {self.health = 0;}
                                return 0;
                            }
            Some(mana) =>   {
                                if mana_cost > mana { return 0;}
                                else {self.mana = Some(mana-mana_cost); return 2 * mana_cost;}
                            }
        }
    }
}
