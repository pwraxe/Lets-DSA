class HeapSort {

    private lateinit var elements : IntArray
    fun heapSort(list: IntArray) : IntArray {
        elements = list
        for (index in (list.size/2)-1 downTo 0) {
            toMaxHeapify(list,list.size,index)
        }

        for (index in list.size-1 downTo 1) {
            elements[0] = elements[index].also { elements[index] = elements[0] }
            toMaxHeapify(list,index,0)
        }
        return elements
    }

    private fun getLeftIndex(index: Int) = (2 * index) + 1
    private fun getRightIndex(index: Int) = (2 * index) + 2

    private fun toMaxHeapify(list: IntArray, toIndex: Int, fromIndex: Int) {
        val leftIndex = getLeftIndex(fromIndex)
        val rightIndex = getRightIndex(fromIndex)
        var currentIndex = fromIndex
        if(leftIndex < toIndex && list[leftIndex] > list[currentIndex]) {
            currentIndex = leftIndex
        }
        if(rightIndex <  toIndex && list[rightIndex] > list[currentIndex]) {
            currentIndex = rightIndex
        }
        if(currentIndex != fromIndex) {
            list[currentIndex] = list[fromIndex].also { list[fromIndex] = list[currentIndex] }
            toMaxHeapify(list, toIndex, currentIndex)
        }
    }
}


fun main() {
    val list = intArrayOf(8,2,4,6,9,7,1,3,5)
    HeapSort().apply {
        println(heapSort(list).toTypedArray().contentToString())
    }
}

