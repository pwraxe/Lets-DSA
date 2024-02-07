class Solution {

    fun mergeSort(arr: IntArray, start: Int, end: Int) {
        if (start >= end) {
            return
        }
        val mid = start + (end - start) / 2
        //Left
        mergeSort(arr, start, mid)

        //Right
        mergeSort(arr, mid+1, end)

        //Conquer
        conquer(arr, start, mid, end)
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
        var t = 0
        while (t < temp.size) {
            arr[index++] = temp[t++]
        }
    }

}
fun main() {
    Solution().apply {
        val list = intArrayOf(8,5,7,6,9,4,3,2,1)
        mergeSort(list,0,list.size-1)
        println(list.toTypedArray().contentToString())
    }
}



//[1, 2, 3, 4, 5, 6, 7, 8, 9]
