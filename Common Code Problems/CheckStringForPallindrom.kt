//Problem: Check String is Pallindrom or not

fun main() {
    println("akshay".isPallindrom())
    println(checkForPallindrom("Hello")) //false
}

fun String.isPallindrom() :Boolean {
    
    for(i in 0 .. this.length/2) {
        if(this[i] != this[this.length-i-1]) return false
    }
    return true   
}

fun checkForPallindrom(text: String): Boolean {
    
    var left = 0
    var right = text.length-1
    while(left < right) {
        if(text[left] != text[right]) return false
        left++
        right--
    }
    
    return true
}
