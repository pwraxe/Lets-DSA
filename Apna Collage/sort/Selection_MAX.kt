//Selection Sort By Selecting or considering first element as a max element and sending to last position

class Solution {
    fun selectionSort(n:IntArray): IntArray {
        var maxIndex = 0
        var index = 0
        var end = n.size-1

        while (end > 0) {
            index = 0
            maxIndex = 0
            while (index <= end) {
                if (n[index] > n[maxIndex]) {
                    maxIndex = index
                }
                index++
            }
            n[end] = n[maxIndex].also { n[maxIndex] = n[end] }
            end--
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
