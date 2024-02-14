class Solution {
    
    private fun isSafeToPlace(board: Array<IntArray>, row: Int, col: Int, num: Int): Boolean {

        //check row
        for (c in board.indices) {
            if (board[row][c] == num) return false
        }

        //check col
        for (r in board.indices) {
            if (board[r][col] == num) return false
        }

        //check box
        val startRow = (row/3) * 3 //row - row % 3
        val startCol = (col/3) * 3 //col - col % 3

        for (r in startRow ..< startRow + 3) {
            for (c in startCol ..< startCol + 3) {
                if (board[r][c] == num) return false
            }
        }
        return true
    }
    private fun doSolved(board: Array<IntArray>, row: Int, col: Int): Boolean {

        if (row == 9 && col == 0) return true


        //Next Row Col taken if at last col or value exist
        var nextRow = row
        var nextCol = col + 1

        if (nextCol == 9) {
            nextRow = row + 1
            nextCol = 0
        }

        if (board[row][col] != 0) {
            return doSolved(board, nextRow, nextCol)
        }

        for (num in 1 ..9) {
            if (isSafeToPlace(board, row, col, num)) {
                board[row][col] = num
                if (doSolved(board, nextRow, nextCol)) {
                    return true
                }
                board[row][col] = 0
            }
        }

        return false

    }
    fun solveSudoku(board: Array<IntArray>) {
        if (doSolved(board,0,0)) {
            board.forEach {
                println(it.joinToString(" "))
            }
        } else {
            println("can't")
        }
    }
}


fun main() {
    Solution().apply {
        val sudokuBoard = arrayOf(
            intArrayOf(5, 3, 0, 0, 7, 0, 0, 0, 0),
            intArrayOf(6, 0, 0, 1, 9, 5, 0, 0, 0),
            intArrayOf(0, 9, 8, 0, 0, 0, 0, 6, 0),
            intArrayOf(8, 0, 0, 0, 6, 0, 0, 0, 3),
            intArrayOf(4, 0, 0, 8, 0, 3, 0, 0, 1),
            intArrayOf(7, 0, 0, 0, 2, 0, 0, 0, 6),
            intArrayOf(0, 6, 0, 0, 0, 0, 2, 8, 0),
            intArrayOf(0, 0, 0, 4, 1, 9, 0, 0, 5),
            intArrayOf(0, 0, 0, 0, 8, 0, 0, 7, 9)
        )

        solveSudoku(sudokuBoard)
    }
}



5 3 4 6 7 8 9 1 2
6 7 2 1 9 5 3 4 8
1 9 8 3 4 2 5 6 7
8 5 9 7 6 1 4 2 3
4 2 6 8 5 3 7 9 1
7 1 3 9 2 4 8 5 6
9 6 1 5 3 7 2 8 4
2 8 7 4 1 9 6 3 5
3 4 5 2 8 6 1 7 9
