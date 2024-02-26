import kotlin.math.max
import kotlin.math.min

class Solution {

    private lateinit var nums: IntArray
    private lateinit var result: IntArray

    private fun robHouse(i: Int):Int {
        if (i == 0) return nums.first()
        if (i == 1) return max(nums[0], nums[1])
        if (result[i] != -1) return result[i]

        val yes = robHouse(i-2) + nums[i]
        val no = robHouse(i-1)
        result[i] = max(yes, no)
        return result[i]
    }
    fun rob(nums: IntArray): Int {
        this.nums = nums
        result = IntArray(nums.size+1) { -1 }
        return robHouse(nums.size-1)
    }

    //==============================================================
    fun minCostClimbingStairs(cost: IntArray): Int {
        if (cost.size == 2) {
            return min(cost.first(), cost.last())
        }
        for (i in 2 until cost.size) {
            cost[i] += min(cost[i-1],cost[i-2])
        }
        return min(cost.last(), cost[cost.lastIndex-1])
    }

    //==============================================================
    fun deleteAndEarn(nums: IntArray): Int {
        val result = IntArray(10001)
        nums.forEach { result[it] += it }
        for (i in 2 ..< result.size) {
            result[i] = max(result[i-1], result[i-2]+result[i])
        }
        return result[result.lastIndex]
    }

    //==============================================================
    private lateinit var multipliers: IntArray
    private lateinit var result1: Array<IntArray>

    private fun getMaxScore(i:Int, left:Int, m:Int): Int {
        if (i == m) return 0
        if (result1[i][left] != -1) return result1[i][left]

        val right = nums.lastIndex - (i - left)
        val score1 = getMaxScore(i+1,left+1,m) + multipliers[i] * nums[left]
        val score2 = getMaxScore(i+1, left,m) + multipliers[i] * nums[right]

        result1[i][left] = max(score1, score2)
        return result1[i][left]
    }
    fun maximumScore(nums: IntArray, multipliers: IntArray): Int {
        this.multipliers = multipliers
        this.nums = nums
        result1 = Array(multipliers.size) { IntArray(multipliers.size) { -1 } }
        return getMaxScore(0,0,multipliers.size)

    }

    //==============================================================
    private lateinit var text1: String
    private lateinit var text2: String

    private fun longestSubSeq(i:Int, j:Int): Int {
        if (i == text1.length || j == text2.length) return 0
        if (result1[i][j] != -1) return result1[i][j]

        result1[i][j] = if (text1[i] == text2[j]) {
            longestSubSeq(i+1,j+1) + 1
        } else {
            val l1 = longestSubSeq(i+1,j)
            val l2 = longestSubSeq(i,j+1)
            max(l1,l2)
        }

        return result1[i][j]
    }
    fun longestCommonSubsequence(text1: String, text2: String): Int {
        this.text1 = text1
        this.text2 = text2
        result1 = Array(text1.length+1) { IntArray(text2.length+1 ) { -1 } }

        return longestSubSeq(0,0)
    }

    //==============================================================
    private fun getMaxSquare(matrix: Array<CharArray>, r:Int, c:Int): Int {
        if (r == matrix.size || c == matrix[0].size) return 0
        if (result1[r][c] != -1) return result1[r][c]

        result1[r][c] = if (matrix[r][c] == '1') {
            1 + minOf(
                getMaxSquare(matrix,r+1,c),
                getMaxSquare(matrix, r, c+1),
                getMaxSquare(matrix, r+1, c+1))
        } else {
            0
        }
        return result1[r][c]
    }
    fun maximalSquare(matrix: Array<CharArray>): Int {
        result1 = Array(matrix.size+1) { IntArray(matrix[0].size+1 ) { -1 } }
        var maxArea = 0
        for (r in result1.indices) {
            result1[r][0] = matrix[r][0] - '0'
            if (matrix[r][0] == '1') maxArea = 1
        }

        for (c in 1 ..< result1[0].size-1) {
            result1[0][c] = matrix[0][c] - '0'
            if (matrix[0][c] == '1') maxArea = 1
        }

        return getMaxSquare(matrix,0,0)
    }

