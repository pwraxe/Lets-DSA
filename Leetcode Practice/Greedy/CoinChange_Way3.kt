//Way1, 2, 3 are onlt concept oriented
class Solution {

    fun coinChange(amount: Int, coins: IntArray) {
        var sum = 0
        var index = 0
        val result = mutableListOf<Int>()

        while (sum < amount) {
            if (sum + coins[index] <= amount) {
                sum += coins[index]
                result.add(coins[index])
            } else {
                index++
            }
        }
        println(result.toTypedArray().contentToString())
    }
}

fun main() {
    Solution().apply {
        coinChange(51, intArrayOf(10,5,2,1))
    }
}
