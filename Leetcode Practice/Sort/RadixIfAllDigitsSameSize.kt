/**
NOTE: 
NOTE:
NOTE:

For FIX LENGTH digits
Akshay, when you have "fix length" numbers in list, then you can directly sort by first digit (i.e. 100th place/position)
it reduces O(n)-1 time iteration

Ex. your list has 10 numbers ranging from  100..999 then the first digit is at 100 place (1 or 9)
so you can sort by the first digit of the number 
total iteration : 3 (becoz 3 digit numver)
you iterate by the first digit and exclude the remaining 2-digit iteration
**/
class Solution {
    private val PLACE_VALUE = 100
    private fun countingSort(nums: IntArray): IntArray {
        val counts = IntArray(10)

        for(n in nums) {
            val digit =(n / PLACE_VALUE) % 10
            counts[digit] += 1
        }

        for(index in 1 until counts.size) {
            counts[index] += counts[index-1]
        }


        val sorted = IntArray(nums.size) { 0 }
        for(index in nums.size-1 downTo 1) {
            val digit =(nums[index] / PLACE_VALUE) % 10
            sorted[counts[digit]-1] = nums[index]
            counts[digit] --
        }

        return sorted
    }

    fun radix(nums: IntArray) {
        var result = nums
        result = countingSort(result)
        
        println(result.toTypedArray().contentToString())
    }
}

fun main() {
    Solution().apply {
        radix(intArrayOf(100,574,325,987,147,102,564))
    }
}