    //==============================================================
    fun coinChange(coins: IntArray, amount: Int): Int {
        result = IntArray(amount+1) { amount+1 }
        result[0] = 0

        for (i in 1 ..< result.size) {
            for (coin in coins) {
                if (i - coin < 0) continue
                result[i] = min(result[i], result[i-coin]+1)
            }
        }
        return if (result[amount] == amount+1) return -1 else result[amount]
    }

    //==============================================================
    private var set = hashSetOf<String>()
    private fun dp(s: String, wordDict: List<String>): Boolean {
        if (s.isEmpty()) return true
        if (set.contains(s)) return false

        for (word in wordDict) {
            if (s.startsWith(word)) {
                if (dp(s.substring(word.length), wordDict)) {
                    return true
                }
            }
        }
        return false
    }
    fun wordBreak(s: String, wordDict: List<String>): Boolean {
        return dp(s, wordDict)
    }

    //==============================================================
    fun lengthOfLIS(nums: IntArray): Int {
        result = IntArray(nums.size) { 1 }
        var longest = 0
        for (i in nums.indices) {
            for (j in 0 ..< i) {
                if (nums[j] < nums[i]) {
                    result[i] = max(result[i], result[j]+1)
                }
            }

            longest = max(longest, result[i])
        }

        return longest
    }

    //==============================================================
    private lateinit var prices: IntArray
    private lateinit var result4: Array<Array<IntArray>>

    private fun dp(i:Int, transactionRemain: Int, isHolding:Int): Int {
        if (i == prices.size || transactionRemain == 0) return 0
        if (result4[i][transactionRemain][isHolding] != -1) result4[i][transactionRemain][isHolding]

        val nothing = dp(i+1,transactionRemain, isHolding)
        val something = if (isHolding == 1) {
            //sell
            dp(i+1, transactionRemain-1, 0) + prices[i]
        } else {
            //Buy
            dp(i+1, transactionRemain, 1) - prices[i]
        }

        result4[i][transactionRemain][isHolding] = max(nothing, something)
        return result4[i][transactionRemain][isHolding]
    }
    fun maxProfit(k: Int, prices: IntArray): Int {
        this.prices = prices
        result4 = Array(prices.size+1) { Array(k+1) { IntArray(2)} }
        return dp(0,k,0)
    }
}

fun main() {

    Solution().apply {
        println(rob(intArrayOf(1,2,3,1)))
        println(rob(intArrayOf(2,7,9,3,1)))

        println("---------------------------------")
        println(minCostClimbingStairs(intArrayOf(10,15,20)))
        println(minCostClimbingStairs(intArrayOf(1,100,1,1,1,100,1,1,100,1)))

        println("---------------------------------")
        println(deleteAndEarn(intArrayOf(3,4,2)))
        println(deleteAndEarn(intArrayOf(2,2,3,3,3,4)))

        println("---------------------------------")
        println(maximumScore(intArrayOf(1,2,3), intArrayOf(3,2,1)))
        println(maximumScore(intArrayOf(-5,-3,-3,-2,7,1), intArrayOf(-10,-5,3,4,6)))

        println("---------------------------------")
        println(longestCommonSubsequence("abcde","ace"))
        println(longestCommonSubsequence("abc","abc"))
        println(longestCommonSubsequence("abc","def"))

        println("---------------------------------")
        println(coinChange(intArrayOf(1,2,5),11))
        println("---------------------------------")
        println(wordBreak("leetcode", listOf("leet","code")))
        println(wordBreak("catsandog", listOf("cats","dog","sand","and","cat")))

        println("---------------------------------")
        println(lengthOfLIS(intArrayOf(10,9,2,5,3,7,101,18)))
        println("---------------------------------")
        println(maxProfit(2,intArrayOf(2,4,1)))
        println(maxProfit(2,intArrayOf(3,2,6,5,0,3)))

    }
}




4
12
---------------------------------
15
6
---------------------------------
6
9
---------------------------------
14
102
---------------------------------
3
3
0
---------------------------------
3
---------------------------------
true
false
---------------------------------
4
---------------------------------
2
7
