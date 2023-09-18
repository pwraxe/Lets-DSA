//Binary Search on Ascending List by Template 1
class Solution {

    fun doBinSearch(nums: IntArray, target: Int): Int {
        var start = 0
        var end = nums.size-1

        while (start <= end) {
            val midIndex = start + (end - start) / 2
            when {
                nums[midIndex] > target -> end = midIndex - 1
                nums[midIndex] < target -> start = midIndex + 1
                nums[midIndex] == target -> return midIndex
            }
        }
        return -1
    }
}

fun main() {
    Solution().apply {
        println(doBinSearch(intArrayOf(1,2,3,4,5,6,7,8,9),4))   //3
        println(doBinSearch(intArrayOf(1,2,3,4,5,6,7,8,9),5))   //4
        println(doBinSearch(intArrayOf(1,2,3,4,5,6,7,8,9),6))   //5
    }
}
