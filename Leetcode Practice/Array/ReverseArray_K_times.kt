//Leetcode: Rotate Array
//TC: O(n*n), loopinh end of list, and inner loop to shift elements
//SC: (1)


class Solution {
    fun rotate(nums: IntArray, k: Int): Unit {
        
        val index = 0
        repeat(k % nums.size) {
            
            var lastIndex = nums.size - 1
            val temp = nums[lastIndex]
            
            while(lastIndex > index) {
                nums[lastIndex] = nums[lastIndex-1]
                lastIndex--
            }
            
            nums[0] = temp
        }
    }
}
