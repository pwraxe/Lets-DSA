class Solution {
    fun mergeWithSpace(list: IntArray): IntArray {
        if (list.size == 1) return list
        val mid = list.size/2
        val left = list.copyOfRange(0,mid)
        val right = list.copyOfRange(mid,list.size)
        return sortWithSpace(mergeWithSpace(left), mergeWithSpace(right))
    }
    private fun sortWithSpace(left:IntArray, right:IntArray): IntArray {
        val result = IntArray(left.size + right.size)
        var resultIndex = 0
        var leftIndex = 0
        var rightIndex = 0
        while (leftIndex < left.size && rightIndex < right.size)
            result[resultIndex++] = if (left[leftIndex] < right[rightIndex]) left[leftIndex++] else right[rightIndex++]

        while (leftIndex < left.size)
            result[resultIndex++] = left[leftIndex++]

        while (rightIndex < right.size)
            result[resultIndex++] = right[rightIndex++]

        return result
    }

    fun mergeWithoutSpace(list: IntArray, start: Int, end: Int) {
        if (start < end) {
            val mid = start + (end - start) / 2

            //Left SubArray
            mergeWithoutSpace(list,start, mid)

            //Right SubArray
            mergeWithoutSpace(list, mid+1, end)

            sortWithoutSpace(list, start, mid, end)
        }
    }
    private fun sortWithoutSpace(list: IntArray, start: Int, mid: Int, end: Int) {
        var i = start
        var j = mid+1
        var k = 0
        val temp = IntArray(end-start+1)
        while (i <= mid && j <= end) {
            temp[k++] = if (list[i] < list[j]) list[i++] else list[j++]
        }
        while (i <= mid) {
            temp[k++] = list[i++]
        }

        while (j <= end) {
            temp[k++] = list[j++]
        }

        var index = start
        var indx = 0
        while (indx < temp.size) {
            list[index++] = temp[indx++]
        }
    }

}

fun main() {
    Solution().apply {
        val list = intArrayOf(7,1,6,9,8,3,4,5,2,0)
        println(mergeWithSpace(list).toTypedArray().contentToString())

        mergeWithoutSpace(list, 0, list.size-1)
        println(list.toTypedArray().contentToString())
    }
}


// [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
// [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
