fun main() {
    val totalQueens = 4
    val allBoard = mutableListOf<Array<IntArray>>()
    val board = Array<IntArray>(totalQueens) { IntArray(totalQueens) }
    totalNQueens(0, board, allBoard)
    allBoard.forEach {matrix ->
        matrix.forEach {
            println(it.toTypedArray().contentToString())
        }
        println()
    }
}

fun totalNQueens(row: Int, board: Array<IntArray>,allBoards: MutableList<Array<IntArray>>) {
    if(row == board.size) {
        val clone = Array(board.size) { board[it].copyOf() }
        allBoards.add(clone)
        return
    }

    for (col in 0 until board.size) {
        if(isThisSafePosition(row, col, board)) {
            board[row][col] = 1
            totalNQueens(row+1, board, allBoards)
            board[row][col] = 0
        }
    }
}

fun isThisSafePosition(row: Int, col: Int, board: Array<IntArray>) : Boolean {
    var r = row
    var c = col

    //Left
    while (c >= 0) {
        if(board[r][c] == 1) return false
        c--
    }

    c = col
    //Top-Left
    while (r >= 0 && c >= 0) {
        if(board[r][c] == 1) return false
        r--
        c--
    }

    r = row
    c = col
    //Top
    while (r >= 0) {
        if(board[r][c] == 1) return false
        r--
    }

    r = row
    //Top-Right
    while (r >= 0 && c <  board.size) {
        if(board[r][c] == 1) return false
        r--
        c++
    }

    return true
}
