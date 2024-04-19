import kotlin.math.max

class Solution {
    private lateinit var result: Array<IntArray>

    private fun shortestCS(i: Int, s1: String, j: Int,s2: String): Int {
        if (i == 0 || j == 0) return 0
        if (result[i][j] != 0) return result[i][j]

        result[i][j] = if (s1[i-1] == s2[j-1]) {
            1 + shortestCS(i-1, s1, j-1, s2)
        } else {
            max(shortestCS(i-1, s1, j, s2), shortestCS(i, s1, j-1, s2))
        }

        return result[i][j]
    }
    fun shortestCommonSuperSeq(s1: String, s2: String): Int {
        result = Array(s1.length+1) { IntArray(s2.length+1) }
        val lcs = shortestCS(s1.length,s1, s2.length, s2)
        return (s1.length+s2.length) - lcs
    }
}

fun main() {
    Solution().apply {
        println(shortestCommonSuperSeq("AGGTAB","GXTXAYB")) //9
    }
}
