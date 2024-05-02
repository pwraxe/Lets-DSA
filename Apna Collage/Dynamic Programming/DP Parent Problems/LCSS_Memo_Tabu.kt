//Longest Common SubString
class LCSS {

    private var count : Int = 0
    private fun lcssMemo(i: Int, j: Int, s1: String, s2: String, dp: Array<IntArray>): Int {
        if (i == 0 || j == 0) return 0
        if (dp[i][j] != -1) return dp[i][j]

        if (s1[i-1] ==s2[j-1]) {
            dp[i][j] = 1 + lcssMemo(i-1, j-1, s1, s2, dp)
            count = Math.max(count, dp[i][j])
        } else {
            lcssMemo(i-1, j, s1, s2, dp)
            lcssMemo(i, j-1, s1, s2, dp)
            dp[i][j] = 0
        }
        return dp[i][j]
    }
    fun longestCommonSubStringMemo(s1: String, s2: String): Int {
        val dp = Array(s1.length+1) { IntArray(s2.length+1) { -1 } }
        val res = lcssMemo(s1.length,s2.length,s1, s2, dp)
        println("res = $res | dp[s1.length][s2.length] = ${dp[s1.length][s2.length]} | Count = $count")
        return count
    }

    fun longestCommonSubStringTabu(s1: String, s2: String): Int {
        val dp = Array(s1.length+1) { IntArray(s2.length+1) }
        var maxCount = 0
        for (i in 1 .. s1.length) {
            for (j in 1 .. s2.length) {
                if (s1[i-1] == s2[j-1]) {
                    dp[i][j] = 1 + dp[i-1][j-1]
                    maxCount = Math.max(maxCount, dp[i][j])
                }
            }
        }
        return maxCount
    }
}

fun main() {
    LCSS().apply {
        println("Memo: ${longestCommonSubStringMemo("ABCDE","ABGCE")}")
        println("Tabu: ${longestCommonSubStringTabu("ABCDE","ABGCE")}")
    }
}



//==================================================
res = 1 | dp[s1.length][s2.length] = 1 | Count = 2
Memo: 2
Tabu: 2
