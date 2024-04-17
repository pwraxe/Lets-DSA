class MaxHeap {

    private fun heapifyForSorting(list: IntArray, index: Int) {
        val left = (2 * index) + 1
        val right = (2 * index) + 2
        var maxIndex = index

        if (left < list.size && list[maxIndex] < list[left]) {
            maxIndex = left
        }
        if (right < list.size && list[maxIndex] < list[right]) {
            maxIndex = right
        }

        if (maxIndex != index) {
            list[index] = list[maxIndex].also { list[maxIndex] = list[index] }
            heapifyForSorting(list,maxIndex)
        }
    }
    fun heapSort(list: IntArray): IntArray {

        for (i in list.size/2 downTo 0) {
            heapifyForSorting(list,i)
        }

        for (i in list.size-1 downTo 0) {
            list[0] = list[i].also { list[i] = list[0] }
            heapifyForSorting(list,i)
        }

        return list
    }

}
class MinHeap {


    private fun heapifyForSorting(list: IntArray, index: Int) {
        val left = (2 * index) + 1
        val right = (2 * index) + 2
        var minIndex = index

        if (left < list.size && list[minIndex] > list[left]) {
            minIndex = left
        }
        if (right < list.size && list[minIndex] > list[right]) {
            minIndex = right
        }

        if (minIndex != index) {
            list[index] = list[minIndex].also { list[minIndex] = list[index] }
            heapifyForSorting(list,minIndex)
        }
    }
    fun heapSort(list: IntArray): IntArray {

        for (i in list.size/2 downTo 0) {
            heapifyForSorting(list,i)
        }

        for (i in list.size-1 downTo 0) {
            list[0] = list[i].also { list[i] = list[0] }
            heapifyForSorting(list,0)
        }

        return list
    }
}

fun main() {

    val list = listOf(5,4,8,1,9,3)
    println("=========MIN-HEAP==========")
    MinHeap().apply {
        println("ASC Sorting: ${heapSort(list.toIntArray()).toTypedArray().contentToString()}")
    }
    println("\n=========MAX-HEAP==========")
    MaxHeap().apply {
        println("DESC Sorting: ${heapSort(list.toIntArray()).toTypedArray().contentToString()}")
    }
}



=========MIN-HEAP==========
ASC Sorting: [1, 3, 4, 5, 8, 9]

=========MAX-HEAP==========
DESC Sorting: [9, 8, 5, 4, 3, 1]
