/**
 * Topic: Array
 * Leetcode Problem 169: Majority of Element
 * Level: Easy
 * TimeComplexity: O(n)
 *
 * **/


class Solution {
    fun majorityElement(nums: IntArray): Int {
        val hashMap = hashMapOf<Int, Int>()
        nums.forEach {
            var value = hashMap[it] ?: 0
            hashMap[it] = ++value

            if(value > nums.size/2) { return it }
        }
        return -1
    }
}

fun main() {

    val list1 = intArrayOf(0,3,7,2,5,8,4,6,0,1) //9
    val list2 = intArrayOf(1,2,3,6,7,8,9,10,11,12,13,14) //9
    val list3 = intArrayOf(3,2,3)
    val result = Solution().majorityElement(list3)
    println("Majority element : $result")
}
