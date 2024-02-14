import kotlin.math.sqrt

class Solution {
  
    private fun isSafePlace(row: Int, col:Int, board: Array<IntArray>, num: Int): Boolean {
        //check for row
        for (c in board.indices) {
            if (board[row][c] == num) return false
        }

        //check for col
        for (r in board.indices) {
            if (board[r][col] == num) return false
        }
        
        //check for box

        val sqrt = sqrt(board.size * 1.0).toInt()

        val startRow = row - row % sqrt
        val startCol = col - col % sqrt

        println("$startRow | $startCol: $sqrt")

        for (r in startRow ..< startRow + sqrt) {
            for (c in startCol ..< startCol + sqrt) {
                if (board[r][c] == num) return false
            }
        }

        return true
    }
    fun solveSudoku(board: Array<IntArray>): Boolean {

        var row = -1
        var col = -1
        var isEmptyLeft = true

        for (r in board.indices) {
            for (c in board.indices) {
                if (board[r][c] == 0) {
                    row = r
                    col = c
                    isEmptyLeft = false
                    break
                }
            }

            if (!isEmptyLeft) {
                break
            }
        }

        if (isEmptyLeft) {
            return true
        }

        for (num in 1 .. 9) {

            if (isSafePlace(row,col,board, num)) {
                board[row][col] = num
                if (solveSudoku(board)) {
                    return true
                }
                board[row][col] = 0
            }
        }
        return false
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

       if (solveSudoku(sudokuBoard)) {
           sudokuBoard.forEach {
               println(it.joinToString(" "))
           }
       }
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
