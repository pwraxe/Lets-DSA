class Knapsack {

    private fun maxProfit(index:Int, rodLength: Int, length: IntArray,prices: IntArray, dp:Array<IntArray>): Int {
        if (index == 0 || rodLength == 0) return 0
        if (dp[index][rodLength] != -1) return dp[index][rodLength]

        dp[index][rodLength] = if (length[index-1] <= rodLength) {
            val include = maxProfit(index, rodLength-length[index-1], length, prices, dp) + prices[index-1]
            val exclude = maxProfit(index-1,rodLength, length, prices, dp)
            Math.max(include, exclude)
        } else {
            maxProfit(index-1,rodLength, length, prices, dp)
        }
        return dp[index][rodLength]
    }
    fun rodCutting(length: IntArray, prices: IntArray, rodLength: Int): Int {
        //val dp = Array(prices.size+1) { IntArray(rodLength+1) { -1 } }
        //maxProfit(length.size,rodLength, length, prices, dp)
        //return dp[length.size][rodLength]

        val dp = Array(prices.size+1) { IntArray(rodLength+1) }
        for (i in 1 .. prices.size) {
            for (j in 1 .. rodLength) {
                if (length[i-1] <= j) {
                    dp[i][j] = Math.max(dp[i][j-length[i-1]]+prices[i-1], dp[i-1][j])
                } else {
                    dp[i][j] = dp[i-1][j]
                }
            }
        }
        return dp[prices.size][rodLength]
    }
}

fun main() {
    Knapsack().apply {
        //22
        println(rodCutting(IntArray(8) { it+1 }, intArrayOf(1,5,8,9,10,17,17,20),8))
    }
}
