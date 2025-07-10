import gleam/string
import gleam/list

pub fn proteins(rna: String) -> Result(List(String), Nil) {
  let result = do_proteins(rna, list.new())
  case result {
    ["Error"] -> Error(Nil)
    _ -> Ok(result)
  }
}

pub fn do_proteins(codons: String, proteins: List(String)) -> List(String) {
  case string.slice(codons, 0, 3) {
    "AUG"                         -> do_proteins(string.slice(codons,3, string.length(codons) - 3), ["Methionine", ..proteins])
    "UUU" | "UUC"                 -> do_proteins(string.slice(codons,3, string.length(codons) - 3), ["Phenylalanine", ..proteins])
    "UUA" | "UUG"                 -> do_proteins(string.slice(codons,3, string.length(codons) - 3), ["Leucine", ..proteins])
    "UCU" | "UCC" | "UCA" | "UCG" -> do_proteins(string.slice(codons,3, string.length(codons) - 3), ["Serine", ..proteins])
    "UAU" | "UAC"                 -> do_proteins(string.slice(codons,3, string.length(codons) - 3), ["Tyrosine", ..proteins])
    "UGU" | "UGC"                 -> do_proteins(string.slice(codons,3, string.length(codons) - 3), ["Cysteine", ..proteins])
    "UGG"                         -> do_proteins(string.slice(codons,3, string.length(codons) - 3), ["Tryptophan", ..proteins])
    "UAA" | "UAG" | "UGA" | ""    -> list.reverse(proteins)
    _                             -> ["Error"]
  }
}