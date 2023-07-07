class Solution {
    fun removeElement(nums: IntArray, `val`: Int): Int {
        //Return total elemtns in nums
        
        var k = 0
        for(index in 0 until nums.size) {
            if(nums[index] != `val`) {
                nums[k] = nums[index]
                k++
            }
        }
        return k
    }
}
