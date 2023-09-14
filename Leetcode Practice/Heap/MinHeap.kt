class LetsMinHeap {
    private val elements = mutableListOf<Int>()

    private fun getParentIndex(index: Int) = (index - 1).div(2)
    private fun getLeftIndex(index: Int) = (2 * index) + 1
    private fun getRightIndex(index: Int) = (2 * index) + 2

    fun add(item: Int) {
        elements.add(item)
        toMinHeapAfterAdd(elements.lastIndex)
    }
    fun remove() {
        if(elements.isNotEmpty()) {
            elements[0] = elements[elements.lastIndex].also { elements[elements.lastIndex] = elements[0] }
            elements.removeLast()
            toMinHeapAfterRemove(0)
        }
    }

    private fun toMinHeapAfterAdd(fromIndex:Int){
        val parentIndex = getParentIndex(fromIndex)
        if(elements[parentIndex] > elements[fromIndex]) {
            elements[parentIndex] = elements[fromIndex].also { elements[fromIndex] = elements[parentIndex] }
        }
        if(parentIndex != 0) {
            toMinHeapAfterAdd(parentIndex)
        }
    }

    private fun toMinHeapAfterRemove(fromIndex: Int) {
        val leftIndex = getLeftIndex(fromIndex)
        val rightIndex = getRightIndex(fromIndex)
        var currentIndex = fromIndex

        if(leftIndex < elements.size && elements[leftIndex] < elements[currentIndex]) {
            currentIndex = leftIndex
        }

        if(rightIndex < elements.size && elements[rightIndex] < elements[currentIndex]) {
            currentIndex = rightIndex
        }

        if(currentIndex != fromIndex) {
            elements[currentIndex] = elements[fromIndex].also { elements[fromIndex] = elements[currentIndex] }
            toMinHeapAfterRemove(fromIndex)
        }
    }

    fun read() {
        println(elements.toTypedArray().contentToString())
    }
}

fun main() {
    LetsMinHeap().apply {

        add(40)
        add(20)
        add(10)
        add(60)
        add(30)
        add(50)

        //[0] = 10
        read()

        remove()
        read()
    }
}
