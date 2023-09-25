class Solution {
    fun countingSort(nums: IntArray): IntArray {

        val max = nums.max()
        val counts = IntArray(max+1)
        for(n in nums) {
            counts[n] += 1
        }

        for(index in 1 until counts.size-1) {
            counts[index] += counts[index-1]
        }

        val sorted = IntArray(nums.size) { 0 }
        for(item in nums) {
            sorted[counts[item]] = item
            counts[item] += 1
        }

        return sorted
    }
}

fun main() {
    Solution().apply {
        println(countingSort(intArrayOf(5,4,5,5,1,1,3)).toTypedArray().contentToString())
    }
}
