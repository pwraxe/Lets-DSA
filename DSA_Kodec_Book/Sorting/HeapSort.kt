class Heap<T: Comparable<T>> {

    private var elements = mutableListOf<T>()
    private var removedValues = mutableListOf<T>()

    private val count: Int
        get() = elements.size

    private val isEmpty : Boolean
        get() = count == 0

    //To check elements in array
    fun readList() = elements

    //to view all removed elements for sorted
    fun allRemovedItems() = removedValues

    private fun leftChildIndex(index: Int) : Int = (2 * index) + 1
    private fun rightChildIndex(index: Int) : Int = (2 * index) + 2
    private fun parentIndex(index:Int)  = (index-1)/2

    fun insert(item: T) {
        elements.add(item)

        //Based on requirements we call this functions
        toMaxHeap(elements.size-1)
        //toMinHeap(elements.size-1)
    }

    private fun remove() : T? {
        if(!isEmpty) {
            //swap root with lastIndex
            val lastIndex = count-1
            elements[lastIndex]  = elements[0].also { elements[0] = elements[lastIndex] }

            val rootItem = elements.removeAt(lastIndex)
            removedValues.add(rootItem)

            toMaxHeapAfterRemove(0)

            return rootItem
        }
        return null
    }

    //To Convert List to Max Heap using Recursion
    private fun toMaxHeap(index: Int) {
        val parentIndex = parentIndex(index)

        if(elements[index] > elements[parentIndex]) {
            elements[index] = elements[parentIndex].also { elements[parentIndex] = elements[index] }
        }

        if (parentIndex != index) {
            toMaxHeap(parentIndex)
        }
    }

    //
    private fun toMaxHeapAfterRemove(index: Int) {

        var currentIndex = index //0
        val parentIndex = currentIndex
        val leftChildIndex = leftChildIndex(currentIndex)
        val rightChildIndex = rightChildIndex(currentIndex)

        if(leftChildIndex < count && elements[leftChildIndex] > elements[currentIndex]) {
            currentIndex = leftChildIndex
        }

        if(rightChildIndex < count && elements[rightChildIndex] > elements[currentIndex]) {
            currentIndex = rightChildIndex
        }

        if(currentIndex != parentIndex) {
            //Swap (currentIndex, parentIndex)
            elements[currentIndex] = elements[parentIndex].also { elements[parentIndex] = elements[currentIndex] }
            toMaxHeapAfterRemove(currentIndex)
        }
    }

    //Heapify List to Max list using recursion, by removing root index
    fun heapifyToMax() {
        if(!isEmpty) {
            remove()
            heapifyToMax()
        }
    }
}

fun main() {
    Heap<Int>().apply {
        insert(8)
        insert(1)
        insert(6)
        insert(84)
        insert(20)
        insert(40)
        insert(55)
        insert(12)
        insert(3)

        //View all element in list, [84, 20, 55, 12, 8, 6, 40, 1, 3]
        println(readList().toTypedArray().contentToString())

        //this removes all items from list and add to new list called removedValues array
        heapifyToMax()

        //elements are []
        println(readList().toTypedArray().contentToString())

        allRemovedItems().reverse()
        //Heapify : [1, 3, 6, 8, 12, 20, 40, 55, 84]
        println("Heapify : ${allRemovedItems().toTypedArray().contentToString()}")
    }
}
