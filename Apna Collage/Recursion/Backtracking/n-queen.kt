 class Solution {

    private val allBoard = mutableListOf<Array<CharArray>>()
    private fun isSafe(row: Int, col: Int, board: Array<CharArray>): Boolean {
        var r = row
        var c = col

        //Left
        while (c >= 0) {
            if (board[r][c--] == 'Q') return false
        }
        r = row
        c = col

        //Top
        while (r >= 0) {
            if (board[r--][c] == 'Q') return false
        }
        r = row
        c = col

        //Right
        while (c < board.size) {
            if (board[r][c++] == 'Q') return false
        }
        r = row
        c = col

        //Bottom
        while (r < board.size) {
            if (board[r++][c] == 'Q') return false
        }

        r = row
        c = col

        //Top-Left
        while (r >=0 && c >= 0) {
            if (board[r--][c--] == 'Q') return false
        }
        r = row
        c = col

        //Top-Right
        while(r >= 0 && c < board.size) {
            if (board[r--][c++] == 'Q') return false
        }
        r = row
        c = col

        //Bottom-Right
        while (r < board.size && c < board.size) {
            if (board[r++][c++] == 'Q') return false
        }
        r = row
        c = col

        //Bottom-Left
        while (r < board.size && c >= 0) {
            if (board[r++][c--] == 'Q') return false
        }

        return true

    }
    private fun placeQueen(row: Int, board:Array<CharArray>) {
        if (row == board.size) {
            allBoard.add(board)
            showBoard(board)
            return
        }

        for (col in 0 until board.size) {
            if (isSafe(row, col, board)) {
                board[row][col] = 'Q'
                placeQueen(row+1, board)
                board[row][col] = 'x'
            }
        }
    }
    private fun showBoard(board:Array<CharArray>) {
        board.forEach {
            println(it.joinToString(" "))
        }

        println("-----------------")
    }
    fun nQueen(n: Int) {
        val board = Array(n) { CharArray(n) { 'x' } }
        placeQueen(0, board)
        println("total Ways: ${allBoard.size}")
    }
}

fun main() {

    Solution().apply {
        nQueen(5)
    }
}
