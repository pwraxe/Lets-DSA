//Sorted, Rotated Binary Array, || Leetcode: 33. Search in Rotated Sorted Array

class Solution {
    fun search(nums: IntArray, target: Int): Int {
        var start = 0
        var end = nums.size-1
        while (start < end) {
            val midIndex = (end + start) / 2
            if (nums[midIndex] == target) {
                return midIndex
            }

            if (nums[start] <= nums[midIndex]) {
                if (target in nums[start]..nums[midIndex]) {
                    end = midIndex - 1
                } else {
                    start = midIndex + 1
                }
            } else if(nums[midIndex] <= nums[end]) {
                if (target in nums[midIndex] .. nums[end]) {
                    start = midIndex + 1
                } else {
                    end = midIndex - 1
                }
            }
        }

        return if (nums[start] == target) start else -1
    }
}

fun main() {
    Solution().apply {
        val list = intArrayOf(1)
        println(search(list, 0))
    }
}
