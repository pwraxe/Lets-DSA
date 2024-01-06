//Conceptual
//Get Max Profit By value/weight
//Considering max value by per kilo
class Solution {
    fun getMaxProfit(value:IntArray, weight:IntArray, bagCap: Int): Double {
        val pair = mutableListOf<DoubleArray>()
        value.indices.forEach {
            val v = value[it].toDouble()
            val w = weight[it].toDouble()
            pair.add(doubleArrayOf(v,w, v.div(w)))
        }

        //Change this line from descending to ascending
        pair.sortByDescending { it.last() }
        
        var remainingWeight = bagCap.toDouble()
        var maxProfit = 0.0
        var index = 0
        while (remainingWeight >= 0) {
            if (remainingWeight >= pair[index][1]) {
                remainingWeight -= pair[index][1]
                maxProfit += pair[index].first()
                index++
            } else {
                maxProfit += (pair[index].first() * remainingWeight).div(pair[index][1])
                break
            }
        }
        return maxProfit
    }
}
fun main() {
    Solution().apply {
        val profit = getMaxProfit(intArrayOf(60,100,120), intArrayOf(10,20,30), 50)
        println(profit) //Expected: 240.0
    }
}
