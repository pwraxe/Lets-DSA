/*
Hi Akshay, 
You ware suppose to revert all items in Queue so use use heap sort for that 
But you forgot sequence can be anything in input thats why this code is complety wrong

you push / save this code becoz in future when you come up with max heap solution then this will help you in that
*/

class PriorityQueue {

    private val elements = mutableListOf<Int>()
    val size: Int
        get() = elements.size

    private val isEmpty: Boolean
        get() = size == 0



    fun read() = elements
    private fun parentIndex(index: Int): Int =  (index - 1) / 2
    private fun leftChildIndex(index: Int) = (index * 2) + 1
    private fun rightChildIndex(index: Int) = (index * 2 ) + 2

    fun enQ(item: Int) {
        elements.add(item)
        toMaxHeap(size-1)
    }

    fun deQ(): Int {
        return if(!isEmpty) {
            val lastIndex = size-1
            elements[0] = elements[lastIndex].also { elements[lastIndex] = elements[0] }
            val item = elements.removeAt(lastIndex)
            toMaxHeapAfterRemove(0)
            item
        } else 0
    }

    fun peek(): Int = if(size != 0) elements[0] else 0

    private fun toMaxHeap(index: Int){

        val parentIndex = parentIndex(index)
        if(elements[index] > elements[parentIndex]) {
            //swap
            elements[parentIndex] = elements[index].also { elements[index] = elements[parentIndex]}
        }
        if(parentIndex != index) {
            toMaxHeap(parentIndex)
        }
    }

    private fun toMaxHeapAfterRemove(index: Int) {
        var currentIndex = index
        val parentIndex = currentIndex
        val leftIndex = leftChildIndex(currentIndex)
        val rightIndex =rightChildIndex(currentIndex)


        if(leftIndex < size && elements[leftIndex] > elements[currentIndex]){
            currentIndex = leftIndex
        }

        if(rightIndex < size && elements[rightIndex] > elements[currentIndex]) {
            currentIndex = rightIndex
        }

        if(currentIndex != parentIndex) {
            elements[currentIndex] = elements[parentIndex].also { elements[parentIndex] = elements[currentIndex] }
            toMaxHeapAfterRemove(currentIndex)
        }
    }
}

class MyStack() {

    private val maxPriorityQ = PriorityQueue()

    fun push(x: Int) {
        maxPriorityQ.enQ(x)
    }

    fun pop(): Int {
        return maxPriorityQ.deQ()
    }

    fun top(): Int = maxPriorityQ.peek()

    fun empty(): Boolean = maxPriorityQ.size == 0
    fun read() = maxPriorityQ.read()
}

fun main() {
    MyStack().apply {
        push(1)
        push(2)
        push(3)
        push(4)
        push(2)
        println(read().toTypedArray().contentToString())
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * var obj = MyStack()
 * obj.push(x)
 * var param_2 = obj.pop()
 * var param_3 = obj.top()
 * var param_4 = obj.empty()
 */
