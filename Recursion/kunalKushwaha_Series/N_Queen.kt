class Solution {

    private fun isSafeToPlace(row:Int, col: Int, board: Array<CharArray>):Boolean {
        var r = row
        var c = col

        //left-top
        while (c >= 0 && r >= 0) {
            if (board[r][c] == 'Q') return false
            r--
            c--
        }
        r = row
        c = col

        //top
        while (r >= 0) {
            if (board[r][c] == 'Q') return false
            r--
        }
        r = row

        //top-right
        while (r >= 0 && c < board.size) {
            if (board[r][c] == 'Q') return false
            r--
            c++
        }

        return true
    }

    private fun placeQueens(row: Int, board: Array<CharArray>): Int {
        if (row == board.size) {
            board.forEach {
                it.forEach {
                    print(if (it == 'Q') "Q " else "_ ")
                }
                println()
            }
            println("=================\n")
            return 1
        }

        var count = 0
        for (col in 0 until board.size) {
            if (isSafeToPlace(row, col, board)) {
                board[row][col] = 'Q'
                count += placeQueens(row+1, board)
                board[row][col] = '.'
            }
        }
        return count
    }
    fun nQueens(n: Int) {
        val board = Array(n) { CharArray(n) { '.' } }
        println(placeQueens(0,board))
    }
}

fun main() {
    Solution().apply {
        nQueens(5)
    }
}
