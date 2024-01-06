//Conceptual
//Based on Min Weight
class Solution {
    fun maxProfit(profit: IntArray, weight: IntArray, bagCapacity:Int): Double {
        val pairs = mutableListOf<Pair<Int,Int>>()
        profit.indices.forEach {
            pairs.add(Pair(profit[it], weight[it]))
        }
        pairs.sortBy { it.second }
        var remainingWeight = bagCapacity
        var maxProfit = 0.0
        var index = 0
        while (remainingWeight >= 0) {
            val pair = pairs[index]
            if (remainingWeight >= pair.second) {
                remainingWeight -= pair.second
                maxProfit += pair.first
                index++
            } else {
                maxProfit += (pair.first * remainingWeight.toDouble()) / pair.second.toDouble()
                break
            }
        }
        return maxProfit
    }
}
fun main() {
    Solution().apply {
        val profit = maxProfit(
            profit = intArrayOf(10,30,8,2,14,18),
            weight = intArrayOf(5,3,10,6,8,7),
            bagCapacity = 30)

        println(profit)
        //Expected : 74.8
    }
}
