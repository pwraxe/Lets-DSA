class Solution {

    private fun binarySearch(arr:IntArray, key: Int):Int {
        var start = 0
        var end = arr.size-1

        while (start <= end) {
            val midIndex = (start + end) / 2
            if (arr[midIndex] == key) {
                return midIndex
            } else if (key > arr[midIndex]) {
                start = midIndex+1
            } else {
                end = midIndex-1
            }
        }
        return -1
    }
    fun searchInMatrix(matrix: Array<IntArray>, key: Int): Boolean {

        for (row in matrix.indices) {
            val col = binarySearch(matrix[row], key)
            if (col != -1) {
                println("$key Found at [$row][$col]")
                return true
            }
        }
        println("Not Found")
        return false
    }

    fun searchInMatrixByStairCase(matrix: Array<IntArray>, key: Int): Boolean {
        var row = 0
        var col = matrix.size-1

        while (row < matrix.size && col >= 0) {
            if (matrix[row][col] == key) {
                println("$key Found at: [$row][$col]")
                return true
            } else if (key < matrix[row][col]) {
                col--
            } else {
                row++
            }
        }
        println("Not Found")
        return false
    }
    fun stairCaseMatrixSearch(matrix: Array<IntArray>, key: Int): Boolean {
        var row = matrix.size-1
        var col = 0

        while (row >= 0 && col < matrix[0].size) {
            if (matrix[row][col] == key) {
                println("Yes, $key Found at [$row][$col]")
                return true
            } else if(matrix[row][col] > key) {
                row--
            } else {
                col++
            }
        }
        println("Not Found")
        return false
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

        searchInMatrix(matrix, 1)

        searchInMatrixByStairCase(matrix,11)

        stairCaseMatrixSearch(matrix, 13)
    }
}

// 1 Found at [0][0]
// 11 Found at: [2][2]
// Yes, 13 Found at [3][0]
