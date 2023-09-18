//Binary Search Template-2
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
                nums[midIndex] < target -> start = midIndex + 1
                else -> end = midIndex
            }
        }

        //Why this line is extra?
        //As you can see at loop@while(...) , condition is (start < end) its not (start <= end) 
        if (nums[start] == target) return start
        return -1
    }
}

fun main(){
    Solution().apply {
        println(doBinSearch(intArrayOf(1,2,3,4,5,6,7,8,9),4))   //3
        println(doBinSearch(intArrayOf(1,2,3,4,5,6,7,8,9),5))   //4
        println(doBinSearch(intArrayOf(1,2,3,4,5,6,7,8,9),6))   //5
    }
}
