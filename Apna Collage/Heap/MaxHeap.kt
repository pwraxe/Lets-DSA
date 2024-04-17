class MaxHeap {
    private val list = mutableListOf<Int>()
    fun add(item: Int) {
        list.add(item)
        var childIndex = list.lastIndex
        var parentIndex = (childIndex-1)/2
        while (list[childIndex] > list[parentIndex]) {
            list[childIndex] = list[parentIndex].also { list[parentIndex] = list[childIndex] }
            childIndex = parentIndex
            parentIndex = (childIndex-1)/2
        }
    }
    
    private fun heapify(parentIndex:Int) {
        val leftIndex = (2 * parentIndex) + 1
        val rightIndex = (2 * parentIndex) + 2
        var maxIndex = parentIndex

        if (leftIndex < list.size && list[leftIndex] > list[maxIndex]) {
            maxIndex = leftIndex
        }

        if (rightIndex < list.size && list[rightIndex] > list[maxIndex]) {
            maxIndex = rightIndex
        }

        if (maxIndex != parentIndex) {
            list[maxIndex] = list[parentIndex].also { list[parentIndex] = list[maxIndex] }
            heapify(maxIndex)
        }
    }
    fun remove(): Int {
        //Swap with last Item
        list[0] = list[list.lastIndex].also { list[list.lastIndex] = list[0] }
        
        //remove Last Item
        val item = list.removeLast()

        //Heapify
        heapify(0)

        return item
    }
    fun peek(): Int {
        return list.first()
    }
    fun read() {
        println("${peek()} | ${list.toTypedArray().contentToString()}")
    }
}

fun main() {

    val list = listOf(5,4,8,1,9,3)
    println("\n=========MAX-HEAP==========")
    MaxHeap().apply {
        list.forEach { add(it) }
        read()
        println("Removed: ${remove()}")
        read()
    }
}

=========MAX-HEAP==========
9 | [9, 8, 5, 1, 4, 3]
Removed: 9
8 | [8, 4, 5, 1, 3]
