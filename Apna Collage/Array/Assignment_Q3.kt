//Leetcode : 121. Best Time to Buy and Sell Stock

class Solution {
    fun buySellStock(n:IntArray) {

        var buyPrice = n.first()
        var profit = 0

        for (index in 1..<n.size) {
            //buyPrice = Math.min(buyPrice, n[index])
            //profit = Math.max(profit, n[index] - buyPrice)
          
            buyPrice = buyPrice.coerceAtMost(n[index])
            profit = profit.coerceAtLeast(n[index] - buyPrice)
        }
        println("Max Profit: $profit")
    }
}
fun main() {
    Solution().apply {
        buySellStock(intArrayOf(7,1,5,3,6,4))
    }
}

