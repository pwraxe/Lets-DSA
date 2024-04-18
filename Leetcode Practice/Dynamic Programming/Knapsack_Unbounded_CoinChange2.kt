//https://leetcode.com/problems/coin-change-ii/description/

class Knapsack {

    private lateinit var result: Array<IntArray>
    private fun getTotalWays(index: Int, nums: IntArray, target: Int): Int {

        if (index >= 0 && target == 0) return 1
        if (index == 0 && target > 0) return 0

        if (result[index][target] != -1) return result[index][target]

        if (nums[index-1] <= target) {
            val take = getTotalWays(index, nums, target-nums[index-1])
            val not = getTotalWays(index-1, nums, target)
            result[index][target] = take + not
        } else {
            result[index][target] = getTotalWays(index-1, nums, target)
        }
        return result[index][target]
    }
    fun change(coins:IntArray, amount:Int) : Int {
        result = Array(coins.size+1) { IntArray(amount+1) { -1 } }
        return getTotalWays(coins.size,coins,amount)

        result = Array(coins.size+1) { IntArray(amount+1) }
        //Initialization
        for (r in 0 .. coins.size) {
            result[r][0] = 1
        }

        for (r in 1 .. coins.size) {
            for (c in 1 .. amount) {
                val take = if (c-coins[r-1] >= 0) result[r][c-coins[r-1]] else 0
                result[r][c] = take  + (result[r-1][c])
            }
        }
        return result[coins.size][amount]
    }
}

fun main() {

    Knapsack().apply {
        println(change(intArrayOf(2,3,5,6,8,10),10)) //7
        println(change(intArrayOf(1,2,5),5))   //4
        println(change(intArrayOf(7),0))  //1
    }
}
