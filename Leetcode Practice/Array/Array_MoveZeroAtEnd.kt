//Leetcode : Move Zero
//TC: O(n2) , used while twice
//SC : O(1), no extra memory used, in-place operation
class Solution {
    fun moveZeroes(nums: IntArray): Unit {
        
        var last = nums.size - 1
        var index = 0
        
        if(nums.size == 0) return
        
        while(index < last) {
            if(nums[index] == 0) {
                //var temp = nums[index]
                //shift left
                var j = index
                while(j < last) {
                    nums[j] = nums[j+1]
                    j++
                }
                nums[last] = 0
                last--
            }
            
            if(nums[index] != 0) index++
        }
    }
}
