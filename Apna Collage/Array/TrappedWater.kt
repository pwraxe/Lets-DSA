class Solution {
    fun trappedWater(n:IntArray) {
        val leftMax = IntArray(n.size)
        val rightMax = IntArray(n.size)

        leftMax[0] = n[0]
        for (index in 1 until n.size) {
            leftMax[index] = Math.max(leftMax[index-1], n[index])
        }

        rightMax[n.lastIndex] = n.last()
        for (index in n.size-2 downTo 0) {
            rightMax[index] = Math.max(rightMax[index+1], n[index])
        }

        var trapped = 0
        for (index in n.indices) {
            trapped += Math.min(leftMax[index], rightMax[index]) - n[index]
        }
        println("Trapped: $trapped")
    }
}

fun main() {
    Solution().apply {
        trappedWater(intArrayOf(4,2,0,6,3,2,5) )
    }
}
