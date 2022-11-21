fun main() {
    val pattern = "abcfdacbabc"

    //println(preparePrefix(pattern).contentToString())         //[0, 0, 0, 0, 0, 1, 0, 0, 1, 2, 3]
    //println(prepareTable(pattern).contentToString())         //[0, 0, 0, 0, 0, 1, 0, 0, 1, 2, 3]

    val index = searchPattern("ancfvcabcfdabcabcfdacbabcaaf",pattern)
    println(index)
}

fun searchPattern(text: String, pattern: String): Int {
    val patternTable = prepareTable(pattern)
    val mainTextLength = text.length
    val patternLength = pattern.length

    var patternIndex = 0
    var textIndex = 0

    while ( (textIndex < mainTextLength)  and (patternIndex < patternLength) ) {
        if(pattern[patternIndex]== text[textIndex]) {
            patternIndex++
            textIndex++
        } else {
            if(patternIndex != 0) patternIndex = patternTable[patternIndex-1]
            else textIndex++
        }
        if(patternIndex == patternLength) {
            return textIndex-patternIndex
        }
    }
    return -1
}


//same fun but own written for understanding
fun prepareTable(pattern: String) : IntArray {

    val patternLength = pattern.length
    val indexTable = IntArray(patternLength)

    /**currentIndex : to get longest prefix and suffix**/
    var currentIndex = 0
    var nextIndex = 1

    while (nextIndex < patternLength) {

        if(pattern[currentIndex] == pattern[nextIndex]) {
            indexTable[nextIndex] = currentIndex+1
            currentIndex++
            nextIndex++
        } else {
            if(currentIndex != 0) {
                currentIndex = indexTable[currentIndex-1]
            } else {
                indexTable[nextIndex] = 0
                nextIndex++
            }
        }
    }
    return indexTable
}


//function from book
fun preparePrefix(pattern: String): IntArray {

    val patternLength = pattern.length
    val intArray = IntArray(patternLength)
    var index = 0
    var i = 1

    while (i < patternLength) {
        println("$i | $index ==> ${pattern[i]} -- ${pattern[index]}")
        if(pattern[i] == pattern[index]) {
            intArray[i] = index+1
            index++
            i++
            println("TRUE : $index | $i => ${intArray.contentToString()} ")
        } else {
            if(index != 0) {
                println("ELSE IF index : $index")
                index = intArray[index-1]
                println("ELSE IF : $index")
            }
            else {
                intArray[i] = 0
                i++
                println("ELSE ELSE : $i")
            }
        }
        println("\n\n\n")
    }
    return intArray
}
