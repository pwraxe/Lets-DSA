//Check Character is Alphabet or not
fun main() {
    val input = '4'
    println(isAlphabet(input))
}
fun isAlphabet(ch: Char): Boolean {
    return ch in 'a'..'z' || ch in 'A'..'Z'
}

