class Solution {
    fun removeDuplicates(nums: IntArray): Int {
        
        var k = 0
        for(i in 0 until nums.size) {
            if(nums[k] != nums[i]) {
                k++
                nums[k] = nums[i]
            }
        }
        return k+1
    }
}
