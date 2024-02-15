class Solution {

    fun pairSum1(list: IntArray, target: Int): Boolean {
        for (i in list.indices) {
            for (j in i+1 ..< list.size) {
                if (list[i]+list[j] == target) return true
            }
        }
        return false
    }

    fun pairSum2(list: IntArray, target: Int): Boolean {
        //if list is not sorted then sort first
        //list.sort()
        var start = 0
        var end = list.size-1
        while (start < end) {
            val sum = list[start] + list[end]
            when {
                sum < target -> start++
                sum > target -> end--
                else -> return true
            }
        }
        return false
    }

    //It Works when list is sorted but ROTATED
    fun pairSum3(list: IntArray, target: Int): Boolean {
        var breakingPoint = -1
        for (index in 0 ..< list.size-1) {
            if (list[index] > list[index+1]) {
                breakingPoint = index
                break
            }
        }

        var left = breakingPoint+1
        var right = breakingPoint

        while (left != right) {
            val sum = list[left] + list[right]
            when {

                sum < target -> left = (left + 1) % list.size
                sum > target -> right = (right + list.lastIndex) % list.size
                else -> { //sum == target
                    return true
                }
            }
        }
        return false
    }
}

fun main() {
    Solution().apply {
        val list = intArrayOf(1,2,3,4,5,6)
        println(pairSum1(list, 5))
        println(pairSum1(list,50))
        println("=====================")

        println(pairSum2(list,5))
        println(pairSum2(list,50))
        println("=====================")

        val list2 = intArrayOf(4,5,6,1,2,3)
        println(pairSum3(list2,5))
        println(pairSum3(list2,50))
    }
}
