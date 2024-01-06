class Solution {
    fun minAbsDiff(first: IntArray, second: IntArray): Int {
        first.sort()
        second.sort()
        var diff = 0
        first.indices.forEach {
            diff += Math.abs(first[it] - second[it])
        }
        return diff
    }
}
fun main() {
    Solution().apply {
        println(minAbsDiff(intArrayOf(1,2,3), intArrayOf(2,1,3))) // 0
        println(minAbsDiff(intArrayOf(4,1,8,7), intArrayOf(2,3,6,5))) // 6

    }
}
