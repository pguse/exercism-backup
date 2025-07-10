object Yacht {

    fun solve(category: YachtCategory, vararg dices: Int): Int {
        return when (category) {
            YachtCategory.ONES -> dices.filter { it == 1 }.sum()
            YachtCategory.TWOS -> dices.filter { it == 2 }.sum()
            YachtCategory.THREES -> dices.filter { it == 3 }.sum()
            YachtCategory.FOURS -> dices.filter { it == 4 }.sum()
            YachtCategory.FIVES -> dices.filter { it == 5 }.sum()
            YachtCategory.SIXES -> dices.filter { it == 6 }.sum()
            YachtCategory.FULL_HOUSE -> if (dices.groupBy { it }.values.map {it.size}.sorted() == listOf(2, 3)) dices.sum() else 0
            YachtCategory.FOUR_OF_A_KIND -> dices.groupBy { it }.entries.find { it.value.size == 4 || it.value.size == 5 }?.key?.times(4) ?: 0
            YachtCategory.LITTLE_STRAIGHT -> if (dices.sorted() == listOf(1, 2, 3, 4, 5)) 30 else 0
            YachtCategory.BIG_STRAIGHT -> if (dices.sorted() == listOf(2, 3, 4, 5, 6)) 30 else 0
            YachtCategory.CHOICE -> dices.sum()
            YachtCategory.YACHT -> if (dices.distinct().size == 1) 50 else 0
        }
    }
}
