//Circular Queue

class LetsCircularFixedQueue<T>(var capacity : Int = 6) {

    private var elements : Array<Any?> = when {
        capacity > 0 || capacity == 0 -> arrayOfNulls(capacity)
        else -> throw IllegalArgumentException("Invalid Capacity : $capacity")
    }
    private var size : Int = 0
    private var front = -1
    private var rear = -1

     fun enqueue(item: T?) {
        if(isQueueFull()) {

            //If you want to stop when Queue Full then 
            /**
            println("Cannot insert value $item, Queue is Full")
            return
            **/

            //If you want to incrase size of Queue when it fulls then
            val incCapacity = size shr 1
            val newList = arrayOfNulls<Any>(size+incCapacity)
            System.arraycopy(elements,0,newList,0,size)
            elements = newList
        }
        rear = (rear+1) % capacity
        elements[rear] = item
        size++
        if(front == -1) front = rear
    }

    fun dequeue() : T? {
        var itemWhichRemoved : T? = null
        if(front == rear) {
            println("No Element in Queue")
            return null
        }
        itemWhichRemoved = elements[front] as T
        elements[front] = null

        if(front == rear) {
            (-1).apply{
                front = this
                rear = this
            }
        }
        front = (front + 1) % capacity
        return itemWhichRemoved
    }

    fun isQueueFull() : Boolean = (rear+1) % capacity == front

    fun readAll() = elements

    fun front() : T? = elements[front] as T?
    fun rear() : T? = elements[rear] as T?
    fun isEmpty() = front == -1
}

fun main() {
    LetsCircularFixedQueue<Int>(6).apply {
        enqueue(11)
        enqueue(12)
        enqueue(13)
        enqueue(14)
        enqueue(15)
        enqueue(16)
        enqueue(17)
        println("${isQueueFull()} | ${isEmpty()} | ${front()} | ${rear()}")

        println("${readAll().contentToString()}")
        dequeue()
        dequeue()
        dequeue()
        dequeue()
        dequeue()
        dequeue()
        dequeue()
        println("${isQueueFull()} | ${isEmpty()} | ${front()} | ${rear()}")
    }
}
