import kotlin.math.max

class Solution {
    private lateinit var result: Array<IntArray>

    private fun lcs(i: Int, s1: String, j: Int, s2: String): Int {
        if (i == 0 || j == 0) return 0
        if (result[i][j] != 0) return result[i][j]

        result[i][j] = if (s1[i-1] == s2[j-1]) {
            1 + lcs(i-1, s1, j-1, s2)
        } else {
            max(lcs(i-1, s1, j, s2), lcs(i, s1, j-1, s2))
        }

        return result[i][j]
    }
    fun minNoOfInsertionDeletion(s1: String, s2: String) {
        result = Array(s1.length+1) { IntArray(s2.length+1) }
        val lcs = lcs(s1.length,s1, s2.length, s2)
        val insertion = Math.abs(s1.length - lcs)
        val deletion = Math.abs(s2.length-lcs)
        println("Insertion: $insertion | Deletion: $deletion")
    }
}

fun main() {
    Solution().apply {
        minNoOfInsertionDeletion("heap","pea")
    }
}


//Insertion: 2 | Deletion: 1
