//Problem: Take List, group k combinations
class Solution {

    private fun getKSubSets(nums: IntArray, index: Int, k:Int, subList: MutableList<Int>, list: MutableList<List<Int>>) {

        if(index == nums.size) return
        if(subList.size == k) {
            list.add(subList.toList())
            return
        }

        //This makes 21 combinations from [1,1]..[6,6]
        for (i in index until nums.size) {
            subList.add(nums[i])
            getKSubSets(nums, i, k, subList, list)
            subList.removeLast()
        }

        //This makes 10 combinations from [1,2]..[4,5]
//        subList.add(nums[index])
//        getKSubSets(nums, index+1, k, subList, list)
//        subList.removeLast()
//        getKSubSets(nums, index+1, k, subList, list)
    }

    fun kCombinations(nums: IntArray, k:Int) : List<List<Int> >{
        val list = mutableListOf<List<Int>>()
        getKSubSets(nums,0,k, mutableListOf(),list)
        return list.toList()
    }
}

fun main() {
    Solution().apply {
        kCombinations(intArrayOf(1,2,3,4,5,6),2).forEach {
            println("${it.size} = ${it.toTypedArray().contentToString()}")
        }
    }
}

//Problem: Take List, group k combinations of target
