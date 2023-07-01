import kotlin.random.Random

/**
 * Todo 1: TO Show 2x2, 3x3, 4x4, nxn Matrix with Random Values
 * Todo 2: Spiral Traversal of nxn Matrix
 * Todo 3: Search Element in Matrix
 *          3.1 --> By Linear Search
 *          3.2 --> By Binary Search
 *          3.3 --> By Optimal Search
 * **/

fun main() {

    //Based on Row and Column, matrix nxn will change
    val row = 5
    val col = 5

    val matrix = Array(row) { Array(col) { 0 } }

    //Create No's and Insert into the matrix
    for (r in 0 until row) {
        for(c in 0 until col) {
            matrix[r][c] = Random.nextInt(10, 99)
        }
    }

    for (r in 0 until row) {
        for (c in 0 until col) {
            print("${matrix[r][c]}\t")
        }
        println()
    }

    letsDoTask2SpiralTraversal(matrix)

    val elementToSearch = Random.nextInt(10,99)
    letsDoTask31LinearSearch(matrix, elementToSearch)

    //Note Akshay: Following Code requires matrix each row sorted,
    //Now Consider, matrix is sorted, and then perform following operation
    letsDoTask32BinarySearch(matrix, elementToSearch)
    //...
    letsDoTask33OptimalSolution1(matrix, elementToSearch)
    letsDoTask33OptimalSolution2(matrix, elementToSearch)
}

fun letsDoTask2SpiralTraversal(matrix: Array<Array<Int>>) {

    if(matrix.isEmpty()) {
        println("Sorry, Cannot print Sparse, Empty Matrix")
        return
    }

    //Initialization of position
    var startRowIndex = 0
    var endRowIndex = matrix.size - 1

    var startColumnIndex = 0
    var endColumnIndex = matrix[startRowIndex].size - 1

    val list = mutableListOf<Int>()

    while (startRowIndex <= endRowIndex && startColumnIndex <= endColumnIndex) {

        for (col in startColumnIndex .. endColumnIndex) {
            list.add(matrix[startRowIndex][col])
        }
        startRowIndex++

        for (row in startRowIndex .. endRowIndex) {
            list.add(matrix[row][endColumnIndex])
        }
        endColumnIndex--

        for (col in endColumnIndex downTo startColumnIndex) {
            list.add(matrix[endRowIndex][col])
        }
        endRowIndex--

        for (row in endRowIndex downTo startRowIndex) {
            list.add(matrix[row][startColumnIndex])
        }
        startColumnIndex++
    }

    println("\nSpiral List: ${list.toTypedArray().contentToString()}")
}

fun letsDoTask31LinearSearch(matrix: Array<Array<Int>>, elementToSearch: Int) {
    if (matrix.isEmpty()) {
        println("Empty Matrix, No Elements for search $elementToSearch")
        return
    }
    var isFound = false
    outer@for (row in matrix.indices) {
        for (col in 0 until matrix[0].size) {
            if(matrix[row][col] == elementToSearch) {
                isFound = true
                println("\nBy doing Linear Search, Element $elementToSearch Found at [${row}][${col}] Location")
                break@outer
            }
        }
    }

    if(!isFound) {
        println("\nBy doing Linear Search, Element $elementToSearch Not Found Time Took O(r*c)")
    }
}


/**Strictly Not RECCOMMANDED, Wrote Just for PRACTICE, This code work only matrix is sorted**/
fun letsDoTask32BinarySearch(matrix: Array<Array<Int>>, elementToSearch: Int) {

    if(matrix.isEmpty()) {
        println("Cannot Search, Matrix is Empty")
        return
    }

    outer@for (row in 0 until matrix.size-1) {

        var low = 0
        var high = matrix[low].size-1

        while (low <= high) {
            val midIndex = (low+high) / 2
            when {
                elementToSearch > matrix[row][midIndex] -> low = midIndex+1
                elementToSearch < matrix[row][midIndex] -> high = midIndex - 1
                else -> {
                    println("\nBy doing Binary Search,  for Each Row, Element $elementToSearch Found at [$row][$midIndex]")
                    return
                }
            }
        }
    }
    println("By doing Binary Search, for Each Row, Element $elementToSearch is Not Found")
}

fun letsDoTask33OptimalSolution1(matrix: Array<Array<Int>>, elementToSearch: Int) {
    var startIndex = 0
    var endIndex = matrix.size - 1

    var isFound = false
    while (startIndex < matrix.size && endIndex > 0) {
        if(matrix[startIndex][endIndex] == elementToSearch) {
            isFound = true
            println("\nBy Optimal Solution 1, Element $elementToSearch Found at [${startIndex}][${endIndex}]")
            break
        } else {
            if(matrix[startIndex][endIndex] > elementToSearch) endIndex-- else startIndex++
        }
    }
    if (!isFound) {
        println("\nBy Optimal Solution 1, Element $elementToSearch not found in matrix")
    }
}

fun letsDoTask33OptimalSolution2(matrix: Array<Array<Int>>, elementToSearch: Int) {

    val rowSize = matrix.size
    val columnSize = matrix.size

    var low = 0
    var high = (rowSize*columnSize) - 1

    while (low <= high) {
        val midIndex = (low+high)  / 2
        var row = midIndex/columnSize
        var column = midIndex%columnSize

        if(matrix[row][column] == elementToSearch) {
            println("By Optimal Solution 2, Element $elementToSearch Found at [${row}][${column}]")
            return
        }

        if (matrix[row][column] > elementToSearch) low = midIndex+1 else high = midIndex-1
    }

    println("By Optimal Solution 2, Element $elementToSearch Not Found in Matrix :-(")
}
