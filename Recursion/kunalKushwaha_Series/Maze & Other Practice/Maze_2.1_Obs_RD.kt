//3.A, Maze With Obstacle, right down direction only
//In a matrix of 1 0, 1 is Wall, 0 is Space

class Solution {

    val pathList = mutableListOf<String>()

    private fun findPath(currentRow: Int, currentCol: Int,
                         lastRow: Int, lastCol: Int,  path:String, matrix: Array<IntArray>) {
        if (currentRow == lastRow && currentCol == lastCol) {
            pathList.add(path)
            return
        }

        if (matrix[currentRow][currentCol] == 1) return

        //Down
        if (currentRow < lastRow) findPath(currentRow + 1, currentCol, lastRow, lastCol, path + 'D', matrix)
        //Right
        if (currentCol < lastCol) findPath(currentRow, currentCol + 1, lastRow, lastCol, path + 'R', matrix)
    }
    fun findPathWithObstacle(lastRow: Int, lastCol: Int, matrix: Array<IntArray>) {
        findPath(0,0,lastRow, lastCol, "", matrix)
    }
}

fun main() {
    Solution().apply {
        val matrix = arrayOf(
            intArrayOf(0,1,0),
            intArrayOf(0,0,0),
            intArrayOf(1,0,0)
        )
        findPathWithObstacle(2,2,matrix)
        println(pathList.toTypedArray().contentToString())  //[DRDR, DRRD]
    }
}
