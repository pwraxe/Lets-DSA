/**
 * Note:
 * Perform Insert and Remove element from heap by achieving MIN Heap Property
 * Perform Insert and Remove element from heap by achieving MAX Heap Property
 * **/

/**
 * Note: Make Output Correct and Then Jump to challenge Page NO 233
 *
 * **/

interface Collection<T> {
    val count: Int
        get

    val isEmpty : Boolean
        get() = count == 0
}

interface Heap<T>: Collection<T> {

    fun peek():T?
    fun insertForMaxHeap(item: T)
    fun insertForMinHeap(item: T)

    fun removeFromMaxHeap(index: Int)
    fun removeFromMinHeap(index: Int)
}

class HeapImp<T:Comparable<T>> : Heap<T> {

    private var elements: MutableList<T> = mutableListOf()

    private fun leftChildIndex(index: Int) :Int = (2 * index) + 1
    private fun rightChildIndex(index: Int) : Int = (2 * index) + 2
    private fun parentIndex(index: Int) : Int = (index - 1) / 2

    override val count: Int
        get() = elements.size

    override val isEmpty: Boolean
        get() = count == 0

    fun getAll() = elements

    override fun insertForMaxHeap(item: T) {
        elements.add(item)
        //Max Heap : Root/Parent element should be more than its child
        heapifyForMaxHeap(count - 1)
    }
    protected fun heapifyForMaxHeap(index:Int) {
        var currentIndex = index
        var parentIndex = parentIndex(currentIndex)

        while (currentIndex > 0) {
            if (elements[currentIndex] > elements[parentIndex]) {
                //swap
                elements[currentIndex] = elements[parentIndex].also { elements[parentIndex] = elements[currentIndex] }
            }
            currentIndex = parentIndex
            parentIndex = parentIndex(currentIndex)
        }
    }

    override fun insertForMinHeap(item: T) {
        elements.add(item)
        //Min Heap : Root / Parent Element should be less than its child
        heapifyForMinHeap(count - 1)
    }
    protected fun heapifyForMinHeap(index:Int) {
        var currentIndex = index
        var parentIndex = parentIndex(currentIndex)

        while (currentIndex > 0) {
            if(elements[parentIndex] > elements[currentIndex]) {
                //swap
                elements[parentIndex] = elements[currentIndex].also { elements[currentIndex] = elements[parentIndex] }
            }
            currentIndex = parentIndex
            parentIndex = parentIndex(currentIndex)
        }
    }

    override fun removeFromMaxHeap(index: Int) {
        //swap first and last index
        if(!isEmpty) {
            val lastIndex = count - 1
            elements[index] = elements[lastIndex].also { elements[lastIndex] = elements[index] }
            val item = elements.removeAt(lastIndex)

            //if you want to return removed value
            //create new function to write below code with Unit as Return Type and next line return item

            //Now lets try to achieve Max Heap Property

            //NOTE : You took 0 for parent Index, for remove root node,
            //You can assign index value which index you want to remove

            var parentIndex = index
            var leftChildIndex = leftChildIndex(parentIndex)
            var rightChildIndex = rightChildIndex(parentIndex)
            var currentIndex = parentIndex

            while (currentIndex < count) {

                if (leftChildIndex < count && elements[leftChildIndex] > elements[currentIndex]) {
                    currentIndex = leftChildIndex
                }

                if(rightChildIndex < count && elements[rightChildIndex] > elements[currentIndex]) {
                    currentIndex = rightChildIndex
                }

                if(parentIndex == currentIndex) return

                elements[parentIndex] = elements[currentIndex].also { elements[currentIndex] = elements[parentIndex] }
                parentIndex = currentIndex
                leftChildIndex = leftChildIndex(parentIndex)
                rightChildIndex = rightChildIndex(parentIndex)
            }
        }
    }
    override fun removeFromMinHeap(index: Int){
        if(!isEmpty) {

            val lastIndex = count - 1
            elements[index] = elements[lastIndex].also { elements[lastIndex] = elements[index] }
            val item = elements.removeAt(lastIndex)
            //if you want to return removed value
            //create new function to write below code with Unit as Return Type and next line return item

            //Now lets try to achieve Min Heap Property

            var parentIndex = index
            var leftChildIndex = leftChildIndex(parentIndex)
            var rightChildIndex = rightChildIndex(parentIndex)
            var currentIndex = parentIndex

            while (currentIndex < count) {
                if(leftChildIndex < count && elements[leftChildIndex] < elements[currentIndex]) {
                    //I want small element index
                    currentIndex = leftChildIndex
                }

                if(rightChildIndex < count && elements[rightChildIndex] < elements[currentIndex]) {
                    //I want small element index
                    currentIndex = rightChildIndex
                }

                if(currentIndex == parentIndex) return

                //Swap
                elements[currentIndex] = elements[parentIndex].also { elements[parentIndex] = elements[currentIndex] }

                parentIndex = currentIndex
                leftChildIndex = leftChildIndex(parentIndex)
                rightChildIndex = rightChildIndex(parentIndex)
            }
        }
    }


    override fun peek(): T? {
        return elements.first()
    }
}

