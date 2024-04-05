import kotlin.math.max
import kotlin.math.min

class Solution {

    fun printMatrix(matrix: Array<IntArray>) {
        println("Printing Matrix")
        matrix.forEach {
            println(it.toTypedArray().contentToString())
        }
    }
    fun getMaxMinValue(matrix: Array<IntArray>) {
        println("Get Min and Max Value")
        var minValue = Int.MAX_VALUE
        var maxValue = Int.MIN_VALUE
        matrix.forEach { row ->
            row.forEach {
                minValue = min(minValue, it)
                maxValue = max(maxValue, it)
            }
        }
        println("Min Value in Matrix: $minValue")
        println("Max Value in Matrix: $maxValue")
    }
    fun spiralMatrix(matrix: Array<IntArray>) {
        println("Spiral Matrix")
        var startRow = 0
        var startCol = 0
        var endRow = matrix.lastIndex
        var endCol = matrix.lastIndex
        val list = mutableListOf<Int>()
        while (startRow <= endRow && startCol <= endCol) {
            for (col in startCol .. endCol) {
                list.add(matrix[startRow][col])
            }
            startRow++
            for (row in startRow .. endRow) {
                list.add(matrix[row][endCol])
            }
            endCol--

            if (list.size == matrix.size * matrix[0].size) break

            for (col in endCol downTo startCol) {
                list.add(matrix[endRow][col])
            }
            endRow--
            for (row in endRow downTo startRow) {
                list.add(matrix[row][startCol])
            }
            startCol++
            if (list.size == matrix.size * matrix[0].size) break
        }

        println(list.toTypedArray().contentToString())
    }

    fun diagonalSum(matrix: Array<IntArray>) {
        println("Diagonal Sum (Inclusive)")
        var left = 0
        var right = 0
        for (i in matrix.indices) {
            left += matrix[i][i]
            right += matrix[i][matrix.lastIndex-i]
        }
        println("Left Diagonal Sum: $left")
        println("Right Diagonal Sum: $right")
    }
}

fun main() {
    Solution().apply {
        val matrix = arrayOf(
            intArrayOf(4,2,8),
            intArrayOf(1,7,9),
            intArrayOf(3,5,6))

        printMatrix(matrix)
        println()
        getMaxMinValue(matrix)
        println()
        spiralMatrix(matrix)
        println()
        diagonalSum(matrix)
    }
}

//=====================================

Printing Matrix
[4, 2, 8]
[1, 7, 9]
[3, 5, 6]

Get Min and Max Value
Min Value in Matrix: 1
Max Value in Matrix: 9

Spiral Matrix
[4, 2, 8, 9, 6, 5, 3, 1, 7]

Diagonal Sum (Inclusive)
Left Diagonal Sum: 17
Right Diagonal Sum: 18
