import kotlin.math.sqrt
import kotlin.math.ceil

object CryptoSquare {

    fun ciphertext(plaintext: String): String {
        if (plaintext.isEmpty()) return ""
        // Normalize input
        val normalized = plaintext
            .filter { it.isLetterOrDigit() }
            .lowercase()
        // Determine the grid size
        val length = normalized.length
        val cols = ceil(sqrt(length.toDouble())).toInt()
        // Build rows of the grid
        val rows = normalized.chunked(cols)
        // Construct columns using map and join
        val cipherWords = (0 until cols).map { colIndex ->
            rows.map { row ->
                row.getOrElse(colIndex, { ' ' })
            }.joinToString ("")
        }
        // Join the rows
        return cipherWords.joinToString(" ")
    }

}