class HeapDS<T>
fun main() {

    HeapImp<Int>().apply {
        insertForMaxHeap(1)
        insertForMaxHeap(12)
        insertForMaxHeap(3)
        insertForMaxHeap(4)
        insertForMaxHeap(1)
        insertForMaxHeap(6)
        insertForMaxHeap(8)
        insertForMaxHeap(7)
        println("Get All : ${getAll().toTypedArray().contentToString()}") //[12, 7, 8, 4, 1, 3, 6, 1]
        println("Max Element in list all : ${peek()}")
        //Remove Root
        removeFromMaxHeap(0)
        println("After Remove Root : ${getAll().toTypedArray().contentToString()}")

        removeFromMaxHeap(2)
        println("After Remove 2nd Index : ${getAll().toTypedArray().contentToString()}")

        println("Max Element in list : ${peek()}")
//        insertForMinHeap(1)
//        insertForMinHeap(12)
//        insertForMinHeap(3)
//        insertForMinHeap(4)
//        insertForMinHeap(1)
//        insertForMinHeap(6)
//        insertForMinHeap(8)
//        insertForMinHeap(7)

    }
}

//================================================================================================================================================


//Following is OLD Code and untestable pls refer above code

interface Collection<T> {
    val count: Int
        get

    val isEmpty : Boolean
        get() = count == 0
}

interface Heap<T>: Collection<T> {
    fun peek():T?
    fun insertForMaxHeap(item: T)
    fun insertForMinHeap(item: T)

    fun removeFromMaxHeap()
    fun removeFromMinHeap()

    fun removeAtFromMaxHeap(index: Int): T?
    fun removeAtFromMinHeap(index: Int) :T?
}

abstract class AbstractHeapImp<T:Comparable<T>> : Heap<T> {

    private var elements: MutableList<T> = mutableListOf()

    private fun leftChildIndex(index: Int) :Int = (2 * index) + 1
    private fun rightChildIndex(index: Int) : Int = (2 * index) + 2
    private fun parentIndex(index: Int) : Int = (index - 1) / 2

    override val count: Int
        get() = elements.size

    override val isEmpty: Boolean
        get() = count == 0

    override fun insertForMaxHeap(item: T) {
        elements.add(item)
        //Max Heap : Root/Parent element should be more than its child
        var currentIndex = count - 1
        var parentIndex = parentIndex(currentIndex)

        while (currentIndex > 0) {
            if (elements[currentIndex] > elements[parentIndex]) {
                //swap
                elements[currentIndex] = elements[parentIndex].also { elements[parentIndex] = elements[currentIndex] }
            }
            currentIndex = parentIndex
            parentIndex = parentIndex(currentIndex)
        }
    }

    override fun insertForMinHeap(item: T) {
        elements.add(item)
        //Min Heap : Root / Parent Element should be less than its child

        var currentIndex = count - 1
        var parentIndex = parentIndex(currentIndex)

        while (currentIndex > 0) {
            if(elements[parentIndex] > elements[currentIndex]) {
                //swap
                elements[parentIndex] = elements[currentIndex].also { elements[currentIndex] = elements[parentIndex] }
            }
            currentIndex = parentIndex
            parentIndex = parentIndex(currentIndex)
        }
    }

    override fun removeFromMaxHeap() {
        //swap first and last index
        if(!isEmpty) {
            val lastIndex = count - 1
            elements[0] = elements[lastIndex].also { elements[lastIndex] = elements[0] }
            val item = elements.removeAt(lastIndex)
            //if you want to return removed value
            //create new function to write below code with Unit as Return Type and next line return item

            //Now lets try to achieve Max Heap Property

            var parentIndex = 0
            var leftChildIndex = leftChildIndex(parentIndex)
            var rightChildIndex = rightChildIndex(parentIndex)
            var currentIndex = parentIndex

            while (currentIndex < count) {

                if (leftChildIndex < count && elements[leftChildIndex] > elements[currentIndex]) {
                    currentIndex = leftChildIndex
                }

                if(rightChildIndex < count && elements[rightChildIndex] > elements[currentIndex]) {
                    currentIndex = rightChildIndex
                }

                if(parentIndex == currentIndex) return

                elements[parentIndex] = elements[currentIndex].also { elements[currentIndex] = elements[parentIndex] }
                parentIndex = currentIndex
                leftChildIndex = leftChildIndex(parentIndex)
                rightChildIndex = rightChildIndex(parentIndex)
            }
        }
    }

    override fun removeFromMinHeap(){
        if(!isEmpty) {

            val lastIndex = count - 1
            elements[0] = elements[lastIndex].also { elements[lastIndex] = elements[0] }
            val item = elements.removeAt(lastIndex)
            //if you want to return removed value
            //create new function to write below code with Unit as Return Type and next line return item

            //Now lets try to achieve Min Heap Property

            var parentIndex = 0
            var leftChildIndex = leftChildIndex(parentIndex)
            var rightChildIndex = rightChildIndex(parentIndex)
            var currentIndex = parentIndex

            while (currentIndex < count) {
                if(leftChildIndex < count && elements[leftChildIndex] < elements[currentIndex]) {
                    //I want small element index
                    currentIndex = leftChildIndex
                }

                if(rightChildIndex < count && elements[rightChildIndex] < elements[currentIndex]) {
                    //I want small element index
                    currentIndex = rightChildIndex
                }

                if(currentIndex == parentIndex) return

                //Swap
                elements[currentIndex] = elements[parentIndex].also { elements[parentIndex] = elements[currentIndex] }

                parentIndex = currentIndex
                leftChildIndex = leftChildIndex(parentIndex)
                rightChildIndex = rightChildIndex(parentIndex)
            }
        }
    }
}
