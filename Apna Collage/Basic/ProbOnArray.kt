class Solution {
    fun binarySearch(list:IntArray, key:Int): Int {
        var start = 0
        var end = list.size-1
        while (start <= end) {
            val mid = (start + end) / 2
            when {
                key > list[mid] -> {
                    start = mid + 1
                }
                key < list[mid] -> {
                    end = mid - 1
                }
                else -> {
                    return mid
                }
            }
        }
        return -1
    }

    fun reverseArray(list: IntArray) {
        var start = 0
        var end = list.size-1
        while (start < end) {
            list[start] = list[end].also { list[end] = list[start] }
            start++
            end--
        }
        println("Reverse List: ${list.toTypedArray().contentToString()}")
    }

    fun arrayPairs(list: IntArray) {
        var totalPair = 0
        for (i in 0 until list.size) {
            for (j in i+1 until list.size) {
                totalPair++
                print("[${list[i]},${list[j]}] ")
            }
            println()
        }
        println("Total Pairs: $totalPair")
    }

    fun printSubArray(list: IntArray, size: Int) {
        var index = 0
        while (index + size <= list.size) {
            val l = list.copyOfRange(index, index+size)
            print("${l.toTypedArray().contentToString()}, ")
            index++
        }
        println("\n=================================\n")
    }
}

fun main() {
    Solution().apply {
        val list = intArrayOf(1,2,3,4,5,6,7,8,9)
        println("Index of 7 : ${binarySearch(list,7)}")
        reverseArray(list)
        arrayPairs(list)

        (1.. list.size).forEach {
            printSubArray(list,it)
        }
    }
}
//===============================================================================

Index of 7 : 6
Reverse List: [9, 8, 7, 6, 5, 4, 3, 2, 1]
[9,8] [9,7] [9,6] [9,5] [9,4] [9,3] [9,2] [9,1] 
[8,7] [8,6] [8,5] [8,4] [8,3] [8,2] [8,1] 
[7,6] [7,5] [7,4] [7,3] [7,2] [7,1] 
[6,5] [6,4] [6,3] [6,2] [6,1] 
[5,4] [5,3] [5,2] [5,1] 
[4,3] [4,2] [4,1] 
[3,2] [3,1] 
[2,1] 

Total Pairs: 36
[9], [8], [7], [6], [5], [4], [3], [2], [1], 
=================================

[9, 8], [8, 7], [7, 6], [6, 5], [5, 4], [4, 3], [3, 2], [2, 1], 
=================================

[9, 8, 7], [8, 7, 6], [7, 6, 5], [6, 5, 4], [5, 4, 3], [4, 3, 2], [3, 2, 1], 
=================================

[9, 8, 7, 6], [8, 7, 6, 5], [7, 6, 5, 4], [6, 5, 4, 3], [5, 4, 3, 2], [4, 3, 2, 1], 
=================================

[9, 8, 7, 6, 5], [8, 7, 6, 5, 4], [7, 6, 5, 4, 3], [6, 5, 4, 3, 2], [5, 4, 3, 2, 1], 
=================================

[9, 8, 7, 6, 5, 4], [8, 7, 6, 5, 4, 3], [7, 6, 5, 4, 3, 2], [6, 5, 4, 3, 2, 1], 
=================================

[9, 8, 7, 6, 5, 4, 3], [8, 7, 6, 5, 4, 3, 2], [7, 6, 5, 4, 3, 2, 1], 
=================================

[9, 8, 7, 6, 5, 4, 3, 2], [8, 7, 6, 5, 4, 3, 2, 1], 
=================================

[9, 8, 7, 6, 5, 4, 3, 2, 1], 
=================================
