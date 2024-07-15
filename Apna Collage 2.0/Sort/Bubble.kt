class Solution {
    fun bubbleSort(list: IntArray) {

        for (i in 0 .. list.size/2) {
            for (j in 0..<list.size-1-i) {
                if (list[j] > list[j+1]) {
                    list[j] = list[j+1].also { list[j+1] = list[j] }
                }
            }
        }

        println(list.toTypedArray().contentToString())
    }
}

fun main() {
    Solution().apply {

        val list = intArrayOf(2, 9, 7, 3, 1, 4, 8, 5, 6)
        bubbleSort(list)
    }
}
