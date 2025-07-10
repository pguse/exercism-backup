//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
enum class Codon {
    AUG,UUU,UUC,UUA,UUG,UCU,UCC,UCA,UCG,UAU,UAC,UGU,UGC,UGG
}


fun codonToAminoAcid(codon: Codon): String {
    return when (codon) {
        Codon.AUG -> "Methionine"
        Codon.UUU, Codon.UUC -> "Phenylalanine"
        Codon.UUA, Codon.UUG -> "Leucine"
        Codon.UCU, Codon.UCC, Codon.UCA, Codon.UCG -> "Serine"
        Codon.UAU, Codon.UAC -> "Tyrosine"
        Codon.UGU, Codon.UGC -> "Cysteine"
        Codon.UGG -> "Tryptophan"
        else -> IllegalStateException("Invalid codon")
    } as String
}

fun translate(rna: String?): List<String> {
    if (rna == null) { return emptyList() }
    else {
        val codonList = rna.chunked(3)
        val proteinList = mutableListOf<String>()
        for (codon in codonList) {
            // check for stop codon
            if (codon in listOf("UAA","UAG","UGA"))
                return proteinList
            else {
                proteinList.add(codonToAminoAcid(Codon.valueOf(codon.uppercase())))
            }
        }
        return proteinList
    }
}