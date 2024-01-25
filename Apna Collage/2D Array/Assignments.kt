class Solution {

    fun print7(matrix: Array<IntArray>) {
        var count = 0
        for (row in matrix.indices) {
            for (col in matrix[row].indices) {
                if (matrix[row][col] == 7) {
                    count++
                }
            }
        }
        println("Total 7's in Array : $count")
    }

    fun printNosIn2ndRow(matrix: Array<IntArray>) {
        var sum = 0
        matrix[1].forEach {
            sum += it
        }
        println("Sum: $sum")
    }

    fun transposeOfMatrix(matrix: Array<IntArray>) {
        val row = matrix.size
        val col = matrix[0].size
        println("\nOriginal Matrix")
        matrix.forEach {
            println(it.toTypedArray().contentToString())
        }
        println("Transpose of Matrix")
        val mat = Array(col) { IntArray(row) }
        for (r in matrix.indices) {
            for (c in matrix[r].indices) {
                mat[c][r] = matrix[r][c]
            }
        }
        mat.forEach {
            println(it.toTypedArray().contentToString())
        }
    }
}

fun main() {
    Solution().apply {
        val arr1 = arrayOf(
            intArrayOf(4,7,8),
            intArrayOf(8,8,7))
        print7(arr1)

        val arr2 = arrayOf(
            intArrayOf(1,4,9),
            intArrayOf(11,4,3),
            intArrayOf(2,2,3))
        printNosIn2ndRow(arr2)

        transposeOfMatrix(arr1)
    }
}

// Total 7's in Array : 2
// Sum: 18

// Original Matrix
// [4, 7, 8]
// [8, 8, 7]
// Transpose of Matrix
// [4, 8]
// [7, 8]
// [8, 7]

