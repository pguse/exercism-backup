class Anagram(val word: String) {
    fun match(anagrams: Collection<String>): Set<String> {
        return anagrams.filter { it.lowercase() != word.lowercase() && letters(it) == letters(word)}.toSet()
    }

    private fun letters(text: String): List<Char> {
        return text.lowercase().toList().sorted()
    }
}