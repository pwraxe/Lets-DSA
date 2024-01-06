class Solution {
    fun indianCoinChange(coins: IntArray, amt: Int): Int {
        coins.sortDescending()
        val result = mutableListOf<Int>()
        var amount = amt
        var index = 0
        while (amount > 0) {
            if (amount - coins[index] >= 0) {
                amount -= coins[index]
                result.add(coins[index])
            } else {
                index++
            }
        }
        println(result.toTypedArray().contentToString())
        return result.size
    }
}
fun main() {
    Solution().apply {
        val coins = intArrayOf(1,2,5,10,20,50,100,500,2000)
        println(indianCoinChange(coins,121))
        println(indianCoinChange(coins,590))
    }
}

// [100, 20, 1]
// 3
// [500, 50, 20, 20]
// 4

//=============================================================================================
//if we consider coins array is already sorted in asc order then we will remove sort method which takes O(logN) TC
class Solution {
    fun indianCoinChange(coins: IntArray, amt: Int): Int {

        val result = mutableListOf<Int>()
        var amount = amt
        var index = coins.lastIndex
        while (amount > 0) {
            if (amount - coins[index] >= 0) {
                amount -= coins[index]
                result.add(coins[index])
            } else {
                index--
            }
        }
        println(result.toTypedArray().contentToString())
        return result.size
    }
}
fun main() {
    Solution().apply {
        val coins = intArrayOf(1,2,5,10,20,50,100,500,2000)
        println(indianCoinChange(coins,121))
        println(indianCoinChange(coins,590))
    }
}

