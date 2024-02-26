class StaticQueue(private val size:Int) {

    private val queue = IntArray(size)
    private var front: Int = -1
    private var rear: Int = -1

    fun enqueue(item:Int) {
        if (isFull()) {
            println("Queue full, can't insert")
            return
        }
        if (front == -1) front = 0
        queue[++rear] = item
    }
    fun dequeue(): Int {
        if (isEmpty()) {
            println("Queue empty, can't delete")
            return -1
        }
        val value = queue[front]
        if (front == rear) { //i.e. we have only 1 element in queue
            queue[front] = 0
            front = -1
            rear = -1
            return value
        }

        for (i in front+1 .. rear) {
            queue[i-1] = queue[i]
        }
        queue[rear--] = 0
        return value
    }

    fun peek(): Int {
        if (isEmpty()) {
            println("Queue is empty")
            return -1
        }
        return queue[front]
    }
    private fun isEmpty(): Boolean = rear == -1
    private fun isFull(): Boolean = rear == size-1

    fun read() {
        println("Queue : ${queue.toTypedArray().contentToString()}")
        println("Front: $front | Rear: $rear | Peek: ${peek()}")
        println("isEmpty: ${isEmpty()} | isFull: ${isFull()}")
        println("--------------------------------------------")
    }
}

fun main() {
    StaticQueue(5).apply {

        repeat(5) {
            enqueue(it+1)
            read()
        }

        println("\n=====================\n")

        repeat(3) {
            println("Dequeued: ${dequeue()}")
            read()
        }

    }
}




Queue : [1, 0, 0, 0, 0]
Front: 0 | Rear: 0 | Peek: 1
isEmpty: false | isFull: false
--------------------------------------------
Queue : [1, 2, 0, 0, 0]
Front: 0 | Rear: 1 | Peek: 1
isEmpty: false | isFull: false
--------------------------------------------
Queue : [1, 2, 3, 0, 0]
Front: 0 | Rear: 2 | Peek: 1
isEmpty: false | isFull: false
--------------------------------------------
Queue : [1, 2, 3, 4, 0]
Front: 0 | Rear: 3 | Peek: 1
isEmpty: false | isFull: false
--------------------------------------------
Queue : [1, 2, 3, 4, 5]
Front: 0 | Rear: 4 | Peek: 1
isEmpty: false | isFull: true
--------------------------------------------

=====================

Dequeued: 1
Queue : [2, 3, 4, 5, 0]
Front: 0 | Rear: 3 | Peek: 2
isEmpty: false | isFull: false
--------------------------------------------
Dequeued: 2
Queue : [3, 4, 5, 0, 0]
Front: 0 | Rear: 2 | Peek: 3
isEmpty: false | isFull: false
--------------------------------------------
Dequeued: 3
Queue : [4, 5, 0, 0, 0]
Front: 0 | Rear: 1 | Peek: 4
isEmpty: false | isFull: false
--------------------------------------------
