//Conceptual
//Based on Getting Max Profit

class Solution {
    fun maxProfit(profit: IntArray, weight: IntArray, bagCapacity:Int): Double {
        val pairs = mutableListOf<Pair<Int,Int>>()
        (0 until profit.size).forEach {
            pairs.add(Pair(profit[it],weight[it]))
        }

        pairs.sortByDescending { it.first }

        var remainingWeight = bagCapacity
        var maxProfitSum = 0.0
        var index = 0
        while (remainingWeight >= 0) {
            val profWeight = pairs[index]
            if (remainingWeight >= profWeight.second) {
                remainingWeight -= profWeight.second
                maxProfitSum += profWeight.first
                index++
            } else {
                //make remaining weight 0
                maxProfitSum += (profWeight.first.toDouble() * remainingWeight.toDouble()) / profWeight.second.toDouble()
                break
            }
        }

        return maxProfitSum
    }
}
fun main() {
    Solution().apply {
        val profit = maxProfit(
            profit = intArrayOf(10,30,8,2,14,18),
            weight = intArrayOf(5,3,10,6,8,7),
            bagCapacity = 30)

        println(profit)
    }
}
