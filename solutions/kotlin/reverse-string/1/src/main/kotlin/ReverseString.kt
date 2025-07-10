fun reverse(input: String): String {
    var reversed = ""
    for (ch in input) {
        reversed = ch + reversed
    }
    return reversed
}