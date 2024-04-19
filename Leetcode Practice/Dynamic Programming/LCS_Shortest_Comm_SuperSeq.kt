//Leetcode: https://leetcode.com/problems/shortest-common-supersequence/description/


import kotlin.math.max

class Solution {

    private lateinit var result: Array<IntArray>

    private fun shortestCS(i: Int, str1: String, j: Int, str2: String): Int {
        if (i == 0 || j == 0) return 0
        if (result[i][j] != -1) return result[i][j]

        result[i][j] = if (str1[i-1] == str2[j-1]) {
            1 + shortestCS(i-1, str1, j-1, str2)
        } else {
            max(shortestCS(i-1, str1, j, str2), shortestCS(i, str1, j-1, str2))
        }

        return result[i][j]
    }
    fun shortestCommonSupersequence(str1: String, str2: String): String {
        //result = Array(str1.length+1) { IntArray(str2.length+1) { -1 } }
        //val scs = shortestCS(str1.length,str1, str2.length, str2)
         

        //Tabulation
        result = Array(str1.length+1) { IntArray(str2.length+1) }

        for (i in 1 .. str1.length) {
            for (j in 1 .. str2.length) {
                if (str1[i-1] == str2[j-1]) {
                    result[i][j] = 1 + result[i-1][j-1]
                } else {
                    result[i][j] = Math.max(result[i-1][j], result[i][j-1])
                }
            }
        }

        //Extracting Common String
        var i = str1.length
        var j = str2.length
        var str = ""
        while (i > 0 && j > 0) {
            if (str1[i-1] == str2[j-1]) {
                str += str1[i-1]
                i--
                j--
            } else {
                if (result[i-1][j] > result[i][j-1]) {
                    str += str1[i-1]
                    i--
                } else {
                    str += str2[j-1]
                    j--
                }
            }
        }
        while (i > 0) {
            str += str1[i-1]
            i--
        }

        while (j > 0) {
            str += str2[j-1]
            j--
        }

        return str.reversed()
    }
}


fun main() {
    Solution().apply {
        println(shortestCommonSupersequence("abac","cab")) //cabac  
        println(shortestCommonSupersequence("bbbaaaba","bbababbb"))  //bbbaaababbb
    }
}
