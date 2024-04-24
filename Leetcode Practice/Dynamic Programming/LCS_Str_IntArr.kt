//LCS-1: Get Length of LCS
//LCS-2: Get LCS
class Solution {

    private lateinit var result1: Array<IntArray>
    private fun lcs(i:Int,j:Int, s: String, t: String): Int {
        if (i == s.length || j == t.length) return 0
        if (result1[i][j] != 0) return result1[i][j]
        if (s[i] == t[j]) {
            result1[i][j] = 1 + lcs(i+1, j+1, s, t)
        } else {
            result1[i][j] = Math.max(lcs(i+1, j, s, t),lcs(i, j+1, s, t))
        }
        return result1[i][j]
    }
    fun longestCommonSubSeq1(s: String, t:String): Int {
        result1 = Array(s.length+1) { IntArray(t.length+1) }
        return lcs(0,0,s,t)
    }
    fun longestCommonSubSeq2(s: String,  t: String): String {
        result1 = Array(s.length+1) { IntArray(t.length+1) }
        lcs(0,0,s,t)

        var i = result1.lastIndex
        var j = result1.lastIndex
        var seq = ""
        while (i > 0 && j > 0) {
            if (s[i-1] == t[j-1]) {
                seq  = "${s[i-1]}$seq"
                i--
                j--
            } else {
                if (result1[i-1][j] > result1[i][j-1]) {
                    i--
                } else j--
            }
        }
        return seq
    }

    //==========================================================================
    private lateinit var result2: Array<IntArray>
    private fun lis(i: Int,j:Int, s1: IntArray, s2: IntArray): Int {
        if (i == s1.size || j == s2.size) return 0
        if (result2[i][j] != 0) return result2[i][j]
        if (s1[i] == s2[j]) {
            result2[i][j] = 1 + lis(i+1, j+1, s1, s2)
        } else {
            result2[i][j] = Math.max(lis(i+1,j, s1, s2), lis(i, j+1, s1, s2))
        }
        return result2[i][j]
    }
    fun longestIncreasingSubSeq1(s1: IntArray, s2: IntArray): Int {
        result2 = Array(s1.size+1) { IntArray(s2.size+1) }
        return lis(0,0,s1, s2)
    }
    fun longestIncreasingSubSeq2(s1: IntArray, s2: IntArray): List<Int> {
        result2 = Array(s1.size+1) { IntArray(s2.size+1) }
        val length = lis(0,0,s1, s2)
        val list = mutableListOf<Int>()
        var i = result2.lastIndex
        var j = result2.lastIndex
        while (i > 0 && j > 0) {
            if (s1[i-1] == s2[j-1]) {
                list.add(0,s1[i-1])
                i--
                j--
            } else {
                if (result2[i-1][j] > result2[i][j-1]) i-- else j--
            }
        }
        return list
    }
}

//a b c d e f
//0 1 2 3 4 5
fun main() {
    Solution().apply {
        println(longestCommonSubSeq1("abcde","abefd"))
        println(longestCommonSubSeq2("abcde","abefd"))
        println("===============================================")
        println(longestIncreasingSubSeq1(intArrayOf(0,1,2,3,4), intArrayOf(0,1,4,5,3)))
        println(longestIncreasingSubSeq2(intArrayOf(0,1,2,3,4), intArrayOf(0,1,4,5,3)))
    }
}

// 3
// abe
// ===============================================
// 3
// [0, 1, 4]
