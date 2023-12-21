class Solution {
    val pathList = mutableListOf<String>()
    fun getPath(currentRow: Int, currentCol: Int, lastRow: Int, lastCol: Int, path: String, obstacles: Array<BooleanArray>) {
        if (currentRow == lastRow && currentCol == lastCol) {
            pathList.add(path)
            return
        }

        if (!obstacles[currentRow][currentCol]) return

        //To Down
        if (currentRow < lastRow) {
            getPath(currentRow+1, currentCol, lastRow, lastCol, path + 'D', obstacles)
        }

        //To Right
        if (currentCol < lastCol) {
            getPath(currentRow, currentCol + 1, lastRow, lastCol, path + 'R', obstacles)
        }
    }
}

fun main() {
    Solution().apply {
        val obstacles = arrayOf(
            booleanArrayOf(true, true, true),
            booleanArrayOf(true, true, false),
            booleanArrayOf(false, true, true)
        )
        getPath(0,0,2,2,"", obstacles)
        println(pathList.toTypedArray().contentToString())
    }
}

//output : [DRDR, RDDR]
