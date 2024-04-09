class Backtrack {

    fun fillArray(nums:IntArray, index:Int) {
        if (index == nums.size) {
            return
        }

        nums[index] = index+1
        fillArray(nums, index+1)
        nums[index] = nums[index] - 2
    }
    fun subSet(s: String, index: Int, res:String) {
        if (index == s.length) {
            println(res)
            return
        }

        subSet(s, index+1, res+s[index])
        subSet(s, index+1, res)
    }
    fun permutations(s: StringBuilder, index: Int) {
        if (index == s.length) {
            println(s.toString())
            return
        }

        for (i in index ..< s.length) {
            s[i] = s[index].also { s[index] = s[i] }
            permutations(s, index+1)
            s[i] = s[index].also { s[index] = s[i] }
        }
    }

    //===========================================================

    private fun isSafe(board: Array<CharArray>, row:Int, col: Int): Boolean {
        var r = row
        var c = col

        //Left
        while (c >= 0) {
            if (board[r][c] == 'Q') return false
            c--
        }
        c = col

        //Top-Left
        while (r >= 0 && c >= 0) {
            if (board[r][c] == 'Q') return false
            r--
            c--
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
        r = row
        c = col

        //Right
        while (c < board.size) {
            if (board[r][c] == 'Q') return false
            c++
        }
        c = col

        //Right-Bottom
        while (r < board.size && c < board.size) {
            if (board[r][c] == 'Q') return false
            r++
            c++
        }
        r = row
        c = col

        //Bottom
        while (r < board.size) {
            if (board[r][c] == 'Q') return false
            r++
        }
        r = row

        //Bottom-Left
        while (r < board.size && c >= 0) {
            if (board[r][c] == 'Q') return false
            r++
            c--
        }

        return true
    }
    private fun placeQueen(board:Array<CharArray>, row:Int) {
        if (row == board.size) {
            board.forEach {
                println(it.toTypedArray().contentToString())
            }
            println()
            return
        }

        for (col in board.indices) {
            if (isSafe(board,row,col)) {
                board[row][col] = 'Q'
                placeQueen(board, row+1)
                board[row][col] = '_'
            }
        }
    }
    fun nQueens(n:Int) {
        val board = Array(n) { CharArray(n){ '_' } }
        placeQueen(board,0)
    }

    //===========================================================
    fun totalWays(startRow:Int, startCol:Int, endRow:Int, endCol: Int, ways: Int): Int {
        if (startRow == endRow && startCol == endCol) {
            return ways
        }

        var count = 0
        //Right
        if (startCol < endCol) {
            count = totalWays(startRow, startCol+1, endRow, endCol, ways+1)
        }

        //Down
        if (startRow < endRow) {
            count = totalWays(startRow+1, startCol, endRow, endCol, ways+1)
        }

        return count
    }

    //===========================================================
    fun printTotalWays(startRow: Int, startCol: Int, endRow: Int, endCol: Int, road:String) {
        if (startRow == endRow && startCol == endCol) {
            println(road)
            return
        }

        //Right
        if(startCol < endCol) {
            printTotalWays(startRow, startCol+1, endRow, endCol, road+"R")
        }

        //Down
        if (startRow < endRow) {
            printTotalWays(startRow+1, startCol, endRow, endCol, road+"D")
        }
    }

    //===========================================================

    private fun isSafeCell(board: Array<IntArray>, row: Int, col: Int, digit:Int): Boolean {

        //Row
        for (c in 0 until board.size) {
            if (board[row][c] == digit) return false
        }

        //Col
        for (r in 0 until board.size) {
            if (board[r][col] == digit) return false
        }

        //3x3 Grid
        //How 3? = sqrt(board.size)
        val startRow = (row/3) * 3  // OR row - (row % 3)
        val startCol = (col/3) * 3  //OR col - (col % 3)

        for (r in startRow until startRow+3) {
            for (c in startCol until startCol+3) {
                if (board[r][c] == digit) return false
            }
        }

        return true
    }
    private fun canSolve(board: Array<IntArray>, row: Int, col: Int): Boolean {
        if (row == board.size) return true

        val nextRow = if (col + 1 == 9) row + 1 else row
        val nextCol = if (col + 1 == 9) 0 else col + 1

        if (board[row][col] == 0) {
            for (digit in 1 .. 9) {
                if (isSafeCell(board, row, col, digit)) {
                    board[row][col] = digit
                    if (canSolve(board, nextRow, nextCol)) {
                        return true
                    } else {
                        board[row][col] = 0
                    }

                }
            }
        } else {
            return canSolve(board, nextRow, nextCol)
        }

        return false
    }
    fun solvedSudoku(board: Array<IntArray>) {
        println(canSolve(board,0,0))
    }
}

fun main() {
    Backtrack().apply {
        val list = IntArray(5)
        fillArray(list,0)
        println(list.toTypedArray().contentToString())

        println("=====================SubSet")
        subSet("abc",0,"")

        println("=====================permutations")
        permutations(StringBuilder("ABC"),0)

        println("=====================n Queens")
        nQueens(4)

        println("===================2x2==Total Ways")
        println("Total Ways: ${totalWays(0,0,2,2,0)}")

        println("=============Print Total Ways (RD) in matrix")
        printTotalWays(0,0,2,2,"")

        println("can Solved Sudoku? ")
        val board = arrayOf(
            intArrayOf(3, 0, 6, 5, 0, 8, 4, 0, 0),
            intArrayOf(5, 2, 0, 0, 0, 0, 0, 0, 0),
            intArrayOf(0, 8, 7, 0, 0, 0, 0, 3, 1),
            intArrayOf(0, 0, 3, 0, 1, 0, 0, 8, 0),
            intArrayOf(9, 0, 0, 8, 6, 3, 0, 0, 5),
            intArrayOf(0, 5, 0, 0, 9, 0, 6, 0, 0),
            intArrayOf(1, 3, 0, 0, 0, 0, 2, 5, 0),
            intArrayOf(0, 0, 0, 0, 0, 0, 0, 7, 4),
            intArrayOf(0, 0, 5, 2, 0, 6, 3, 0, 0),
        )

        val matrix = arrayOf(
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

        solvedSudoku(matrix)
        solvedSudoku(board)
    }
}


[-1, 0, 1, 2, 3]
=====================SubSet
abc
ab
ac
a
bc
b
c

=====================permutations
ABC
ACB
BAC
BCA
CBA
CAB
=====================n Queens
[_, Q, _, _]
[_, _, _, Q]
[Q, _, _, _]
[_, _, Q, _]

[_, _, Q, _]
[Q, _, _, _]
[_, _, _, Q]
[_, Q, _, _]

===================2x2==Total Ways
Total Ways: 4
=============Print Total Ways (RD) in matrix
RRDD
RDRD
RDDR
DRRD
DRDR
DDRR
can Solved Sudoku? 
true
true
