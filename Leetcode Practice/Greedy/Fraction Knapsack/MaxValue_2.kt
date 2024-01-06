//Conceptual
//Get Max Profit By Min Weight
class Solution {
    fun getMaxProfit(value:IntArray, weight:IntArray, bagCap: Int): Double {
        val pair = mutableListOf<IntArray>()
        value.indices.forEach {
            pair.add(intArrayOf(value[it], weight[it]))
        }

        //Change this line from descending to ascending
        pair.sortBy { it.last() }

        var remainingWeight = bagCap
        var maxProfit = 0.0
        var index = 0
        while (remainingWeight >= 0) {
            if (remainingWeight >= pair[index].last()) {
                remainingWeight -= pair[index].last()
                maxProfit += pair[index].first()
                index++
            } else {
                maxProfit += (pair[index].first() * remainingWeight.toDouble()).div(pair[index].last().toDouble())
                break
            }
        }
        return maxProfit
    }
}
fun main() {
    Solution().apply {
        val profit = getMaxProfit(intArrayOf(60,100,120), intArrayOf(10,20,30), 50)
        println(profit) //Expected: 220.0
    }
}
