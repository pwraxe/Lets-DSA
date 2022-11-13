/**
** Studied and Practice From Book
** See Own Practice Code Below this code 
**/

fun main() {

    val string = "ABCDEFGHIJKOTLINLMOONOPQRST"
    val pattern = "KOTLIN"
    println(search(string,pattern))
}

fun search(text: String, pattern : String) : Int {
    val patternLength = pattern.length
    val textLength = text.length - patternLength

    val patternHash = hash(pattern)
    var subText = text.substring(0,patternLength)
    var subHash = hash(subText)

    ///println("$patternLength | $textLength | $patternHash | $subText | $subHash")

    if(patternHash == subHash && subText.equals(pattern,true)) {
        return 0
    }
    for (index in 1 .. textLength) {

        subHash = rollHash(text[index-1],text[index + patternLength-1],subHash,patternLength)
        subText = text.substring(index,index+patternLength)
        if(patternHash == subHash && subText == pattern) {
            return index
        }
    }
    return -1
}

fun hash(text: String) : Long {
    //return value is Long becoz to avoid hash collision

    var hash = 0L
    text.forEachIndexed { index, c ->
        //97.0 is integer value of ascii char 'a', and it is prime no,
        //you can take any no, (better take more than prime no, because it generates good hash value)
        hash += (c.code.toDouble() * (97.0.pow(index.toDouble()))).toLong()

        /**
         *      EX. KOTLIN is String place in array
         *
         *        0   1   2   3   4   5     //Index
         *      | K | O | T | L | I | N |   //Array Values
         *
         *      FORMULA : ASCII * n.pow(index)  WhereAs, n is any no (recc. any prime no more than 97)
         *
         *      K * 97.pow(0)   --> 75.0 * (97.0).pow(0.0)  +
         *      O * 97.pow(1)   --> 79.0 * (97.0).pow(1.0)  +
         *      T * 97.pow(2)   --> 84.0 * (97.0).pow(2.0)  +
         *      L * 97.pow(3)   --> 76.0 * (97.0).pow(3.0)  +
         *      I * 97.pow(4)   --> 73.0 * (97.0).pow(4.0)  +
         *      N * 97.pow(5)   --> 78.0 * (97.0).pow(5.0)
         * **/
    }
    return hash
}

fun rollHash(
    oldChar : Char,
    newChar : Char,
    oldHash: Long,
    patternLength : Int ) : Long {

    /**
     * When we add hash, we multiply by 97.0
     * Now When we remove character, we need to divide by 97.0
     * **/
    val removedFirst = (oldHash - oldChar.code.toLong()) / 97.0
    val newCharHash = newChar.code.toDouble() * 97.0.pow(patternLength-1)

    return (removedFirst + newCharHash).toLong()
}

//=========================================================================================================================


//Rabin-Krp Trying to Solved Own Way with same stategy
import kotlin.math.pow

fun main() {
    val text = "ABCDEFGHIJKLMOONOPQRSTUVWXYZ"
    val pattern = "MOON"
    println("Index of $pattern : ${text.searchPattern<String>(pattern)}")
}

fun <T:Comparable<T>> String.searchPattern(pattern: String): Int {

    val patternLength = pattern.length
    val textLength = this.length - patternLength
    var subString = this.substring(0,patternLength)
    val hashCodeOfPattern = hashCodeOfSubString(pattern,patternLength)

    if(hashCodeOfSubString(subString,patternLength) == hashCodeOfPattern && pattern == subString) {
        return 0
    }

    for (index in 1 .. textLength) {

        subString = this.substring(index,index+patternLength)
        val oldSubString = this.substring(index-1,index+patternLength-1)
        val subTextHash = rollingHash(oldSubString,subString,patternLength)
        if(subTextHash == hashCodeOfPattern && subString == pattern) {
            return index
        }
    }
    return -1
}

fun rollingHash(oldSubString: String, newSubString: String,patternLength: Int) : Long {

    val oldStringHash = hashCodeOfSubString(oldSubString,patternLength)
    val oldCharHash = hashOfChar(oldSubString[0],patternLength)
    val newCharHash = hashOfChar(newSubString[newSubString.length-1],patternLength)
    val hashAfterRemoveOld =  oldStringHash - oldCharHash
    val hashAfterAddNewChar = hashAfterRemoveOld + newCharHash
    return hashAfterAddNewChar
}

fun hashCodeOfSubString(subString: String,patternLength: Int) : Long {
    var hashCode = 0L
    subString.forEachIndexed { index, c ->
        hashCode += hashOfChar(c, patternLength = patternLength)
    }
    return hashCode
}

fun hashOfChar(char: Char, patternLength: Int): Long {
    return (char.code.toDouble() * (97.0.pow(patternLength))).toLong()
}
 

