class Solution {

    private lateinit var result:Array<IntArray>

    private fun lps(i: Int, s1: String, j: Int, s2: String): Int {
        if(i == 0 || j == 0) return 0
        if(result[i][j] != -1) return result[i][j]

        result[i][j] = if(s1[i-1] == s2[j-1]) {
            1 + lps(i-1, s1, j-1, s2)
        } else {
            Math.max(lps(i-1, s1, j, s2), lps(i, s1, j-1, s2))
        }

        return result[i][j]
    }
    fun longestPalindromeSubseq(s: String): Int {
        //Memorization

        //result = Array(s.length+1) { IntArray(s.length+1) { -1 }}
        //return lps(s.length,s,s.length,s.reversed())

        //Tabulation
        val s1 = s
        val s2 = s.reversed()
        result = Array(s1.length+1) { IntArray(s2.length+1) }
        for (i in 1 .. s1.length) {
            for (j in 1 .. s2.length) {
                if (s1[i-1] == s2[j-1]) {
                    result[i][j] = result[i-1][j-1] + 1
                } else {
                    result[i][j] = Math.max(result[i-1][j], result[i][j-1])
                }
            }
        }
        result.forEach {
            println(it.toTypedArray().contentToString())
        }
        return result[s1.length][s2.length]
    }
}
fun main() {
    Solution().apply {
        println(longestPalindromeSubseq("bbbab"))
        println(longestPalindromeSubseq("cbbd"))
    }
}
