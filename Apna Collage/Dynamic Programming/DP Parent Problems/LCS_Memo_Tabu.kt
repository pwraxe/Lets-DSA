class LCS {

    private fun lcsByMemo(i: Int, j: Int, s1: String, s2: String, dp:Array<IntArray>): Int {
        if (i == s1.length || j == s2.length) return 0
        if (dp[i][j] != -1) return dp[i][j]
        if (s1[i] == s2[j]) {
            dp[i][j] = 1 + lcsByMemo(i+1, j+1, s1, s2, dp)
        } else {
            dp[i][j] = Math.max(lcsByMemo(i+1, j, s1, s2, dp), lcsByMemo(i, j+1, s1, s2, dp))
        }
        return dp[i][j]
    }
    fun longestCommonSubSequenceMemo(s1: String, s2: String): Int {
        val dp = Array(s1.length+1) { IntArray(s2.length+1) { -1 } }
        val res = lcsByMemo(0,0,s1, s2, dp)
        println("$res | ${dp[0][0]}")
        return dp[0][0]
    }

    fun longestCommonSubSequenceTabu(s1: String, s2: String): Int {
        val dp = Array(s1.length+1) { IntArray(s2.length+1) }
        for (i in 1 .. s1.length) {
            for (j in 1 .. s2.length) {
                if (s1[i-1] == s2[j-1]) {
                    dp[i][j] = 1 + dp[i-1][j-1]
                }else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1])
                }
            }
        }
        return dp[s1.length][s2.length]
    }
}

fun main() {
    LCS().apply {

        longestCommonSubSequenceMemo("ABCDEF","ACEF")
        longestCommonSubSequenceMemo("IAMSOFTDEV","YOUARESOFTENGG")

        println("=======================================================")

        println(longestCommonSubSequenceTabu("ABCDEF","ACEF"))
        println(longestCommonSubSequenceTabu("IAMSOFTDEV","YOUARESOFTENGG"))
    }
}


res = 4 | dp[0][0] = 4
res = 6 | dp[0][0] = 6
=======================================================
4
6
