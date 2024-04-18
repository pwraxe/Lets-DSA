import kotlin.math.max

class Solution {

    private lateinit var result: Array<IntArray>
    private fun longestSubSeq(s1: String, i:Int, s2: String, j: Int): Int {
        if (i == 0 || j == 0) return 0
        if (result[i][j] != -1) return result[i][j]

        result[i][j] = if (s1[i-1] == s2[j-1]) {
            1 + longestSubSeq(s1, i-1, s2, j-1)
        } else {
            max(longestSubSeq(s1, i-1, s2, j),longestSubSeq(s1, i, s2, j-1))
        }
        return result[i][j]
    }
    fun longestCommonSubsequence(text1: String, text2: String): Int {
        //result = Array(text1.length+1) { IntArray(text2.length+1) { -1 } }
        //return longestSubSeq(text1,text1.length,text2,text2.length)

        result = Array(text1.length+1) { IntArray(text2.length+1) }

        for (i in 1 .. text1.length) {
            for (j in 1 .. text2.length) {
                result[i][j] = if (text1[i-1] == text2[j-1]) {
                    result[i-1][j-1] + 1
                } else {
                    max(result[i-1][j], result[i][j-1])
                }
            }
        }
        result.forEach {
            println(it.toTypedArray().contentToString())
        }
        return result[text1.length][text2.length]
    }
}


fun main() {

    Solution().apply {

        println(longestCommonSubsequence("abcde","ace"))
        println(longestCommonSubsequence("abcdef","abdefg"))

    }
}

3
5
