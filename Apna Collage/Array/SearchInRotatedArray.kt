class Solution {
    fun searchInRotatedArray(list:IntArray, start: Int, end: Int, target: Int): Int {
        if (start > end) return -1
        val mid = start + (end - start) / 2
        if (target == list[mid]) {
            return mid
        }
        return if (target < list[mid]) {
            if (target in list[start] .. list[mid]) {
                searchInRotatedArray(list, start, mid, target)
            } else {
                searchInRotatedArray(list, mid+1, end, target)
            }
        } else {
            if (target in list[mid] .. list[end]) {
                searchInRotatedArray(list, mid+1, end, target)
            } else {
                searchInRotatedArray(list, start, mid, target)
            }
        }
    }
}

fun main() {
    Solution().apply {
        val list = intArrayOf(5,6,7,8,9,1,2,3,4)
        val target = 4 //1 5
        val index = searchInRotatedArray(list,0,list.size-1,target)
        if (index == -1) {
            println("$target Not Found")
        } else {
            println("$target found at index $index = ${list[index]}")
        }
    }
}

// 4 found at index 8 = 4
