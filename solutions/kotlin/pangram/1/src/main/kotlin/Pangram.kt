object Pangram {

    fun isPangram(input: String): Boolean {
        return input.lowercase().replace(Regex("[^a-z]"), "").toSet().size == 26
    }
}
