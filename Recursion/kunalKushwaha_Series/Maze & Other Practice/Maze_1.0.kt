//1. The Maze Problem, n x n matrix, traverse from Source to Target Points, with no obstacle
class Solution {

    private val pathList = mutableListOf<String>()

    fun getPathList(): String = pathList.toTypedArray().contentToString()

    fun findPath(currentRow: Int, currentCol: Int, lastRow: Int, lastCol: Int, path: String) {
        if (currentRow == lastRow && currentCol == lastCol) {
            pathList.add(path)
            return
        }

        //Down
        if (currentRow < lastRow) {
            findPath(currentRow + 1, currentCol, lastRow, lastCol, path + "D")
        }

        //Right
        if (currentCol < lastCol) {
            findPath(currentRow, currentCol + 1, lastRow, lastCol, path + "R")
        }
    }
}

fun main() {
    Solution().apply {
        findPath(0,0,2,2,"")
        println(getPathList())  //[DDRR, DRDR, DRRD, RDDR, RDRD, RRDD]
    }
}
