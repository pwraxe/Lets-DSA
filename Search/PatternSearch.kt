fun main() {

    val result = "abcdefghijklmoonpqrstuvwxyz".searchPattern<String>("moon")
    println("Result : $result")

    println(checkForPattern("abcdefghijklmoonpqrstuvwxyz","moon"))
}

/**
 * -> external loop is for main string
 * -> inner loop for patter string
 * -> when we are in inner loop, check for first char with given outer loop
 * -> 'i' stays same position until inner loop either break or completed,
 * -> inner loop just add steps in i index for comparing next element without moving i of outer index
 * -> we check for non-matching character, if not match then upate isFound flag and break inner loop
 * -> update value/index of outer loop
 * -> if inner loop completed it menace we found pattern and exit from outer loop also using 'break'
 * **/

//Practice by own
fun checkForPattern(text: String, pattern: String) : Boolean {

    val patternLength = pattern.length
    val textLength = text.length
    val length = textLength.minus(patternLength)
    
    var isFound : Boolean = true
    for (i in 0 until length) {
        isFound = true
        for (j in 0 until patternLength) {
            //check if character not match then break inner loop
            if(text[i + j] != pattern[j]) {
                isFound = false
                break
            }
        }

        if(isFound) {
            break
        }
    }
    return isFound
}

//studied from book
fun <T> String.searchPattern(pattern: String) : Int {
    var retVal = -1
    val patternLength = pattern.length          // 4
    val length = this.length - patternLength    // 23
    //27 | 4 = 23

    println("TL : ${this.length} | PL : $patternLength = $length")

    for (i in 0 until length) {

        var isFound = true

        for (j in 0 until patternLength ) {
            if (this[i+j] != pattern[j]) {
                isFound = false
                break
            }
        }

        if(isFound) {
            retVal = i
            break
        }

    }
    return retVal
}
