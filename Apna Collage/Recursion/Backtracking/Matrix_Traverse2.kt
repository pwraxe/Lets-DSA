class Solution {

    fun getAllRightDownWays(startRow: Int, startCol: Int, endRow: Int, endCol: Int) : Int {
        if (startRow == endRow && startCol == endCol) {
            return 1
        }

        var count = 0
        //Right
        if (startCol < endCol) {
            count += getAllRightDownWays(startRow, startCol+1, endRow, endCol)
        }

        //Down
        if (startRow < endRow) {
            count += getAllRightDownWays(startRow+1, startCol, endRow, endCol)
        }

        return count
    }
    fun getAllDirWays(startRow: Int, startCol: Int, endRow: Int, endCol: Int, board: Array<IntArray>, path:String): Int {
        if (startRow == endRow && startCol == endCol) {
            println(path)
            return 1
        }

        if (board[startRow][startCol] == 1) return 0

        board[startRow][startCol] = 1

        var count = 0
        //Left
        if(startCol > 0) {
            count += getAllDirWays(startRow, startCol-1, endRow, endCol, board, "${path}L")
        }

        //Top
        if (startRow > 0) {
            count += getAllDirWays(startRow-1, startCol, endRow, endCol,board,"${path}T")
        }

        //Right
        if (startCol < endCol) {
            count += getAllDirWays(startRow, startCol+1, endRow, endCol, board,"${path}R")
        }

        //Bottom
        if (startRow < endRow) {
            count += getAllDirWays(startRow+1, startCol, endRow, endCol, board, "${path}B")
        }

        board[startRow][startCol] = 0

        return count
    }
}


fun main() {

    Solution().apply {
        println(getAllRightDownWays(0,0,2,2))
        val n = 3
        val board = Array(n) { IntArray(n) }
        println(getAllDirWays(0,0,n-1,n-1, board,""))
    }
}
