//Problem: Remove Space From Given String

fun main() {
    //Method 1
 	val text = "Remove Space From Given String".removeSpace()
    println("1: $text")

    //Method 2
    val text2 = text.replace(" ","")
    println("2: $text2")
}

fun String.removeSpace() :String {
    var text = ""
    
    this.forEach {
        if(it != ' ') text += it
    }
    return text
}
