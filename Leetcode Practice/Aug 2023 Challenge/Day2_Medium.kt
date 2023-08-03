//Leetcode: 46. Permutations

class Solution {

    private val result = mutableListOf<List<Int>>()

    private fun doCombinations(nums: IntArray, subList: List<Int>, 
        map: HashMap<Int, Boolean>) {
        if(subList.size == nums.size) {
            result.add(subList)
            return
        }

        nums.forEach {
            if(map[it] != true) {
                map[it] = true
                doCombinations(nums, subList+it, map)
                map[it] = false
            }
        }
    }
    fun permute(nums: IntArray): List<List<Int>> {
        doCombinations(nums, emptyList(), hashMapOf<Int, Boolean>())
        return result
    }
}
