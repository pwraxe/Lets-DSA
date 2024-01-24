class Solution {
    fun countingSort(arr: IntArray): IntArray {
        val freq = IntArray(arr.max() + 1)
        arr.forEach {
            freq[it]++
        }
        var k = 0
        for (index in freq.indices) {
            while (freq[index] > 0) {
                arr[k++] = index
                freq[index]--
            }
        }
        return arr
    }
}
fun main() {
    Solution().apply {
//        val list = intArrayOf(9,8,2,4,5,1)
//        val list = intArrayOf(2,5,4,2,3,4)
        val list = intArrayOf(5,1,5,2,5,3,5,4,5,8,6,9,7)
        println(countingSort(list).toTypedArray().contentToString())
    }
}
