class Solution {
    private fun checkDuplicates(list: IntArray, index: Int): Boolean {
        if(index == list.size) return false

        val temp = list[index]
        list[index] = -1
        if(list.contains(temp)) return true
        list[index] = temp

        return checkDuplicates(list, index+1)
    }
    fun findDuplicate(list: IntArray): Boolean {
        return checkDuplicates(list,0)
    }
}

fun main() {
    Solution().apply {
        println(findDuplicate(intArrayOf(1,1,2,3,4,5,6)))
    }
}
