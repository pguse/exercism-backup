object Acronym {
    fun generate(phrase: String) : String {
        return phrase
            .filter { it.isLetterOrDigit() || it.isWhitespace() || it == '-' }
            .split(" ", "-")
            .filter { it.isNotEmpty() }
            .map { it.first().uppercaseChar() }
            .joinToString("")
    }
}
