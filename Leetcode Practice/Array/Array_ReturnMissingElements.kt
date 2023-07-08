//LeetCode:   Squares of a Sorted Array
//TC: O(n)
//SC: O(n)

//Note: This problem can be solved without using extra space, take a time and rerun again
//Row Concept : Alt Sol --> could be: update value to negative, and return those updated index who have positive values
class Solution {
    fun findDisappearedNumbers(nums: IntArray): List<Int> {
        nums.sort()

        println(nums.toTypedArray().contentToString())

        val list = mutableListOf<Int>()
        var count = 1

        nums.forEach {
            if(!nums.contains(count)) {
                list.add(count)
            }

            count++
        }
        return list
    }
}
