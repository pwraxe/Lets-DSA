class Solution {

    fun sortBoard(board: Array<IntArray>, sequence: IntArray) {
        val rows = board.size
        val cols = board[0].size
        var index = 0
        var r = rows-1
        var c = cols-1
        var steps = 0

        while (index < sequence.size-1) {
            //check border

            //get 4 values
            var topValue = -1
            var rightValue = -1
            var bottomValue = -1
            var leftValue = -1

            if(r-1 >= 0) topValue = board[r-1][c]
            if(c+1 < cols) rightValue = board[r][c+1]
            if(r+1 < rows) bottomValue = board[r+1][c]
            if(c-1 >= 0) leftValue = board[r][c-1]

            //[2][1] <7> = 10 || -1 | 5 | 11 | 15
//            println("\n[$r][$c]=${board[r][c]}    s[$index]=${sequence[index]} ")
//            println("L = $leftValue, T = $topValue , R = $rightValue , B = $bottomValue")
            if(topValue != -1) {
                if(topValue == sequence[index]) {
                    board[r][c] = board[r-1][c].also { board[r-1][c] = board[r][c]  }
                    steps++
                    index++
                    r--
                }
            }
            if(rightValue != -1) {
                if (rightValue == sequence[index]) {
                    board[r][c] = board[r][c+1].also { board[r][c+1] = board[r][c]  }
                    steps++
                    index++
                    c++
                }
            }
            if(bottomValue != -1) {
                if (bottomValue == sequence[index]) {
                    board[r][c] = board[r+1][c].also { board[r+1][c] = board[r][c]  }
                    steps++
                    index++
                    r++
                }
            }
            if (leftValue != -1) {
                if (leftValue == sequence[index]) {
                    board[r][c] = board[r][c-1].also { board[r][c-1] = board[r][c] }
                    steps++
                    index++
                    c--
                }
            }
        }
        println("\n[$r][$c]=${board[r][c]}    s[$index]=${sequence[index]} | ${board[r][c-1]} ")
        board[r][c] = board[r][c+1].also { board[r][c+1] = board[r][c] }
        steps++

        println("Total Steps: $steps")
        board.forEach {
            println(it.toTypedArray().contentToString())
        }
    }
}
fun main() {
    val board = arrayOf(
        intArrayOf(1, 6, 2, 4),
        intArrayOf(9, 5, 3, 8),
        intArrayOf(10, 7, 11, 12),
        intArrayOf(13, 15, 14, 0))

    val sequence = intArrayOf(14, 11, 7, 10, 9, 5, 6 ,2, 3, 7, 11, 14)

    Solution().apply {
        sortBoard(board, sequence)
    }
}
