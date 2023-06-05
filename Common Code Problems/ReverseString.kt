//Problem: Reverse a String
fun main() {
	val text = "Hello there"
    println("Reverse 1: ${reverseByLoop(text)}")
    println("Reverse 2: ${reverse(text)}")
    println("Reverse 3: ${reverseString(text)}")
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

fun reverseString(input: String) : String {
    var text :StringBuilder = StringBuilder(input)
    var left = 0
    var right = text.length-1
    while(left < right) {
        text[left] = text[right].also{ text[right] = text[left] }
	left++
        right--
    }
    return text.toString()
}
