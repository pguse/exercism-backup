#[derive(Debug, PartialEq, Eq)]
pub struct Dna {
    strand: String
}

#[derive(Debug, PartialEq, Eq)]
pub struct Rna{
    strand: String
}

impl Dna {
    pub fn new(dna: &str) -> Result<Dna, usize> {
        for (index,nucleotide) in dna.chars().enumerate() {
            match nucleotide {
                'G' | 'C' | 'T' | 'A' => {},
                _ => return Err(index)
            }
        }
        Ok(Dna{strand: dna.to_string()})
    }

    pub fn into_rna(self) -> Rna {
        let mut s = String::new();
        for nucleotide in self.strand.chars() {
            match nucleotide {
                'G' => s.push_str("C"),
                'C' => s.push_str("G"),
                'T' => s.push_str("A"),
                'A' => s.push_str("U"),
                _   => {}
            }
        }
        Rna{strand: s}
    }
}

impl Rna {
    pub fn new(rna: &str) -> Result<Rna, usize> {
        for (index,nucleotide) in rna.chars().enumerate() {
            match nucleotide {
                'C' | 'G' | 'A' | 'U' => {},
                _ => return Err(index)
            }
        }
        Ok(Rna{strand: rna.to_string()})
    }
}
