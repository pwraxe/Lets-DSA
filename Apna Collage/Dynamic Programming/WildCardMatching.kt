class DP {
    
    fun wildCardMatching(s: String, p: String): Boolean {
        val dp = Array(s.length+1) { BooleanArray(p.length+1) }
        dp[0][0] = true

        for (j in 1 .. p.length) {
            if (p[j-1] == '*') dp[0][j] = dp[0][j-1]
        }

        for (i in 1 .. s.length) {
            for (j in 1 .. p.length) {

                //is char same || is pattern char is `?`
                if (s[i-1] == p[j-1] || p[j-1] == '?') {
                    dp[i][j] = dp[i-1][j-1]
                }
                else if(p[j-1] == '*') {
                    //Take || not take
                    dp[i][j] = dp[i][j-1] || dp[i-1][j]
                }
                else {
                    dp[i][j] = false
                }
            }
        }
        return dp[s.length][p.length]
    }
}

fun main() {
    DP().apply { 
       println(wildCardMatching("baaabab","*****ba*****ab"))   //true
    }
}
