/*
* VERY, VERY, VERY IMPORTANT
* catNum(firstNum) * catNum(lastNum)
* cat(i) * cat(n-1-i) <- i is very important in lastNum
* */

class CatalansNumber {

    //Recursively
    private fun catNumRec(n: Int): Int {
        if (n == 0 || n == 1) return 1
        var result = 0
        for (i in 0 ..< n) {
            result += catNumRec(i) * catNumRec(n-1-i)
        }
        return result
    }
    fun catalansNumbRec(n:Int): Int {
       return catNumRec(n)
    }

    //Memorization
    private fun catNumMemo(n:Int, dp: IntArray): Int {
        if (n == 0 || n == 1) return 1
        if (dp[n] != -1) return dp[n]
        var result = 0
        for (i in 0 ..< n) {
            result += catNumMemo(i, dp) * catNumMemo(n-1-i, dp)
        }
        dp[n] = result
        return dp[n]
    }
    fun catalansNumbMemo(n:Int): Int {
        val dp = IntArray(n+1) { -1 }
        return catNumMemo(n,dp)
    }

    fun catNumTab(n:Int): Int {
        val dp = IntArray(n+1) { if ( it==0 || it == 1) 1 else 0 }
        for (i in 2 .. n) {
            for (j in 0..< i) {
                dp[i] += dp[j] * dp[i-j-1] //dp[n-i-1]
            }

        }
        println(dp.toTypedArray().contentToString())
        return dp[n]
    }
}

fun main() {
    CatalansNumber().apply {
        val num = 5
        println(catalansNumbRec(num))
        println(catalansNumbMemo(num))
        println(catNumTab(num))

    }
}



//===========================OUTPUT===================
42
42
[1, 1, 2, 5, 14, 42]
42
