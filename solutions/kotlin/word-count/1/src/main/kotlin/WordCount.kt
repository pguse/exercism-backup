object WordCount {

    fun phrase(phrase: String): Map<String, Int> {
        /* Note
            1. [^a-z0-9']+ - splits on one or more characters that are not letters, numbers, or apostrophes
            2. '(?![a-z]) - splits on apostrophes that are not followed by a letter
            3. (?<![a-z])' - splits on apostrophes that are not preceded by a letter
        */
        return phrase
            .lowercase()
            .split(Regex("[^a-z0-9']+|'(?![a-z])|(?<![a-z])'"))
            .filter { it.isNotEmpty() }
            .groupingBy { it }
            .eachCount()
    }
}
