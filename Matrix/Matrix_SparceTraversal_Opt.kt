import kotlin.random.Random
//Spiral Traversal Matrix
fun main() {

    val row = 4
    val column = 4
    val twoD = Array(row) { Array(column) { 0 } }

    for (row in 0 until row) {
        for (col in 0 until column) {
            twoD[row][col] = Random.nextInt(10,99)
        }
    }


    for (row in 0 until row) {
        for (col in 0 until column) {
            print("${twoD[row][col]}\t")
        }
        println()
    }
    println()

    spiralTraversalOfMatrix(twoD)
}

fun spiralTraversalOfMatrix(inputMatrix: Array<Array<Int>>) {

    /**Step 1 : Variable Declaration or index positioning on Matrix**/

    //0th Row Index in Matrix
    var rowStart = 0

    //Last Row index in matrix
    var rowEnd = inputMatrix.size - 1

    //First Column in Matrix
    var columnStart = 0

    //Last Column in Matrix
    var columnEnd = inputMatrix[rowStart].size - 1


    while (rowStart <= rowEnd && columnStart <= columnEnd) {

        /**Step 2 : Read First Row
         *          Where, Row index remain same and column will change**/
        for (column in columnStart .. columnEnd) {
            print("${inputMatrix[rowStart][column]}, ")
        }
        /**Step 3 : Our First Row is Completed, move to next for column iteration**/
        rowStart++

        /**Step 4 : Read Last Column,
         *      Where Column index remain same and row will change**/
        for (row in rowStart .. rowEnd) {
            print("${inputMatrix[row][columnEnd]}, ")
        }

        /**Step 5 : Our Last Column is Completed, move next to read last row**/
        columnEnd--

        /**Step 6 : Read Last Row,
         *          Where, lastRowIndex remain same and column index will change**/
        for (column in columnEnd downTo columnStart) {
            print("${inputMatrix[rowEnd][column]}, ")
        }

        /**Step 7 : Our Last Row is Completed, move next to read first column**/
        rowEnd--

        /**Step 8 : Read First Column,
         *         Where, columnStart will remain same and row will change from downTo top**/
        for (row in rowEnd downTo rowStart) {
            print("${inputMatrix[row][columnStart]}, ")
        }

        /**Step 9 : Increment column with one as we completed 1 outer iteration in matrix**/
        columnStart++
    }
}

/**
 * NOTE!!!!NOTE!!!!NOTE...AKSHAY
 * Here whatever notes you wrote 
 * all just for first iteration, 
 * just to understand iteration and execution for outer row 
 * **/

 
