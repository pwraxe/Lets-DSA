//TODO = 17. Circular Queue by Vector (RTL) Enqueue From Right/Rear/End, Dequeue From Left/Front/Start

class CircularQueueByVectorRTL<T> {

    private var capacity : Int = 6
    private var elements : Array<Any?>
    private var size : Int = 0

    private var front : Int = -1
    private var rear : Int = -1

    constructor() {
        elements = arrayOfNulls(capacity)
    }
    constructor(size: Int) {
        if(size < 0) throw IllegalArgumentException("invalid size : $size")
        elements = arrayOfNulls(size)
    }

    //CREATE
    //Enqueue From Right/Rear/End
    fun enqueue(item :T) {

        rear = (rear + 1) % capacity
        if(rear == front) {
            //For inc array size, i am just adding default capacity(6) to current size
            val newArray = CircularQueueByVectorRTL<T>(size+capacity)
            System.arraycopy(elements,0,newArray.elements,0,size)
            elements = newArray.elements
            capacity = elements.size
            front = 0
            rear = elements.size
        }
        elements[rear] = item
        if(front == -1) front = rear
        size++

    }

    //READ
    fun getFront() : Any? = if(front != -1) elements[front] else null
    fun getRear() : Any? = if (rear != -1) elements[rear] else null
    fun getAll() = elements
    fun getSize() = size

    //UPDATE
    fun updateFirst(item : T) {
        if(front != -1) {
            elements[front] = item
        }
    }
    fun updateLast(item: T) {
        if(rear != -1) {
            elements[rear] = item
        }
    }
    fun updateIndex (index : Int, item: T) {
        if(index > size || index < 0) throw IndexOutOfBoundsException("Invalid Index : $index")
        when(index) {
            0 -> updateFirst(item)
            getSize() -> getRear()
            else -> elements[index] = item
        }
    }

    //DELETE
    //Dequeue From Left/Front/Start
    fun dequeue() {
        if(front == -1) println("Cant Remove") else {
            elements[front] = null
            if(front == rear) {
                front = -1
                rear = -1
            } else {
                front = (front + 1) % capacity
            }
            size--
        }
    }

    //OTHER
    fun isFull() = (rear + 1) % capacity == front

    fun checkForCircularQueue(size:Int) {
        var f = -1
        var r = -1

        repeat(size) {
            r = (r+1) % capacity
            println("Checking : $it ==> ${elements[r]}")
        }
    }
}

fun main() {

    //Enqueue From Right/Rear/End, Dequeue From Left/Front/Start
    CircularQueueByVectorRTL<Any>().apply {

        enqueue(11)
        enqueue(12)
        enqueue(13)
        enqueue(14)
        enqueue(15)
        enqueue(16)

        //check is it Queue
        //checkForCircularQueue(12)

        updateFirst(111)
        updateIndex(2,1333)
        updateLast(166)

        dequeue()

        println("${getSize()} | ${getFront()} | ${getAll().contentToString()} | ${getRear()} || ${isFull()}")

    }

}
