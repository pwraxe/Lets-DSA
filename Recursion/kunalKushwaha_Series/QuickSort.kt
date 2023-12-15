class Solution {

    private fun toQuickSort(list: IntArray, low: Int = 0, high: Int = list.size-1) {
        if(low >= high) return

        var start = low
        var end = high
        val midIndex = start + (end - start) / 2
        val pivot = list[midIndex]

        while(start <= end) {
            while(list[start] < pivot) start++
            while(list[end] > pivot) end--

            if(start <= end) {
                list[start] = list[end].also{ list[end] = list[start] }
                start++
                end--
            }
        }
        
        toQuickSort(list, low, end)
        toQuickSort(list, start, high)
    }


    fun sort(list: IntArray): IntArray {
        toQuickSort(list)
        return list
    }
}

fun main() {
    Solution().apply {
        println(sort(intArrayOf(9,1,3,2,7,6,4,5,8)).toTypedArray().contentToString())
    }
}
