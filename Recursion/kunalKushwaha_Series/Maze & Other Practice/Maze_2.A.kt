//1-B, The Maze Problem, You can move in all Direction
class Solution() {
    private val pathList = mutableListOf<String>()
    val paths: MutableList<String> get() = pathList
    fun findPath(currentRow: Int, currentCol: Int, lastRow: Int, lastCol: Int, path: String, matrix: Array<BooleanArray>) {
        if (currentRow == lastRow && currentCol == lastCol) {
            pathList.add(path)
            return
        }

        if (!matrix[currentRow][currentCol]) return

        matrix[currentRow][currentCol] = false

        //Left
        if (currentCol > 0) findPath(currentRow, currentCol-1, lastRow, lastCol, path+'L', matrix)

        //Top
        if (currentRow > 0) findPath(currentRow-1, currentCol, lastRow, lastCol, path + 'T', matrix)

        //Right
        if (currentCol < lastCol) findPath(currentRow, currentCol + 1, lastRow, lastCol, path + 'R', matrix)

        //Bottom
        if (currentRow < lastRow) findPath(currentRow + 1, currentCol, lastRow, lastCol, path + 'B', matrix)

        matrix[currentRow][currentCol] = true
    }
}

fun main() {
    Solution().apply {
        val matrix = Array(3) { BooleanArray(3) { true } }
        findPath(0,0,2,2, "", matrix)
        paths.sortedBy { it.length }.forEach {
            println("${it.length} | $it")
        }
    }
}

// 4 | RRBB
// 4 | RBRB
// 4 | RBBR
// 4 | BRRB
// 4 | BRBR
// 4 | BBRR
// 6 | RRBLBR
// 6 | RBLBRR
// 6 | BRTRBB
// 6 | BBRTRB
// 8 | RRBLLBRR
// 8 | BBRTTRBB
