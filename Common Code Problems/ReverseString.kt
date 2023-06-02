//Problem: Reverse a String
fun main() {
	val text = "Hello there"
    println("Reverse 1: ${reverseByLoop(text)}")
    println("Reverse 2: ${reverse(text)}")
}

fun reverseByLoop(text: String) : String {
    var reverse = ""
    for(index in text.length-1 downTo 0) {
        reverse += text.get(index)
    }
    return reverse
}

fun reverse(text: String) : String {
    return StringBuilder(text).reverse().toString()
}
