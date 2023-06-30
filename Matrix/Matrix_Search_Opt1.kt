//Matrix Search Optimal Way 1

import kotlin.random.Random
fun main() {

    val row = 4
    val column = 4
    val twoD = arrayOf(
        intArrayOf(10, 20, 30, 40), //list1,
        intArrayOf(15, 25, 35, 45), //list2,
        intArrayOf(27, 29, 37, 48), //list3,
        intArrayOf(32, 33, 39, 50), //list4
    )

    for (r in 0 until row) {
        for (c in 0 until column) {
            print("${twoD[r][c]}\t")
        }
        println()
    }

    //Search Item in Matrix

    val key = 20
    var startIndex = 0
    var endIndex = twoD.size-1

    while (startIndex < twoD.size && endIndex > 0) {
        if(twoD[startIndex][endIndex] == key) {
            println("Element Found : ($startIndex, $endIndex)")
            break
        }
        if(twoD[startIndex][endIndex] > key) endIndex-- else startIndex++
    }
}

//--------------------------------------------------------------------------------------------------------------------------------------------------

//Matrix Search Optimal Way 2

fun main() {

    val row = 4
    val column = 4
    val twoD = arrayOf(
        intArrayOf(10, 20, 30, 40), //list1,
        intArrayOf(15, 25, 35, 45), //list2,
        intArrayOf(27, 29, 37, 48), //list3,
        intArrayOf(32, 33, 39, 50), //list4
    )

    for (r in 0 until row) {
        for (c in 0 until column) {
            print("${twoD[r][c]}\t")
        }
        println()
    }

    val key = 16
    val isFound = searchUsingBinary(twoD, key)
    println("Is $key Found? : $isFound ")
}

fun searchUsingBinary(matrix: Array<IntArray>, key : Int) : Boolean {
    if (matrix.isEmpty()) return false

    val rowSize = matrix.size
    val columnSize = matrix[0].size

    var low = 0
    var high =  (rowSize * columnSize) - 1

    while (low <= high) {
        val midIndex = (low + high) / 2
        if(matrix[midIndex/columnSize][midIndex%columnSize] == key) return true
        if(matrix[midIndex/columnSize][midIndex%columnSize] > key) low = midIndex+1 else high = midIndex-1
    }
    return false
}

