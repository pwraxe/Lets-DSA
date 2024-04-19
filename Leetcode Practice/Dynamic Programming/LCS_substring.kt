import kotlin.math.max

class Solution {

    private lateinit var result: Array<IntArray>

    private fun lcSubstring(i: Int, s1: String, j: Int, s2: String, count: Int): Int {
        if (i == s1.length || j == s2.length) return 0
        if (result[i][j] != 0) return result[i][j]

        if (s1[i] == s2[j]) {
            result[i][j] = lcSubstring(i+1, s1, j+1, s2, count+1)
        } else {
            result[i][j] = Math.max(lcSubstring(i+1, s1, j, s2, 0), lcSubstring(i, s1, j+1, s2, 0))
            result[i][j] = max(result[i][j], count)
        }
        return result[i][j]
    }
    fun longestCommonSubstring(s1: String, s2: String): Int {
        //Memorization
        //result = Array(s1.length+1) { IntArray(s2.length+1) }
        //return lcSubstring(0,s1,0,s2,0)

        //Tabulation
        result = Array(s1.length+1) { IntArray(s2.length+1) }
        var count = 0
        for (i in 1.. s1.length) {
            for (j in  1 .. s2.length) {
                if (s1[i-1] == s2[j-1]) {
                    result[i][j] = result[i-1][j-1] + 1
                    count = max(result[i][j],count)
                } else {
                    result[i][j] = 0
                }
            }
        }

        result.forEach {
            println(it.toTypedArray().contentToString())
        }
        return count
    }
}

fun main() {
    Solution().apply {
        println(longestCommonSubstring("abcdefghipqr","axcgefghijkl"))
    }
}
