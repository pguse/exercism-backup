class Dna(var strand: String) {

    init {
        require(strand.all { it in "ACGT" })
    }

    // functional approach
    val nucleotideCounts: Map<Char, Int> = "ACGT".associateWith { ch -> strand.count { it.uppercaseChar() == ch } }

}