class Solution {

    private fun printMatrix(matrix: Array<IntArray>) {
        //print
        matrix.forEach { row ->
            row.forEach {
                print("$it ")
            }
            println()
        }
    }
    private fun searchKey(matrix: Array<IntArray>, key:Int) {
        for (row in 0 ..< matrix.size) {
            for (col in 0..< matrix[row].size) {
                if (matrix[row][col] == key) {
                    println("Found at Location [$row][$col]")
                    return
                }
            }
        }
        println("Not Fount")
    }
    private fun findMinAndMax(matrix: Array<IntArray>) {
        var minValue = Int.MAX_VALUE
        var maxValue = Int.MIN_VALUE
        for (r in matrix.indices) {
            for (c in matrix[r].indices) {
                val item = matrix[r][c]
                if (item > maxValue) {
                    maxValue = item
                }
                if (item < minValue) {
                    minValue = item
                }
            }
        }
        println("Min: $minValue | Max: $maxValue")
    }

    fun learnMatrix(matrix: Array<IntArray>) {
        printMatrix(matrix)
        println()
        searchKey(matrix,5)
        println()
        findMinAndMax(matrix)
    }
}
fun main() {
    Solution().apply {
        val matrix = arrayOf(
            intArrayOf(1,3,5),
            intArrayOf(2,4,6),
            intArrayOf(7,8,9)
        )
        learnMatrix(matrix)
    }

}


1 3 5 
2 4 6 
7 8 9 

Found at Location [0][2]

Min: 1 | Max: 9
