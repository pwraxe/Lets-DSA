class Solution {
    fun maxProfit(profit: IntArray, weight: IntArray, bagCapacity:Int): Double {
        val triplet = mutableListOf<DoubleArray>()
        profit.indices.forEach {
            val prof = profit[it].toDouble()
            val wt = weight[it].toDouble()
            triplet.add(doubleArrayOf(prof, wt, prof.div(wt)))
        }
        triplet.sortByDescending { it[2] }

        var remainingWeight = bagCapacity.toDouble()
        var maxProfit = 0.0
        var index = 0

        while (remainingWeight >= 0) {
            if (remainingWeight >= triplet[index][1]) {
                remainingWeight -= triplet[index][1]
                maxProfit += triplet[index][0]
                index++
            } else {
                maxProfit += remainingWeight * triplet[index][2]
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
        //Expected : 77.6
    }
}
