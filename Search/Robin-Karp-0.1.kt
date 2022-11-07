import kotlin.math.pow

/**
 * Simple Calculation on Robin-Karp Algorithm
 * Explanation :
 * I am matching string by converting each character into its ascii value, adding them
 * then take substring of main string, calculate addition
 * if pattern addition == substring addition then found else not
 * **/

fun main() {
    val text = "abcdefghijklmoonpqrstuvwxyz"
    val pattern = "moon"

    val patternAdd = patternAddition(pattern)
    var endIndex = pattern.length-1
    var isFound = false
    var foundAt = -1
    for (index in 0 until text.length-pattern.length) {

        val subString = text.substring(index,index + pattern.length)
        val robinAdd = robinHash_Add(subString)
        if(robinAdd == patternAdd) {
            //match found
            isFound = true
            foundAt = index
            break
        }
        endIndex += endIndex
    }

    println("Pattern ${if(isFound) "Available" else "Unavailable"} | $foundAt")
}

fun patternAddition (patt : String) : Int {
    var pa = 0
    patt.forEachIndexed { index, c ->
        pa += c.code
    }
    return pa
}
fun robinHash_Add(text: String): Int {
    var add = 0
    text.forEachIndexed { index, c ->
        add += c.code
    }
    return add
}
