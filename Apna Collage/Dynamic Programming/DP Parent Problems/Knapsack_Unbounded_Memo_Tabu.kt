class UnboundedKnapsack {

    private fun zeroOneKnapsackMemo(i:Int,bagCapacity: Int, weight: IntArray, prices: IntArray, dp: Array<IntArray>): Int {
        if (i == 0 || bagCapacity == 0) return 0
        if (dp[i][bagCapacity] != -1) return dp[i][bagCapacity]

        if (weight[i-1] <= bagCapacity) {
            
            //the value of i should not be increment in unbounded knapsack when include
            val include = zeroOneKnapsackMemo(i, bagCapacity-weight[i-1], weight, prices, dp) + prices[i-1]
            val exclude = zeroOneKnapsackMemo(i-1, bagCapacity, weight, prices, dp)
            
            dp[i][bagCapacity] = Math.max(include, exclude)
        } else {
            dp[i][bagCapacity] = zeroOneKnapsackMemo(i-1,bagCapacity, weight, prices, dp)
        }
        return dp[i][bagCapacity]
    }

    fun knapsackByMemorization(weight: IntArray, prices: IntArray, bagCapacity: Int): Int {
        val dp = Array(weight.size+1) { IntArray(bagCapacity+1) { -1 } }
        zeroOneKnapsackMemo(weight.size,bagCapacity, weight, prices, dp)
        return dp[weight.size][bagCapacity]
    }

    fun knapsackByTabulation(weight: IntArray, prices: IntArray, bagCapacity: Int): Int {
        val dp = Array(weight.size+1) { IntArray(bagCapacity+1) }

        for (i in 1 .. weight.size) {
            for (j in 1 .. bagCapacity) {
                if (weight[i-1] <= j) {
                    //the value of i should not be increment in unbounded knapsack when include
                    val include = dp[i][j-weight[i-1]] +  prices[i-1]
                    val exclude = dp[i-1][j]
                    dp[i][j] = Math.max(include, exclude)
                } else {
                    dp[i][j] = dp[i-1][j]
                }
            }
        }
        return dp[weight.size][bagCapacity]
    }
}

fun main() {
    UnboundedKnapsack().apply {
        val weight = intArrayOf(2,5,1,3,4)
        val prices = intArrayOf(15,14,10,45,30)
        val bagCapacity = 7

        println(knapsackByMemorization(weight = weight, prices = prices, bagCapacity = bagCapacity))   //100

        println(knapsackByTabulation(weight = weight, prices = prices, bagCapacity = bagCapacity))  //100
    }
}
