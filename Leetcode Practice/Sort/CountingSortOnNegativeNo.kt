class Solution {
    fun countingSort(nums: IntArray): IntArray {

        val min = nums.min()
        val max = nums.max() - min
        
        val counts = IntArray(max+1)
        for(n in nums) {
            counts[n-min] += 1
        }

        for(index in 1 until max) {
            counts[index] += counts[index-1]
        }

        println(counts.contentToString())

        val sorted = IntArray(nums.size) { 0 }
        for(item in nums) {
            sorted[counts[item-min]] = item
            counts[item-min] += 1
        }

        return sorted
    }
}

fun main() {
    Solution().apply {
        println(countingSort(intArrayOf(-5,4,5,5,-1,1,3,-3)).toTypedArray().contentToString())
    }
}
