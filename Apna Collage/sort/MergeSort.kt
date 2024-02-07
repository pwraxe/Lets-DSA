class Solution {

    fun divide(arr:IntArray, ): IntArray {
        if (arr.size <= 1) return arr
        val mid = arr.size/2
        val left = divide(arr.copyOfRange(0,mid), )
        val right = divide(arr.copyOfRange(mid, arr.size))
        return merge(left, right)
    }
    private fun merge(left:IntArray, right:IntArray): IntArray {
        val sorted = IntArray(left.size+right.size)
        var leftIndex = 0
        var rightIndex = 0
        var resultIndex = 0

        while (leftIndex < left.size && rightIndex < right.size) {
            sorted[resultIndex++] = if (left[leftIndex] < right[rightIndex]) {
                left[leftIndex++]
            } else {
                right[rightIndex++]
            }
        }

        while (leftIndex < left.size) {
            sorted[resultIndex++] = left[leftIndex++]
        }

        while (rightIndex < right.size) {
            sorted[resultIndex++] = right[rightIndex++]
        }

        return sorted
    }
    
    fun mergeSort(arr: IntArray, start: Int, end: Int) {
        if (start >= end) return

        val mid = start + (end - start) / 2

        //Left SubArray
        mergeSort(arr, start, mid)

        //Right SubArray
        mergeSort(arr, mid+1, end)

        conquer(arr, start, mid , end)

    }
    private fun conquer(arr: IntArray, start: Int, mid:Int, end: Int) {
        val temp = IntArray(end-start+1)
        var i = start
        var j = mid+1
        var k = 0

        while (i <= mid && j <= end) {
            if (arr[i] < arr[j]) {
                temp[k++] = arr[i++]
            } else {
                temp[k++] = arr[j++]
            }
        }

        while (i <= mid) {
            temp[k++] = arr[i++]
        }

        while (j <= end) {
            temp[k++] = arr[j++]
        }

        var index = start
        var position = 0
        while (position < temp.size) {
            arr[index++] = temp[position++]
        }
    }
}
fun main() {
    Solution().apply {
        val list = intArrayOf(8,5,7,6,9,4,3,2,1)
        println(divide(list).toTypedArray().contentToString())
        
        mergeSort(list,0,list.size-1)
        println(list.toTypedArray().contentToString())
    }
}



// [1, 2, 3, 4, 5, 6, 7, 8, 9]
// [1, 2, 3, 4, 5, 6, 7, 8, 9]
