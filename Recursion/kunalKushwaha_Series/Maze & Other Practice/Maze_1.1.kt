//1. The Maze Problem, n x n matrix,
class Solution {

    private val pathList = mutableListOf<String>()
    fun getPathList() = pathList.toTypedArray().contentToString()

    fun findPath(currentRow: Int, currentCol: Int, lastRow: Int, lastCol: Int, path: String) {
        if (currentRow == lastRow && currentCol == lastCol) {
            pathList.add(path)
            return
        }

        if (currentRow < lastRow) findPath(currentRow+1, currentCol, lastRow, lastCol, path + "D")
        if (currentCol < lastCol) findPath(currentRow, currentCol+1, lastRow, lastCol, path + "R")
    }
}

fun main() {
    Solution().apply {
        findPath(0,0,4,4,"") //<-- you can change your starting point and end point, any size row or col can take
        println(getPathList())
    }
}
