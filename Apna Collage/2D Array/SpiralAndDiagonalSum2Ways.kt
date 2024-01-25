class Solution {
    fun printSpiral(matrix:Array<IntArray>) {
        var startRow = 0
        var startCol = 0
        var endRow = matrix.size-1
        var endCol = matrix[0].size-1
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
            for (col in endCol downTo startCol) {
                list.add(matrix[endRow][col])
            }
            endRow--
            for (row in endRow downTo startRow) {
                list.add(matrix[row][startCol])
            }
            startCol++
        }

        println(list.toTypedArray().contentToString())
    }
    fun diagonalSumWay1(matrix: Array<IntArray>) {
        var left = 0
        var right = 0

        for (r in matrix.indices) {
            for (c in matrix[r].indices) {
                if (r == c) {
                    left += matrix[r][c]
                }

                if (r + c == matrix.size-1) {
                    if (r != c) right += matrix[r][c]
                }
            }
        }
        println("Left Diagonal: $left | Right Diagonal: $right")
    }
    fun diagonalSumWay2(matrix: Array<IntArray>) {
        var left = 0
        var right = 0

        for (i in matrix.indices) {
            left += matrix[i][i]
        }

        val size = matrix.size-1
        for (i in matrix.indices) {
            if (i != size-1) {
                right += matrix[i][size-i]
            }
        }
        println("Left Diagonal: $left | Right Diagonal: $right")
    }
}

fun main() {
    Solution().apply {
        val matrix = arrayOf(
            intArrayOf(1,2,3,4),
            intArrayOf(5,6,7,8),
            intArrayOf(9,10,11,12),
            intArrayOf(13,14,15,16)
        )

        printSpiral(matrix)
        diagonalSumWay1(matrix)
        diagonalSumWay2(matrix)
    }
}

// [1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7, 6]
// Left Diagonal: 18 | Right Diagonal: 12
// Left Diagonal: 18 | Right Diagonal: 12
