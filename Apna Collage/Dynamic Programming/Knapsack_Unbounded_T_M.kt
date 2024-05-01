class Knapsack {

    private fun makeChange(i: Int, sum:Int, coins: IntArray, dp:Array<IntArray>) : Int {
        if (i == 0 && sum > 0) return 0
        if (i >= 0 && sum == 0) return 1
        if (dp[i][sum] != -1) return dp[i][sum]

        dp[i][sum] = if (coins[i-1] <= sum) {
            val include = makeChange(i,sum-coins[i-1], coins, dp)
            val exclude = makeChange(i-1,sum, coins, dp)
            include + exclude
        } else {
            makeChange(i-1,sum, coins, dp)
        }
        return dp[i][sum]
    }
    fun coinChange(coins: IntArray, sum: Int): Int {
        val dp = Array(coins.size+1) { IntArray(sum+1) { -1 } }
        makeChange(coins.size,sum,coins, dp)

//        val dp = Array(coins.size+1) { IntArray(sum+1) { if(it == 0) 1 else 0 } }
//        for (i in 1 .. coins.size) {
//            for (j in 1 .. sum) {
//                if (coins[i-1] <= j) {
//                    dp[i][j] = dp[i][j-coins[i-1]] + dp[i-1][j]
//                } else {
//                    dp[i][j] = dp[i-1][j]
//                }
//            }
//        }

        dp.forEach {
            println(it.toTypedArray().contentToString())
        }
        return dp[coins.size][sum]
    }
}

fun main() {
    Knapsack().apply {
        println(coinChange(intArrayOf(2,5,3,6),10))
    }
}




[-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1]
[-1, 0, 1, 0, 1, 0, 1, 0, 1, -1, 1]
[-1, 0, 1, -1, 1, 1, -1, 1, -1, -1, 2]
[-1, 0, -1, -1, 1, -1, -1, 2, -1, -1, 4]
[-1, -1, -1, -1, 1, -1, -1, -1, -1, -1, 5]
5
