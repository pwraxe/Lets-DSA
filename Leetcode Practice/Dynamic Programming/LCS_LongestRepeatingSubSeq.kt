import kotlin.math.max

class Solution {

    private lateinit var result: Array<IntArray>

    private fun lrs(i: Int, str1: String, j: Int, str2: String): Int {
        if (i == 0 || j == 0) return 0
        if (result[i][j] != 0) return result[i][j]

        result[i][j] = if (str1[i-1] == str2[j-1] && i != j) {
            1 + lrs(i-1, str1, j-1, str2)
        } else {
            max(lrs(i-1, str1, j, str2), lrs(i, str1, j-1, str2))
        }

        return result[i][j]
    }
    private fun printLRS(str: String) : String {
        var res = ""
        var i = str.length
        var j = str.length
        while (i > 0 && j > 0) {
            if (str[i-1] == str[j-1] && i != j) {
                res += str[i-1]
                i--
                j--
            } else {
                if (result[i-1][j] > result[i][j-1]) {
                    i--
                } else j--
            }
        }
        return res.reversed()
    }
    fun longestRepeatingSubsequence(str: String) {
        //Memorization
        //result = Array(str.length+1) { IntArray(str.length+1) }
        //val lrs = lrs(str.length,str,str.length,str)
        //println("LRS Length: $lrs | LRS: ${printLRS(str)}")

        //Tabulation
        result = Array(str.length+1) { IntArray(str.length+1) }
        for (i in 1 .. str.length) {
            for(j in 1 .. str.length) {
                if (i != j && str[i-1] == str[j-1]) {
                    result[i][j] = result[i-1][j-1] + 1
                } else {
                    result[i][j] = Math.max(result[i-1][j], result[i][j-1])
                }
            }
        }
        println("LRS Length: ${result[str.length][str.length]} | LRS: ${printLRS(str)}")
    }
}
fun main() {
    Solution().apply {
        longestRepeatingSubsequence("AABEBCDD")
    }
}


//LRS Length: 3 | LRS: ABD
