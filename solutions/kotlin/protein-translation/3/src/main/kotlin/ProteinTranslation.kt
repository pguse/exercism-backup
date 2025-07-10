//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
enum class Codon(val aminoAcid: String) {
    AUG("Methionine"),
    UUU("Phenylalanine"),UUC("Phenylalanine"),
    UUA("Leucine"),UUG("Leucine"),
    UCU("Serine"),UCC("Serine"),UCA("Serine"),UCG("Serine"),
    UAU("Tyrosine"),UAC("Tyrosine"),
    UGU("Cysteine"),UGC("Cysteine"),
    UGG("Tryptophan")
}

fun translate(rna: String?): List<String> = rna?.let { strand ->
    strand.chunked(3)
        .takeWhile { codon -> codon !in setOf("UAA", "UAG", "UGA") }
        .map { codon -> Codon.valueOf(codon).aminoAcid }
} ?: emptyList()