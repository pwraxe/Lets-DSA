//3.0-A, N-Queen Problem,
class Solution {

    private fun isSafePlace(row: Int, col: Int, board: Array<CharArray>): Boolean {

        var r = row
        var c = col

        //Top-Left
        while (c >= 0 && r >= 0) {
            if (board[r][c] == 'Q') return false
            c--
            r--
        }
        r = row
        c = col

        //Top
        while (r >= 0) {
            if (board[r][c] == 'Q') return false
            r--
        }
        r = row

        //Top-Right
        while (r >= 0 && c < board.size) {
            if (board[r][c] == 'Q') return false
            r--
            c++
        }
        return true
    }

    private fun placeQueens(row: Int, board: Array<CharArray>): Int {
        if (row == board.size) {
            board.forEach {r->
                r.forEach { char ->
                    print(if (char == 'Q') "Q " else "_ ")
                }
                println()
            }
            println("\n")
            return 1
        }

        var count = 0
        for (col in board.indices) {
            if (isSafePlace(row, col, board)) {
                board[row][col] = 'Q'
                count += placeQueens(row+1, board)
                board[row][col] = '.'
            }
        }
        return count
    }
    fun nQueen(n: Int) {
        val matrix = Array(n) { CharArray(n) { '.' } }
        placeQueens(0,matrix)
    }
}

fun main() {
    Solution().apply {
        nQueen(4)
    }
}
