//Problem: Check String is Pallindrom or not

fun main() {
    println("akshay".isPallindrom())
}

fun String.isPallindrom() :Boolean {
    
    for(i in 0 .. this.length/2) {
        if(this[i] != this[this.length-i-1]) return false
    }
    return true
    
}
