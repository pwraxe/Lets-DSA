//Binary Search Template-2, DESC Order
class Solution {

    fun doBinSearch(nums: IntArray, target: Int): Int {
        if(nums.size == 0 || nums.isEmpty()) return -1
        var start = 0
        var end = nums.size-1

        loop@
        while (start < end) {
            val midIndex = start + (end - start) / 2
              
            when {
                nums[midIndex] == target -> return midIndex
                nums[midIndex] > target -> start = midIndex + 1
                else -> end = midIndex
            }
        }

        //Why this line is extra?
        //As you can see at loop@while(...) , condition is (start < end) it's not (start <= end)
        if (nums[start] == target) return start
        return -1
    }
}

fun main(){
    Solution().apply {
        println(doBinSearch(intArrayOf(9,8,7,6,5,4,3,2,1,0),4))
        println(doBinSearch(intArrayOf(9,8,7,6,5,4,3,2,1,0),5))
        println(doBinSearch(intArrayOf(9,8,7,6,5,4,3,2,1,0),6))
    }
}
