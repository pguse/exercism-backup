object BinarySearch {
    fun search(list: List<Int>, item: Int): Int {
        var low = 0
        var high = list.size - 1
        while (low <= high) {
            val mid = (low + high) / 2
            when {
                item < list[mid] -> high = mid - 1
                item > list[mid] -> low = mid + 1
                else -> return mid
            }
        }
        throw NoSuchElementException("Element $item not found in the list") 
    }
}
