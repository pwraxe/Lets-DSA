class Solution {
    fun selectionSortMax(n:IntArray): IntArray {
        var maxIndex = 0
        var index = 0
        var end = n.size-1

        while (end > 0) {
            index = 0
            maxIndex = 0
            while (index <= end) {
                if (n[maxIndex] < n[index]) {
                    maxIndex = index
                }
                index++
            }
            n[end] = n[maxIndex].also { n[maxIndex] = n[end] }
            end--
        }
        return n
    }
    fun selectionSortMin(n:IntArray): IntArray {
        var minIndex = 0
        var index = 0
        var start = 0
        while (start < n.size-1) {
            minIndex = start
            index = start+1
            while (index < n.size) {
                if (n[index] < n[minIndex]) {
                    minIndex = index
                }
                index++
            }
            n[start] = n[minIndex].also { n[minIndex] = n[start] }
            start++
        }
        return n
    }
    fun selectionSortMinAsc(n:IntArray): IntArray {
        var minIndex = 0
        for (i in 0 until n.size-1) {
            minIndex = i
            for (j in i+1 until n.size) {
                if (n[i] > n[minIndex]) {
                    minIndex = i
                }
            }
            n[minIndex] = n[i].also { n[i] = n[minIndex] }
        }

        return n
    }
}
fun main() {
    Solution().apply {
        val list = intArrayOf(5,4,1,3,2,4,1,2,5,3)

        //[1, 1, 2, 2, 3, 3, 4, 4, 5, 5]
        println(selectionSortMin(list).toTypedArray().contentToString())

        //[1, 1, 2, 2, 3, 3, 4, 4, 5, 5]
        println(selectionSortMax(list).toTypedArray().contentToString())

        //[1, 1, 2, 2, 3, 3, 4, 4, 5, 5]
        println(selectionSortMinAsc(list).toTypedArray().contentToString())

    }
}
