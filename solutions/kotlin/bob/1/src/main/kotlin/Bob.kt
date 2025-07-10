object Bob {
    fun hey(input: String): String {
        val prompt = input.trim()
        return when  {
            prompt.isEmpty() -> "Fine. Be that way!"
            prompt.last() == '?' -> when {
                                        prompt.dropLast(1).all { !it.isLetter() } -> "Sure."
                                        prompt.uppercase() == prompt -> "Calm down, I know what I'm doing!"
                                        else -> "Sure."
                                    }
            else -> when {
                        input.none { it.isLetter() } -> "Whatever."
                        input.uppercase() == input -> "Whoa, chill out!"
                        else -> "Whatever."
                    }
            }
    }
}