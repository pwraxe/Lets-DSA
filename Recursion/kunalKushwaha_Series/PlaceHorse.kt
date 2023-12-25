//Horse Problem like N-Queen
class Solution {

    private fun isValid(row: Int, col: Int, board: Array<CharArray>): Boolean {
        return row >= 0 && row < board.size && col >= 0 && col < board.size
    }
    private fun isSafePlace(row: Int, col: Int, board: Array<CharArray>): Boolean {

        //Top - Left
        //Top - Right

        //Right - Top
        //Right - Bottom

        //Bottom - Left
        //Bottom - Right

        //Left - Top
        //Left - Bottom

        if (isValid(row-2, col-1, board)) {
            if (board[row-2][col-1] == 'H') return false
        }

        if (isValid(row-1, col-2, board)) {
            if (board[row-1][col-2] == 'H') return false
        }

        if (isValid(row-2, col+1, board)) {
            if (board[row-2][col+1] == 'H') return false
        }

        if (isValid(row-1, col+2, board)) {
            if (board[row-1][col+2] == 'H') return false
        }


        return true
    }

    private fun placeHorse(row: Int, board: Array<CharArray>) {
        if (row == board.size) {
            board.forEach {
                println(it.joinToString(" "))
            }
            println()
            return
        }

        for (col in board.indices) {
            if (isSafePlace(row,col, board)) {
                board[row][col] = 'H'
                placeHorse(row+1, board)
                board[row][col] = '_'
            }
        }
    }

    fun horseOnChess() {
        val n = 4
        placeHorse(0,Array(n){ CharArray(n) { '_' } })
    }
}

fun main() {
    Solution().apply {
        horseOnChess()
    }
}


//===============================

H _ _ _
H _ _ _
H _ _ _
H _ _ _

H _ _ _
H _ _ _
H _ _ _
_ _ _ H

H _ _ _
H _ _ _
_ _ _ H
H _ _ _

H _ _ _
H _ _ _
_ _ _ H
_ _ H _

H _ _ _
H _ _ _
_ _ _ H
_ _ _ H

H _ _ _
_ H _ _
H _ _ _
_ H _ _

H _ _ _
_ H _ _
H _ _ _
_ _ _ H

H _ _ _
_ H _ _
_ _ H _
_ H _ _

H _ _ _
_ H _ _
_ _ H _
_ _ _ H

H _ _ _
_ _ _ H
H _ _ _
H _ _ _

H _ _ _
_ _ _ H
H _ _ _
_ H _ _

H _ _ _
_ _ _ H
H _ _ _
_ _ _ H

H _ _ _
_ _ _ H
_ _ H _
_ H _ _

H _ _ _
_ _ _ H
_ _ H _
_ _ _ H

H _ _ _
_ _ _ H
_ _ _ H
H _ _ _

H _ _ _
_ _ _ H
_ _ _ H
_ _ _ H

_ H _ _
H _ _ _
_ H _ _
H _ _ _

_ H _ _
H _ _ _
_ H _ _
_ _ H _

_ H _ _
H _ _ _
_ _ _ H
H _ _ _

_ H _ _
H _ _ _
_ _ _ H
_ _ H _

_ H _ _
H _ _ _
_ _ _ H
_ _ _ H

_ H _ _
_ H _ _
_ H _ _
_ H _ _

_ H _ _
_ _ H _
_ H _ _
H _ _ _

_ H _ _
_ _ H _
_ H _ _
_ _ H _

_ H _ _
_ _ H _
_ _ _ H
H _ _ _

_ H _ _
_ _ H _
_ _ _ H
_ _ H _

_ _ H _
_ H _ _
H _ _ _
_ H _ _

_ _ H _
_ H _ _
H _ _ _
_ _ _ H

_ _ H _
_ H _ _
_ _ H _
_ H _ _

_ _ H _
_ H _ _
_ _ H _
_ _ _ H

_ _ H _
_ _ H _
_ _ H _
_ _ H _

_ _ H _
_ _ _ H
H _ _ _
H _ _ _

_ _ H _
_ _ _ H
H _ _ _
_ H _ _

_ _ H _
_ _ _ H
H _ _ _
_ _ _ H

_ _ H _
_ _ _ H
_ _ H _
_ H _ _

_ _ H _
_ _ _ H
_ _ H _
_ _ _ H

_ _ _ H
H _ _ _
H _ _ _
H _ _ _

_ _ _ H
H _ _ _
H _ _ _
_ _ _ H

_ _ _ H
H _ _ _
_ H _ _
H _ _ _

_ _ _ H
H _ _ _
_ H _ _
_ _ H _

_ _ _ H
H _ _ _
_ _ _ H
H _ _ _

_ _ _ H
H _ _ _
_ _ _ H
_ _ H _

_ _ _ H
H _ _ _
_ _ _ H
_ _ _ H

_ _ _ H
_ _ H _
_ H _ _
H _ _ _

_ _ _ H
_ _ H _
_ H _ _
_ _ H _

_ _ _ H
_ _ H _
_ _ _ H
H _ _ _

_ _ _ H
_ _ H _
_ _ _ H
_ _ H _

_ _ _ H
_ _ _ H
H _ _ _
H _ _ _

_ _ _ H
_ _ _ H
H _ _ _
_ H _ _

_ _ _ H
_ _ _ H
H _ _ _
_ _ _ H

_ _ _ H
_ _ _ H
_ _ _ H
H _ _ _

_ _ _ H
_ _ _ H
_ _ _ H
_ _ _ H



