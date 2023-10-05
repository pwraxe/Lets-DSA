//Problem: Take List, group k combinations of target
class Solution {

    private fun getKSubSets(nums: IntArray, index: Int, k:Int, target: Int, subList: MutableList<Int>, list: MutableList<List<Int>>) {

        if(index == nums.size) return
        if(subList.size == k && subList.sum() == target) {
            list.add(subList.toList())
            return
        }
        
        //This makes 10 combinations from [1,2]..[4,5]
        subList.add(nums[index])
        getKSubSets(nums, index+1, k, target,subList, list)
        subList.removeLast()
        getKSubSets(nums, index+1, k, target,subList, list)
    }

    fun kCombinations(nums: IntArray, k:Int, target: Int) : List<List<Int> >{
        val list = mutableListOf<List<Int>>()
        getKSubSets(nums,0, k, target, mutableListOf(), list)
        return list.toList()
    }
}

fun main() {
    Solution().apply {
        kCombinations(intArrayOf(1,2,3,4,5,6),3, 10).forEach {
            println("${it.size} = ${it.toTypedArray().contentToString()}")
        }
    }
}


