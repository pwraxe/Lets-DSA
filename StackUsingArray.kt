class StackOverflowException(message: String) : RuntimeException(message)
class StackUnderflowException(message: String) : RuntimeException(message)

class FixedSizeStack<T> {

    private val minCapacity = 6
    private var elements : Array<Any?>
    private var size: Int = 0

    constructor() {
        //elements = Array(minCapacity){ null }
        //OR
        elements = arrayOfNulls(minCapacity)
    }

    constructor(capacity: Int) {
        if(capacity < 0) throw IllegalArgumentException("Invalid Capacity : $capacity")
        elements = arrayOfNulls(capacity)
    }

   fun push(item : T) {
        if(size == elements.size) {
            val newStack = arrayOfNulls<Any>(size+(size shr 1))
            System.arraycopy(elements,0,newStack,0,size)
            elements = newStack
        }
        elements[size++] = item
    }


    fun pop() {
        if(size == 0) throw StackUnderflowException("Can't Read, Stack Empty")
        val lastIndex = --size
        elements[lastIndex] = null
    }

    fun peak() : T = try { elements[size-1] as T } catch (ex : Exception) {
        throw StackUnderflowException("Empty Stack, Cant read peak")
    }

    fun getSize() = size
    fun isStackEmpty() = size == 0
    fun isStackFull() = size == elements.size
    fun getList() = elements
}


fun main() {

    FixedSizeStack<Int>(5).apply {

        push(11)
        push(12)
        push(13)
        push(14)
        push(15)

        println("List : ${getList().contentToString()}")
        println("Peak : ${peak()}  |  isMT : ${isStackEmpty()}  |  isFull : ${isStackFull()}  | size : ${getSize()}")

        pop()
        pop()
        pop()
        pop()

        println("\n\nAfter POP")
        println("List : ${getList().contentToString()}")
        println("Peak : ${peak()}  |  isMT : ${isStackEmpty()}  |  isFull : ${isStackFull()}  | size : ${getSize()}")

    }
}
