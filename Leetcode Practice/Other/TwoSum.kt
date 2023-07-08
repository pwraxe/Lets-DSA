//Leetcode : Two sum
//TC: O(n) , bcoz, nums loop goes end of list
//SC : O(n), bcoz, took extra memory for map 
//Most cases, SC can be O(1), as we found same element in map we replace it with index, ...
class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val map = mutableMapOf<Int, Int>()
        nums.forEachIndexed { index, item -> 
            map[item]?.let { return intArrayOf(it, index)}
            map[target-item] = index
        }
        return intArrayOf()
    }
}

//-------------------------------------------------------------------------

//Leetcode : Two Sum
//TC: O(n2)   bcoz, you used while twice
//SC : O(1) , bcoz, no extra memory taken
//STILL NOT MUCH RECOMMENDED
class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        
        var index = 0
        while(index < nums.size-1) {
            var j = nums.size-1
            while(j > index) {
                val sum = nums[index] + nums[j]
                if(sum == target) {
                    return intArrayOf(index, j)
                }
                j--
            }
            index++
        }
        return intArrayOf()
    }
}
