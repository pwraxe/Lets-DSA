class Solution {

    fun getPathByRightDown(startRow: Int, startCol: Int, endRow: Int, endCol: Int, path: String) {
        if (startRow == endRow && startCol == endCol) {
            println(path.trim().removePrefix(">"))
            return
        }

        //To Right
        if (startCol < endCol) {
            getPathByRightDown(startRow, startCol+1, endRow, endCol, "$path > R")
        }

        //To Down
        if (startRow < endRow) {
            getPathByRightDown(startRow+1, startCol, endRow, endCol, "$path > D")
        }

    }

    fun getPathByTopRightDownLeft(startRow: Int, startCol: Int, endRow: Int, endCol: Int, matrix: Array<BooleanArray>, path: String) {
        if (startRow == endRow && startCol == endCol) {
            println(path.trim().removePrefix(">"))
            return
        }

        if (!matrix[startRow][startCol]) return

        matrix[startRow][startCol] = false

        //Left
        if (startCol > 0) {
            getPathByTopRightDownLeft(startRow, startCol-1, endRow, endCol, matrix, "$path > L")
        }

        //Top
        if (startRow > 0) {
            getPathByTopRightDownLeft(startRow-1, startCol, endRow, endCol, matrix, "$path > T")
        }

        //Right
        if (startCol < endCol) {
            getPathByTopRightDownLeft(startRow, startCol+1, endRow, endCol, matrix, "$path > R")
        }

        //Bottom
        if (startRow < endRow) {
            getPathByTopRightDownLeft(startRow+1, startCol, endRow, endCol, matrix, "$path > B")
        }

        matrix[startRow][startCol] = true
    }

    fun getAllDirPathWithoutObstacle(startRow: Int, startCol: Int, endRow: Int, endCol: Int, binMatrix: Array<IntArray>, path: String) {
        if (startRow == endRow && startCol == endCol) {
            println(path.trim().removePrefix(">"))
            return
        }

        if (binMatrix[startRow][startCol] != 0) return

        binMatrix[startRow][startCol] = 1

        //Left
        if (startCol > 0) {
            getAllDirPathWithoutObstacle(startRow, startCol-1 ,endRow, endCol, binMatrix,"$path > L")
        }

        //Top
        if (startRow > 0) {
            getAllDirPathWithoutObstacle(startRow-1, startCol, endRow, endCol, binMatrix,"$path > T")
        }

        //Right
        if (startCol < endCol) {
            getAllDirPathWithoutObstacle(startRow, startCol+1, endRow, endCol, binMatrix,"$path > R")
        }

        //Down
        if (startRow < endRow) {
            getAllDirPathWithoutObstacle(startRow+1, startCol, endRow, endCol,binMatrix, "$path > D")
        }

        binMatrix[startRow][startCol] = 0
    }
}

fun main() {
    Solution().apply {
        getPathByRightDown(0,0,2,2,"")
        println("========================================================")
        val matrix = arrayOf(
            booleanArrayOf(true, true, false),
            booleanArrayOf(true, true, true),
            booleanArrayOf(true, true, true)
        )
        getPathByTopRightDownLeft(0,0,2,2, matrix, "")
        println("========================================================")
        val binMatrix = Array(3) { IntArray(3) }
        getAllDirPathWithoutObstacle(0,0,2,2,binMatrix,"")
    }
}



========================================================
 R > R > D > D
 R > D > R > D
 R > D > D > R
 D > R > R > D
 D > R > D > R
 D > D > R > R
========================================================
 R > B > L > B > R > R
 R > B > R > B
 R > B > B > R
 B > R > R > B
 B > R > B > R
 B > B > R > T > R > B
 B > B > R > R
========================================================
 R > R > D > L > L > D > R > R
 R > R > D > L > D > R
 R > R > D > D
 R > D > L > D > R > R
 R > D > R > D
 R > D > D > R
 D > R > T > R > D > D
 D > R > R > D
 D > R > D > R
 D > D > R > T > T > R > D > D
 D > D > R > T > R > D
 D > D > R > R
