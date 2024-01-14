class Solution {
    fun linearSearch(list:IntArray, key:Int) : Int {
        for(index in list.indices) {
            if (list[index] == key) {
                return index
            }
        }
        return -1
    }

    fun largest(list: IntArray): Int {
        var largest = 0
        for (index in list.indices) {
            largest = Math.max(largest, list[index])
        }
        return largest
    }

    fun smallest(list: IntArray): Int {
        var smallest = Int.MAX_VALUE
        for (index in list.indices) {
            smallest = Math.min(smallest, list[index])
        }
        return smallest
    }
}

fun main() {
    Solution().apply {
        val list = intArrayOf(41,20,13,4,5,16,57,81,9,10)
        val index = linearSearch(list,5)
        println("index: $index")

        val largest = largest(list)
        println("Largest : $largest")

        val smallest = smallest(list)
        println("Smallest: $smallest")
    }
}

//===========================
index: 4
Largest : 81
Smallest: 4
