class Solution {
    val pathList = mutableListOf<String>()
    fun getPath(currentRow: Int, currentCol: Int, lastRow: Int, lastCol: Int, path: String, obstacles: Array<BooleanArray>) {
        if (currentRow == lastRow && currentCol == lastCol) {
            pathList.add(path)
            return
        }

        if (!obstacles[currentRow][currentCol]) return
        
        obstacles[currentRow][currentCol] = false

        //To Left
        if (currentCol > 0) {
            getPath(currentRow, currentCol - 1, lastRow, lastCol, path + 'L', obstacles)
        }

        //To Top
        if (currentRow > 0) {
            getPath(currentRow-1, currentCol, lastRow, lastCol, path + 'T', obstacles)
        }

        //To Right
        if (currentCol < lastCol) {
            getPath(currentRow, currentCol + 1, lastRow, lastCol, path + 'R', obstacles)
        }

        //To Down
        if (currentRow < lastRow) {
            getPath(currentRow+1, currentCol, lastRow, lastCol, path + 'D', obstacles)
        }

        obstacles[currentRow][currentCol] = true

    }
}

fun main() {
    Solution().apply {
        val obstacles = arrayOf(
            booleanArrayOf(true, true, true),
            booleanArrayOf(true, true, true),
            booleanArrayOf(true, true, true)
        )
        getPath(0,0,2,2,"", obstacles)
        println(pathList.toTypedArray().contentToString())
    }
}

//Output: [RRDLLDRR, RRDLDR, RRDD, RDLDRR, RDRD, RDDR, DRTRDD, DRRD, DRDR, DDRTTRDD, DDRTRD, DDRR]
