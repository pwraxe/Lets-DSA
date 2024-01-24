//Selection Sort By Selecting or considering first element as a min element and sending to first position
//OR
// consider start value as min and get min value swap

class Solution {
    fun selectionSort(n:IntArray): IntArray {
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
}
fun main() {
    Solution().apply {
        val n = selectionSort(intArrayOf(5,4,1,3,2))
        println(n.toTypedArray().contentToString())
    }
}
