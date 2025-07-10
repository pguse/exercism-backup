class Allergies(val score: Int) {

    fun getList(): List<Allergen> {
        val allergens = mutableListOf<Allergen>()
        val binaryScore = score.toString(2).padStart(8,'0').reversed()
        for (index in 0..7) {
            if (binaryScore[index] == '1') {
                allergens.add(Allergen.entries[index])
            }
        }
        return allergens
    }

    fun isAllergicTo(allergen: Allergen): Boolean {
        return getList().contains(allergen)
    }
}