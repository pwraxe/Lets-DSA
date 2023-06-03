interface Collection<T> {
    val count : Int
        get

    val isEmpty : Boolean
        get() = count == 0

    fun insert(item: T)
    fun remove() : T?
    fun removeAt(index: Int) : T?
}

interface Heap<T> : Collection<T> {
    fun peek() :T?
}

abstract class AbstractHeapImpl<T> : Heap<T> {

    abstract fun compare(a:T, b:T) : Int

    private val elements : ArrayList<T> = arrayListOf()

    override val count: Int
        get() = elements.size

    override val isEmpty: Boolean
        get() = count == 0

    private fun leftChildIndex(index: Int) : Int = (2 * index) + 1
    private fun rightChildIndex(index: Int) : Int = (2 * index) + 2
    private fun parentIndex(index: Int) : Int = (index - 1) / 2

    override fun insert(item: T) {
        elements.add(item)
        shiftUp(count - 1)
    }

    //This functionality default remove first element from array
    override fun remove(): T? {

        if (isEmpty) return null

        //Step 1 : Swap first and last Element
        val lastElementIndex = count - 1
        elements[0] = elements[lastElementIndex].also { elements[lastElementIndex] = elements[0] }

        //Step 2 : Remove last element from array
        val item = elements.removeAt(lastElementIndex)

        //Step  3 : Try to achieve MIN or MAX heap Property
        //Heres try to achieve MIN Heap Property

        shiftDown(0)
        return item
    }

    private fun shiftDown(index:Int) {
        var parentIndex = index
        while (true) {
            val leftChildIndex = leftChildIndex(parentIndex)
            val rightChildIndex = rightChildIndex(parentIndex)
            //We need currentIndex and parentIndex for swapping
            var currentIndex = parentIndex

            //For Achive MAX Heap Property
            //if(count > leftChildIndex && compare(elements[leftChildIndex], elements[currentIndex]) > 0) {

            //For Achieve MIN Heap Property
            if(count > leftChildIndex && compare(elements[leftChildIndex], elements[currentIndex]) < 0) {
                currentIndex = leftChildIndex
            }

            if(count > rightChildIndex && compare(elements[rightChildIndex], elements[currentIndex]) < 0) {
                currentIndex = rightChildIndex
            }

            //This is BreakPoint Of While Loop
            if(parentIndex == currentIndex) return

            elements[currentIndex] = elements[parentIndex].also { elements[parentIndex] = elements[currentIndex] }
            parentIndex = currentIndex
        }
    }

    override fun removeAt(index: Int): T? {
        if(index > count) return null
        return if(index == count - 1) elements.removeAt(index) else {
            //swap given index with last index
            elements[index] = elements[count - 1].also { elements[count - 1] = elements[index] }
            shiftDown(index)
            shiftUp(index)
            elements.removeAt(count - 1)
        }
    }

    private fun shiftUp(index: Int) {
        var currentIndex = index
        var parentIndex = parentIndex(currentIndex)

        while (count > 0 && compare(elements[currentIndex], elements[parentIndex]) > 0) {
            elements[currentIndex] = elements[parentIndex].also { elements[parentIndex] = elements[currentIndex] }
            currentIndex = parentIndex
            parentIndex = parentIndex(currentIndex)
        }
    }

    override fun peek(): T? { return null }
}

class ComparableHeapImp<T: Comparable<T>> : AbstractHeapImpl<T>() {
    override fun compare(a: T, b: T) : Int = a.compareTo(b)
}
