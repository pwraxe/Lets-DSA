//Leetcode: 42. Trapping Rain Water | HARD

class Solution {
    fun trappedWater(n:IntArray): Int {
        val leftMax = IntArray(n.size)
        val rightMax = IntArray(n.size)
        leftMax[0] = n.first()
        for (index in 1 until n.size) {
            leftMax[index] = Math.max(leftMax[index-1], n[index])
        }

        rightMax[n.size-1] = n.last()
        for (index in n.size-2 downTo 0) {
            rightMax[index] = Math.max(rightMax[index+1], n[index])
        }

        var trapped = 0
        for (index in 0 ..< n.size-1) {
            trapped += Math.min(leftMax[index], rightMax[index]) - n[index]
        }
        return trapped
    }
}

fun main() {
    Solution().apply {
        println(trappedWater(intArrayOf(0, 1, 0,  2, 1, 0, 1, 3, 2, 1, 2, 1)))
        println(trappedWater(intArrayOf(4, 2, 0, 3, 2, 5)))
    }
}
