//Problem: Take List, group k unique combinations of target
class Solution {

    private fun getKSubSets(nums: IntArray, index: Int, target: Int, subList: MutableList<Int>, list: MutableList<List<Int>>) {
        if(index == nums.size) return
        if(subList.sum() == target) {
            list.add(subList.toList())
            return
        }

        if(subList.sum() > target) return

        for (i in index until nums.size) {
            subList.add(nums[i])
            getKSubSets(nums, i, target, subList, list)
            subList.removeLast()
        }
    }

    fun kCombinations(nums: IntArray, target: Int) : List<List<Int> >{
        val list = mutableListOf<List<Int>>()
        getKSubSets(nums,0, target, mutableListOf(), list)
        return list.toList()
    }
}

fun main() {
    Solution().apply {
        kCombinations(intArrayOf(2,3,5), 8).forEach {
            println("${it.size} = ${it.toTypedArray().contentToString()}")
        }
    }
}
