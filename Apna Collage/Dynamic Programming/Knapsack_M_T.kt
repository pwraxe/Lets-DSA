class Knapsack {

    private fun getMaxProfit(index: Int, value: IntArray, weight: IntArray, capacity: Int, dp: Array<IntArray>): Int {
        if (index == weight.size || capacity == 0) return 0
        if (dp[index][capacity] != -1) return dp[index][capacity]

        dp[index][capacity] = if (weight[index] <= capacity) {
            //Include
            val include = getMaxProfit(index+1, value, weight, capacity-weight[index],dp) + value[index]

            //Exclude
            val exclude = getMaxProfit(index+1, value, weight, capacity,dp)

            Math.max(include, exclude)
        } else {
            getMaxProfit(index+1, value, weight, capacity,dp)
        }

        return dp[index][capacity]
    }
    fun maxProfit(value: IntArray, weight: IntArray, capacity: Int) {
//        val dp = Array(weight.size+1) { IntArray(capacity+1) { -1 } }
//        println(getMaxProfit(0,value, weight, capacity, dp))

        val dp = Array(weight.size+1) { IntArray(capacity+1) }
        for (i in 1 .. weight.size) {
            for (j in 1 .. capacity) {
                if (weight[i-1] <= j) {
                    val include = value[i-1] + dp[i-1][j-weight[i-1]]
                    val exclude = dp[i-1][j]
                    dp[i][j] = Math.max(include, exclude)
                }
            }
        }
        dp.forEach {
            println(it.toTypedArray().contentToString())
        }
        println(dp[weight.size][capacity])
    }
}
fun main() {
    Knapsack().apply {
        maxProfit(
            value = intArrayOf(15,14,10,45,30),
            weight = intArrayOf(2,5,1,3,4),
            capacity = 7
        )
    }
}



[0, 0, 0, 0, 0, 0, 0, 0]
[0, 0, 15, 15, 15, 15, 15, 15]
[0, 0, 0, 0, 0, 15, 15, 29]
[0, 10, 10, 10, 10, 15, 25, 29]
[0, 0, 0, 45, 55, 55, 55, 55]
[0, 0, 0, 0, 55, 55, 55, 75]
75
