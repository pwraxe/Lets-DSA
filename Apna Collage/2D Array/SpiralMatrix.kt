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
}

fun main() {
    Solution().apply {
        val matrix = arrayOf(
            intArrayOf(1,2,3,4),
            intArrayOf(5,6,7,8),
            intArrayOf(9,10,11,12),
            intArrayOf(13,14,15,16))

        printSpiral(matrix)
    }
}

// [1, 2, 3, 4, 8, 12, 16, 15, 14, 13, 9, 5, 6, 7, 11, 10]
