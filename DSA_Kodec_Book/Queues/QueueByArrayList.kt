interface Queues<T> {
    fun enqueue(element: T)
    fun dequeue() : T?
    fun peek() : T?
    fun isEmpty() : Boolean
    fun getSize() : Int
}

class LetsQueueImpl<T> : Queues<T> {

    private var queueList = arrayListOf<T>()

    override fun toString(): String = queueList.toString()

    //Time and Space Complexity : O(n)
    //For Insert element then Time and Space Complexity will be O(1)
    //Why O(n)? -> At Some point arrayList will full, it resizes itself, create new list and copy elements
    override fun enqueue(element: T) { queueList.add(element) }

    //Time and Space Complexity : O(n)
    //Multiple Shift operation need to perform if 0th index is your front
    override fun dequeue(): T? {
        return if(isEmpty()) null else queueList.removeAt(0)
    }

    override fun peek(): T? = queueList.getOrNull(0)
    override fun isEmpty(): Boolean = queueList.size == 0
    override fun getSize(): Int = queueList.size
}

fun main() {
    LetsQueueImpl<Int>().apply {
        enqueue(11)
        enqueue(12)
        enqueue(13)
        enqueue(14)
        enqueue(15)
        enqueue(16)

        dequeue()

        println(toString())

        println("size : ${getSize()} | Peek : ${peek()} | isEmpty : ${isEmpty()}")
    }
}
