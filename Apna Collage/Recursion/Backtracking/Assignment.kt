class Assignment {


    //Question-1
    private fun findPath(startRow: Int, startCol: Int, endRow: Int, endCol: Int, maze: Array<IntArray>, path: Array<IntArray>) {
        if (startRow == endRow && startCol == endCol) {
            path[startRow][startCol] = 1
            path.forEach {
                println(it.joinToString(" "))
            }
            return
        }

        if (maze[startRow][startCol] == 0 || maze[startRow][startCol] == 2) return
        val temp = maze[startRow][startCol]
        maze[startRow][startCol] = 2

        //Left
        if (startCol > 0) {
            path[startRow][startCol] = 1
            findPath(startRow, startCol-1, endRow, endCol, maze, path)
            path[startRow][startCol] = 0
        }

        //Top
        if (startRow > 0) {
            path[startRow][startCol] = 1
            findPath(startRow-1, startCol, endRow, endCol, maze, path)
            path[startRow][startCol] = 0
        }

        //Right
        if (startCol < endCol) {
            path[startRow][startCol] = 1
            findPath(startRow, startCol+1, endRow, endCol, maze, path)
            path[startRow][startCol] = 0
        }

        //Down
        if (startRow < endRow) {
            path[startRow][startCol] = 1
            findPath(startRow+1, startCol, endRow, endCol, maze, path)
            path[startRow][startCol] = 0
        }
        maze[startRow][startCol] = temp
    }
    fun ratInMaze(maze: Array<IntArray>, startRow: Int, startCol: Int) {
        val endRow = maze.lastIndex
        val endCol = maze[0].lastIndex
        val path = Array(endCol+1) { IntArray(endRow+1) }
        findPath(startRow, startCol,endRow, endCol, maze, path)
    }


    //Question-2
    private val numToAlphabet = mapOf(
        '2' to "abc", '3' to "def",
        '4' to "ghi", '5' to "jkl", '6' to "mno",
        '7' to "pqrs", '8' to "tuv", '9' to "wxyz" )
    private val result = mutableListOf<String>()
    private fun doNumCombination(digit: String, index :Int, subString: StringBuilder) {
        if (index == digit.length) {
            result.add(subString.toString())
            return
        }

        val text = numToAlphabet[digit[index]] ?: ""
        for (char in text) {
            subString.append(char)
            doNumCombination(digit, index+1, subString)
            subString.setLength(subString.length-1)
        }
    }
    fun keypadCombination(digit: String) {
        doNumCombination(digit, 0, StringBuilder())
        println(result.toTypedArray().contentToString())
    }

    private val board = Array(8) { IntArray(8) }
    private fun doPlace(row: Int, col: Int, step: Int) {


        //Left-Up
        if (col - 2 >= 0 && row-1 >= 0) {
            if (board[row-1][col-2] == 0) {
                board[row-1][col-2] = step + 1
                doPlace(row-1, col-2, step+1)
            }
        }
        //Left-Down
        if(col - 2 >= 0 && row+1 < board.size) {
            if (board[row+1][col-2] == 0) {
                board[row+1][col-2] = step + 1
                doPlace(row+1, col-2, step+1)
            }
        }

        //Top-Left
        if (row - 2 >= 0 && col-1 >= 0) {
            if (board[row-2][col-1] == 0) {
                board[row-2][col-1] = step + 1
                doPlace(row-2, col-1, step+1)
            }
        }
        //Top-Right
        if (row-2 >= 0 && col+1 < board.size) {
            if (board[row-2][col+1] == 0) {
                board[row-2][col+1] = step + 1
                doPlace( row-2, col+1, step+1)
            }
        }

        //Right-Up
        if (col+2 < board.size && row-1 >= 0) {
            if (board[row-1][col+2] == 0) {
                board[row-1][col+2] = step + 1
                doPlace(row-1,col+2, step+1)
            }
        }
        //Right-Down
        if (col+2 < board.size && row+1 < board.size) {
            if (board[row+1][col+2] == 0) {
                board[row+1][col+2] = step + 1
                doPlace( row+1, col+2, step+1)
            }
        }

        //Bottom-Left
        if (row+2 < board.size && col-1 >= 0) {
            if (board[row+2][col-1] == 0) {
                board[row+2][col-1] = step + 1
                doPlace( row+2, col-1, step+1)
            }
        }

        //Bottom-Right
        if (row+2 < board.size && col+1 < board.size) {
            if (board[row+2][col+1] == 0) {
                board[row+2][col+1] = step
                doPlace( row+2, col+1, step+1)
            }
        }
    }
    fun placeKnights() {
        doPlace(0,0,0)
        board.forEach {
            println(it.joinToString("   "))
        }
    }
}

fun main() {
    Assignment().apply {
        val maze = arrayOf(
            intArrayOf(1, 0, 0, 0),
            intArrayOf(1, 1, 0, 1),
            intArrayOf(0, 1, 0, 0),
            intArrayOf(1, 1, 1, 1),
        )

        ratInMaze(maze,0,0)
        println("=============================")
        keypadCombination("")
        println("=============================")
        placeKnights()
    }
}


 
1 0 0 0
1 1 0 0
0 1 0 0
0 1 1 1
=============================
[]
=============================
2   17   4   9   34   19   36   49
5   8   1   18   35   10   33   20
16   2   6   11   32   21   48   36
7   12   15   22   39   34   49   54
26   23   40   13   48   31   38   47
41   14   27   24   43   46   53   49
28   25   42   47   30   51   44   55
43   48   29   52   45   54   51   52
