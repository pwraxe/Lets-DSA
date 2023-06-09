//Program : Seperate Small Letter, capital Letter, and no from given string

fun main() {
    
    val text = "Hello there I got 84 in Math and 90 in Science"
    val smallLetters = mutableListOf<Char>()
    val capitalLetters = mutableListOf<Char>()
    val numbers = mutableListOf<Char>()
    
    for(ch in text) {
        when {
            ch in 'a'..'z' -> smallLetters.add(ch)
            ch in 'A'..'Z' -> capitalLetters.add(ch)
            ch in '0'..'9' -> numbers.add(ch)
        	else -> {}
        }
    }
    
    println("Small Letters : ${smallLetters.toList()}")
    println("Capital Letters : ${capitalLetters.toList()}")
    println("Numbers : ${numbers.toList()}")
    
}
