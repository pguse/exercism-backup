fun transcribeToRna(dna: String): String {
    // Check for proper nucleotides in the DNA
    require(dna.all { it in "ACGT" }) {"dna must be composed of G, C, A or T"}
    return dna.map {
        when (it) {
            'G' -> 'C'
            'C' -> 'G'
            'T' -> 'A'
            'A' -> 'U'
            else -> error("Unreachable")
        }
    }.joinToString("")
}