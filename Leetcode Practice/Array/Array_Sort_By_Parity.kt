//Leetcoe: Sort Array by odd followed by even nos
//TC: O(n), bcoz used loop once
//SC: O(1), bcoz, no extra space used, (in-place Operation)

class Solution {
    fun sortArrayByParity(nums: IntArray): IntArray {
        
        if(nums.size == 0) return nums
        
        var left = 0
        var right = nums.size-1
        
        while(left < right) {
            //I want left Odd and Right Even
            if(nums[left]%2==1 && nums[right] %2 == 0) {
                nums[left] = nums[right].also { nums[right] = nums[left] }
            }
            if(nums[left]%2 == 0) left++
            if(nums[right]%2 == 1) right--
        }
        
        return nums
    }
}

//===========================================================================================================================


//Leetcoe: Sort Array by odd followed by even nos
//TC: O(n2), bcoz used loop twice
//SC: O(1), bcoz, no extra space used, (in-place Operation)
class Solution {
    fun sortArrayByParity(nums: IntArray): IntArray {
        
        var i = 0
        if(nums.size == 0) return nums
        
        while(i < nums.size) {
            var j = i
            while(j < nums.size) {
                if(nums[j]%2 == 0) {
                    nums[i] = nums[j].also { nums[j] = nums[i] }
                    i++
                }
                j++
            }
            i++
        }
        return nums
    }
}
