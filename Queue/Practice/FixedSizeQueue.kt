class LetsFixedSizeQueue<T>(capacity: Int) {

    private var elements :Array<Any?>
    private var size : Int = 0

    init {
        when {
            capacity == 0 || capacity > 0 -> elements = arrayOfNulls(capacity)
            else -> throw IllegalArgumentException("Invalid Capacity : $capacity")
        }
    }

    fun enqueue(item: T) {
        if(elements.size == size) {
            //You can throw exception here
            println("No More enqueue, ${elements.size} == $size")
        } else {
            elements[size++] = item
        }
    }
    fun dequeue() {
        if(elements.isEmpty() || size == 0) {
            //You can throw exception here
            println("No More Dequeue, size : $size")
        } else {
            System.arraycopy(elements,1,elements,0,--size)
            elements[size] = null
        }
    }

    fun getSize() = size
    fun getFront() : Any? = if(getSize() > 0) elements[0] else null
    fun getRear() : Any? = if(getSize() > 0 ) elements[size-1] else null
    fun isFull() = size == elements.size
    fun isEmpty() = elements.isEmpty()

    fun readAll() = elements
}

fun main() {
    LetsFixedSizeQueue<Int>(5).apply {
        enqueue(10)
        enqueue(11)
        enqueue(12)
        enqueue(13)
        enqueue(14)

        dequeue()
        dequeue()
        dequeue()
//        dequeue()
//        dequeue()
//        dequeue()

        println(readAll().contentToString())

        println("${getSize()} | ${getFront()} | ${getRear()} | ${isFull()} | ${isEmpty()}")
    }
}
