class Solution {

    //O(n)
    private fun getMaxValue(list: IntArray): Int {
        var max = list[0]
        list.forEach {
            if(it > max) max = it
        }
        return max
    }

    //O(n)
    private fun countingSort(list: IntArray, place: Int): IntArray {

        val result = IntArray(list.size)
        val counts = IntArray(10)

        for (index in 0 until list.size) {
            val digit = (list[index] / place) % 10
            counts[digit] += 1
        }

        for (index in 1 until counts.size) {
            counts[index] += counts[index-1]
        }

        for(index in list.size-1 downTo 1) {
            val digit = (list[index] / place) % 10
            result[counts[digit]-1] = list[index]
            counts[digit]--
        }

        return result
    }

    //O(n*n)
    fun radixSort(list: IntArray): IntArray {
        var result = list
        val maxValue = getMaxValue(list)
        var place = 1
        while (maxValue / place > 0) {          //O(n)
           result = countingSort(result,place)  //O(n)
           place *= 10
        }
        return result
    }
}

fun main() {
    Solution().apply {
        println(radixSort(intArrayOf(10,88,24,66,70,12,185,950,5)).contentToString())
    }
}
