object Isogram {

    fun isIsogram(input: String): Boolean {
        val chars = input.lowercase().filter { it.isLetter() }
        return chars.length == chars.toSet().size
    }

}
