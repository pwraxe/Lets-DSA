//4.0, The Horse in chess
class Solution {

    var allPlaces = mutableListOf<Array<CharArray>>()
    private fun isSafe(row: Int, col: Int, matrix: Array<CharArray>): Boolean {


        //Left
        if (col-2 >= 0) {
            if (row+1 >= matrix.size || row-1 < 0) return false
        } else return false


        //Top
        if (row-2 >= 0) {
            if (col-1 < 0 || col+1 > matrix.size) return false
        } else return false

        //Right
        if (col+2 < matrix.size) {
            if (row-1 < 0 || row+1 >= matrix.size) return false
        }else return false


        //Bottom
        if (row+2 < matrix.size) {
            if (col+1 >= matrix.size || col-1 < 0) return false
        } else return false

        return true
    }

    fun horseInChess(matrix: Array<CharArray>) {
        for (r in matrix.indices) {
            for (c in matrix.indices) {

                if (isSafe(r,c,matrix)) {
                    matrix[r][c] = 'H'
                    allPlaces.add(matrix)
                }
            }
        }
    }
}

fun main() {
    Solution().apply {
        val matrix = arrayOf(
            charArrayOf('_','_','_','_','_'),
            charArrayOf('_','_','_','_','_'),
            charArrayOf('_','_','_','_','_'),
            charArrayOf('_','_','_','_','_'),
            charArrayOf('_','_','_','_','_'),
        )
        horseInChess(matrix)

        allPlaces.forEach {
            it.forEach {
                print(it.joinToString(" "))
                println()
            }
        }
    }
}


_ _ _ _ _
_ _ _ _ _
_ _ H _ _
_ _ _ _ _
_ _ _ _ _
