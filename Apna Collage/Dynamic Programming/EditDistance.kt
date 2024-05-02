/*
* LOGIC
*
*   - if same char then i-1, j-1
*   - if diff char
*       - call for addChar, deleteChar, replaceChar
*       - Min(addChar, deleteChar, replaceChar) + 1
*   Take care of a base case
*       - if i == 0 return j if j == 0 return i
* 
*
* */
class EditDistance {

    private fun editDist(i:Int, j:Int, srcWord: String, destWord: String, dp: Array<IntArray>): Int {
        if(i == 0 || j == 0) {
            if (i == 0) return j
            return i
        }
        if (dp[i][j] != -1) return dp[i][j]

        if (srcWord[i-1] == destWord[j-1]) {
            dp[i][j] = editDist(i-1, j-1, srcWord, destWord, dp)
        } else {
            val addOp = editDist(i-1, j, srcWord, destWord, dp)
            val deleteOp = editDist(i,j-1, srcWord, destWord, dp)
            val replaceOp = editDist(i-1, j-1, srcWord, destWord, dp)
            dp[i][j] = minOf(addOp, deleteOp, replaceOp) + 1
        }
        return dp[i][j]
    }
    fun editDistanceMemo(srcWord: String, destWord: String): Int {
        val dp = Array<IntArray>(srcWord.length+1) { IntArray(destWord.length+1 ) { -1 } }
        editDist(srcWord.length, destWord.length, srcWord,destWord,dp)
        dp.forEach {
            println(it.toTypedArray().contentToString())
        }
        return dp[srcWord.length][destWord.length]
    }


    fun editDistanceTabu(srcWord: String, destWord: String): Int {
        val dp = Array(srcWord.length+1) { IntArray(destWord.length+1) }
        for (i in 1 .. srcWord.length) {
            for (j in 1 .. destWord.length) {
                if (srcWord[i-1] == destWord[j-1]) {
                    dp[i][j] = dp[i-1][j-1]
                } else {
                    dp[i][j] = minOf(dp[i-1][j], dp[i][j-1], dp[i-1][j]) + 1
                }
            }
        }
        dp.forEach {
            println(it.toTypedArray().contentToString())
        }
        return dp[srcWord.length][destWord.length]
    }
}

fun main() {
    EditDistance().apply {
        println(editDistanceMemo("intention","execution"))
        println(editDistanceTabu("intention","execution"))
    }
}



//============================================================

[-1, -1, -1, -1, -1, -1, -1, -1, -1, -1]
[-1, 1, 2, 3, 4, 5, -1, -1, -1, -1]
[-1, 2, 2, 3, 4, 5, -1, -1, -1, -1]
[-1, 3, 3, 3, 4, 5, -1, -1, -1, -1]
[-1, 3, 4, 3, 4, 5, -1, -1, -1, -1]
[-1, 4, 4, 4, 4, 5, -1, -1, -1, -1]
[-1, -1, -1, -1, -1, -1, 5, -1, -1, -1]
[-1, -1, -1, -1, -1, -1, -1, 5, -1, -1]
[-1, -1, -1, -1, -1, -1, -1, -1, 5, -1]
[-1, -1, -1, -1, -1, -1, -1, -1, -1, 5]
5
[0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
[0, 1, 1, 1, 1, 1, 1, 0, 1, 1]
[0, 1, 2, 2, 2, 2, 2, 1, 2, 1]
[0, 1, 2, 3, 3, 3, 2, 2, 3, 2]
[0, 0, 1, 2, 3, 4, 3, 3, 4, 3]
[0, 1, 2, 3, 4, 5, 4, 4, 5, 4]
[0, 1, 2, 3, 4, 5, 5, 5, 6, 5]
[0, 1, 2, 3, 4, 5, 6, 5, 6, 6]
[0, 1, 2, 3, 4, 5, 6, 6, 5, 6]
[0, 1, 2, 3, 4, 5, 6, 7, 6, 5]
5
