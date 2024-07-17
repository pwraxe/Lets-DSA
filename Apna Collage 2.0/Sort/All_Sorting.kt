//Bubble Sort ASC
//Bubble Sort DESC

//Selection Sort ASC
//Selection Sort DESC

//InsertionSort ASC
//InsertionSort DESC

//Counting Sort ASC
//Counting Sort DESC

//Merge Sort

class Solution {

    fun bubbleSortASC(list: IntArray) {

        repeat(list.size-1) {
            for (j in 0 ..< list.size-1) {
                if (list[j] > list[j+1]) {
                    list[j] = list[j+1].also { list[j+1] = list[j] }
                }
            }
        }
        println(list.toTypedArray().contentToString())
    }
    fun bubbleSortDESC(list: IntArray) {

        repeat(list.size-1) {
            for (j in 0 ..< list.size-1) {
                if (list[j] < list[j+1]) {
                    list[j] = list[j+1].also { list[j+1] = list[j] }
                }
            }
        }
        println(list.toTypedArray().contentToString())
    }

    fun selectionSortASC(list: IntArray) {

        for (i in list.indices) {
            var minIndex = i
            for (j in i+1 ..< list.size) {
                if (list[j] < list[minIndex]) {
                    minIndex = j
                }
            }
            list[i] = list[minIndex].also { list[minIndex] = list[i] }
        }

        println(list.toTypedArray().contentToString())
    }
    fun selectionSortDESC(list: IntArray) {

        for (i in list.indices) {
            var minIndex = i
            for (j in i+1 ..< list.size) {
                if (list[j] > list[minIndex]) {
                    minIndex = j
                }
            }
            list[i] = list[minIndex].also { list[minIndex] = list[i] }
        }

        println(list.toTypedArray().contentToString())
    }

    fun insertionSortASC(list: IntArray) {

        for (i in 1 ..< list.size) {
            val temp = list[i]
            var prev = i-1

            while (prev >= 0 && list[prev] > temp) {
                list[prev+1] = list[prev]
                prev--
            }
            list[prev+1] = temp
        }

        println(list.toTypedArray().contentToString())
    }
    fun insertionSortDESC(list: IntArray) {

        for (i in 1 ..< list.size) {
            val temp = list[i]
            var prev = i-1

            while (prev >= 0 && list[prev] < temp) {
                list[prev+1] = list[prev]
                prev--
            }
            list[prev+1] = temp
        }
        println(list.toTypedArray().contentToString())
    }

    fun countingSortASC(list: IntArray) {
        val res = IntArray(list.size)
        for (num in list) {
            res[num]++
        }
        var index = 0
        for (i in res.indices) {
            val count = res[i]
            repeat(count) {
                list[index++] = i
            }
        }
        println(list.toTypedArray().contentToString())
    }
    fun countingSortDESC(list: IntArray) {
        val res = IntArray(list.size)
        for (num in list) {
            res[num]++
        }

        var index = 0
        for (i in res.size-1 downTo 0) {
            val count = res[i]
            repeat(count) {
                list[index++] = i
            }
        }
        println(list.toTypedArray().contentToString())
    }


    private fun merge(start: Int, mid: Int, end:Int, list: IntArray) {
        var left = start
        var right = mid+1
        var index = 0
        val res = IntArray(start+end+1)

        while (left <= mid && right <= end) {
            if (list[left] <= list[right]) {
                res[index++] = list[left++]
            }else {
                res[index++] = list[right++]
            }
        }

        while (left <= mid) res[index++] = list[left++]
        while (right < end) res[index++] = list[right++]

    }
    private fun devide(start: Int, end: Int, list: IntArray) {
        if (start == end) return
        val mid = (start+end)/2
        devide(start,mid,list)
        devide(mid+1, end, list)
        merge(start, mid, end, list)
    }
    fun mergeSort(list: IntArray) {
        devide(0, list.size-1, list)
        println(list.toTypedArray().contentToString())
    }

}

fun main() {

    Solution().apply {
        val list = intArrayOf(5,1,7,2,4,3,9,6,8,1,2)
        bubbleSortASC(list)
        bubbleSortDESC(list)
        println("========================================")
        selectionSortASC(list)
        selectionSortDESC(list)
        println("========================================")
        insertionSortASC(list)
        insertionSortDESC(list)
        println("========================================")
        countingSortASC(list)
        countingSortDESC(list)
        println("========================================")
        mergeSort(list)
    }
}
