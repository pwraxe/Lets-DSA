class Solution {

    private fun divide(list: IntArray): IntArray {
        if (list.size == 1) return list
        val midIndex = list.size/2
        val left = divide(list.copyOfRange(0,midIndex))
        val right = divide(list.copyOfRange(midIndex,list.size))
        return merged(left, right)
    }

    private fun merged(left: IntArray, right: IntArray): IntArray {
        val result = IntArray(left.size + right.size)
        var leftIndex = 0
        var rightIndex = 0
        var resultIndex = 0

        while (leftIndex < left.size && rightIndex < right.size) {
            if (left[leftIndex] < right[rightIndex]) {
                result[resultIndex] = left[leftIndex]
                leftIndex++
            } else {
                result[resultIndex] = right[rightIndex]
                rightIndex++
            }
            resultIndex++
        }

        while (leftIndex < left.size) {
            result[resultIndex] = left[leftIndex]
            leftIndex++
            resultIndex++
        }

        while (rightIndex < right.size) {
            result[resultIndex] = right[rightIndex]
            rightIndex++
            resultIndex++
        }
        return result
    }
    fun mergeSort(list: IntArray): IntArray {
        return divide(list)
    }
}

fun main() {
    Solution().apply {
        println(mergeSort(intArrayOf(9,1,7,3,2,6,8,4,5)).toTypedArray().contentToString())
    }
}
