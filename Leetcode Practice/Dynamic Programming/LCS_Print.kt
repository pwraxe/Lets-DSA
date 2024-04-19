import kotlin.math.max

class Solution {
    private lateinit var result: Array<IntArray>
    private fun printLCS(i:Int, s1: String,j:Int, s2: String): Int {
        if (i == 0 || j == 0) return 0
        if (result[i][j] != 0) return result[i][j]

        result[i][j] = if (s1[i-1] == s2[j-1]) {
            1 + printLCS(i-1,s1, j-1, s2)
        } else {
            max(printLCS(i-1, s1, j, s2), printLCS(i, s1, j-1, s2))
        }

        return result[i][j]
    }
    fun lcs(s1: String, s2: String) : String {

        //Memorization

//        result = Array(s1.length+1) { IntArray(s2.length+1) }
//        printLCS(s1.length, s1,s2.length, s2)
//        result.forEach {
//            println(it.toTypedArray().contentToString())
//        }

        //Extracting Common Characters from result Array | Way 1
//        var str1 = ""
//        for (i in result.size-1 downTo 1) {
//            for (j in result[i].size-1 downTo 1) {
//                if (s1[i-1] == s2[j-1]) {
//                    str1 += s1[i-1]
//                }
//            }
//        }
//        return str1

        //Extracting Common Characters from result Array | Way 2
//        var str2 = ""
//        var i = result.lastIndex
//        var j = result[i].lastIndex
//        while (i > 0 && j > 0) {
//            if (s1[i-1] == s2[j-1]) {
//                str2 += s1[i-1]
//                i--
//                j--
//            } else {
//                if (result[i-1][j] > result[i][j-1]) {
//                    i--
//                } else j--
//            }
//        }
//        return str2.reversed()

        //==========================================================================

        //Tabulation

        result = Array(s1.length+1) { IntArray(s2.length+1) }

        for (i in 1 .. s1.length) {
            for (j in 1 .. s2.length) {
                if (s1[i-1] == s2[j-1]) {
                    result[i][j] = 1 + result[i-1][j-1]
                } else {
                    result[i][j] = 0
                }
            }
        }

        result.forEach {
            println(it.toTypedArray().contentToString())
        }

        var str = ""
        var i = result.lastIndex
        var j = result.lastIndex

        while (i > 0 && j > 0) {
            if (s1[i-1] == s2[j-1]) {
                str += s1[i-1]
                i--
                j--
            } else {
                if (result[i-1][j] > result[i][j-1]) {
                    i--
                } else j--
            }
        }



        return str.reversed()
    }
}

fun main() {
    Solution().apply {
        println(lcs("axyzb","pxyzq"))
        println(lcs("abcdefgh","pefgtuvw"))
    }
}



[0, 0, 0, 0, 0, 0]
[0, 0, 0, 0, 0, 0]
[0, 0, 1, 0, 0, 0]
[0, 0, 0, 2, 0, 0]
[0, 0, 0, 0, 3, 0]
[0, 0, 0, 0, 0, 0]
xyz
[0, 0, 0, 0, 0, 0, 0, 0, 0]
[0, 0, 0, 0, 0, 0, 0, 0, 0]
[0, 0, 0, 0, 0, 0, 0, 0, 0]
[0, 0, 0, 0, 0, 0, 0, 0, 0]
[0, 0, 0, 0, 0, 0, 0, 0, 0]
[0, 0, 1, 0, 0, 0, 0, 0, 0]
[0, 0, 0, 2, 0, 0, 0, 0, 0]
[0, 0, 0, 0, 3, 0, 0, 0, 0]
[0, 0, 0, 0, 0, 0, 0, 0, 0]
efg
