// https://www.geeksforgeeks.org/problems/shop-in-candy-store1145/1

class Solution {

    private fun getCost(candies: IntArray, k:Int): Int {
        var cost = 0
        val candy = candies.toMutableList()

        while (candy.isNotEmpty()) {
            cost += candy.removeFirst()
            repeat(k) {
                if (candy.isNotEmpty()) candy.removeLast()
            }
        }
        return cost
    }
    fun candyStore(candies: IntArray, n: Int, k: Int): IntArray {
        candies.sort()

        val minCost = getCost(candies,k)
        candies.sortDescending()

        val maxCost = getCost(candies,k)
        return intArrayOf(minCost, maxCost)
    }
}

fun main() {
    Solution().apply {
        println(candyStore(intArrayOf(3,2,1,4),4,2).toTypedArray().contentToString())
        println(candyStore(intArrayOf(3,2,1,4, 5),5,4).toTypedArray().contentToString())
    }
}
