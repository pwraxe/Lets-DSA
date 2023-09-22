class Solution {
    fun countingSort(arr:IntArray): IntArray {

        val minValue = arr.min()
        val maxValue = arr.max() - minValue

        val numCounts = IntArray(maxValue+1)
        arr.forEach {
            numCounts[it-minValue] += 1
        }
        println(numCounts.contentToString())
        var startIndex = 0
        for (index in 0 until numCounts.size) {
            val num = numCounts[index]
            numCounts[index] = startIndex
            startIndex += num
        }

        println(numCounts.contentToString())
        val sorted = IntArray(arr.size) { 0 }

        for(item in arr) {
            sorted[numCounts[item-minValue]] = item
            numCounts[item-minValue] += 1
        }
        return sorted
    }
}


fun main() {
    Solution().apply {
        println(countingSort(intArrayOf(5,1,7,4,6,3,2,-1,-5,-7,-6)).contentToString())
    }
}
