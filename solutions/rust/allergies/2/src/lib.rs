pub struct Allergies {
    list: Vec<Allergen>,
}

#[derive(Debug, PartialEq, Eq, Clone)]
pub enum Allergen {
    Eggs,
    Peanuts,
    Shellfish,
    Strawberries,
    Tomatoes,
    Chocolate,
    Pollen,
    Cats,
}

impl Allergies {
    pub fn new(score: u32) -> Self {
        let mut allergies_list: Vec<Allergen> = Vec::new();
        // Convert the score to a binary string
        let binary_score = format!("{:b}", score);
        for (i,digit) in binary_score.chars().rev().enumerate() {
            match (i, digit) {
                (0,'1') => allergies_list.push(Allergen::Eggs),
                (1,'1') => allergies_list.push(Allergen::Peanuts),
                (2,'1') => allergies_list.push(Allergen::Shellfish),
                (3,'1') => allergies_list.push(Allergen::Strawberries),
                (4,'1') => allergies_list.push(Allergen::Tomatoes),
                (5,'1') => allergies_list.push(Allergen::Chocolate),
                (6,'1') => allergies_list.push(Allergen::Pollen),
                (7,'1') => allergies_list.push(Allergen::Cats),
                (8,'0'|'1') => break,
                (_,_) => {}
            }
        }
        Allergies{list: allergies_list}
    }

    pub fn is_allergic_to(&self, allergen: &Allergen) -> bool {
        self.list.contains(allergen)
    }

    pub fn allergies(&self) -> Vec<Allergen> {
        self.list.clone()
    }
}
