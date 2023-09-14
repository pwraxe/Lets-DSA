class LetsMaxHeap {
    private val elements = mutableListOf<Int>()

    fun add(item: Int) {
        elements.add(item)
        toMaxHeapAfterAdd(elements.lastIndex,0)
    }
    fun remove() {
        if(elements.isNotEmpty()) {
            elements[0] = elements[elements.lastIndex].also { elements[elements.lastIndex] = elements[0] }
            elements.removeLast()
            toMaxHeapAfterRemove(0)
        }

    }

    private fun getParentIndex(index:Int) : Int = (index - 1).div(2)
    private fun getLeftChildIndex(index: Int): Int = 2*index + 1
    private fun getRightChildIndex(index: Int): Int = 2*index + 2

    private fun toMaxHeapAfterAdd(fromIndex: Int, toIndex: Int) {
        if(elements[fromIndex] > elements[toIndex]) {
            elements[fromIndex] = elements[toIndex].also { elements[toIndex] = elements[fromIndex] }
        }
        if(fromIndex != toIndex) {
            toMaxHeapAfterAdd(getParentIndex(fromIndex), toIndex)
        }
    }

    private fun toMaxHeapAfterRemove(fromIndex: Int) {
        val leftIndex = getLeftChildIndex(fromIndex)
        val rightIndex = getRightChildIndex(fromIndex)
        var maxItemIndex = fromIndex

        if(leftIndex < elements.size && elements[maxItemIndex] < elements[leftIndex]) {
            maxItemIndex = leftIndex
        }
        if(rightIndex < elements.size
            && elements[maxItemIndex] < elements[rightIndex]) {
            maxItemIndex = rightIndex
        }

        if(maxItemIndex != fromIndex) {
            elements[fromIndex] = elements[maxItemIndex].also { elements[maxItemIndex] = elements[fromIndex] }
            toMaxHeapAfterRemove(maxItemIndex)
        }
    }

    fun read() {
        println(elements.toTypedArray().contentToString())
    }
}

fun main() {
    LetsMaxHeap().apply {
        add(10)
        add(15)
        add(5)
        add(3)
        add(8)
        add(20)

        read()
        remove()
        remove()
        remove()
        remove()
        remove()
        remove()
        remove()
        read()
    }
}
