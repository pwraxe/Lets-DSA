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
        rear = (rear + 1) % size
        queue[rear] = item
    }
    fun dequeue(): Int {
        if (isEmpty()) {
            println("Queue empty, can't delete")
            return -1
        }
        val value = queue[front]
        queue[front] = 0
        if (front == rear) {
            front = -1
            rear = -1
        } else {
            front = (front + 1) % size
        }
        return value
    }

    fun peek(): Int {
        if (isEmpty()) {
            println("Queue is empty")
            return -1
        }
        return queue[front]
    }
    private fun isEmpty(): Boolean = rear == -1 && front == -1
    private fun isFull(): Boolean = (rear+1) % size == front

    fun readAgain() {
        var f = front
        while (f != rear) {
            print("${queue[f]} ")
            f = (f+1) % size
        }
        println()
    }
    fun read() {
        readAgain()
        //println("Queue : ${queue.toTypedArray().contentToString()}")
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

        println("\n=====================\n")

        repeat(3) {
            enqueue(it+10)
            read()
        }
    }
}



Front: 0 | Rear: 0 | Peek: 1
isEmpty: false | isFull: false
--------------------------------------------
1 
Front: 0 | Rear: 1 | Peek: 1
isEmpty: false | isFull: false
--------------------------------------------
1 2 
Front: 0 | Rear: 2 | Peek: 1
isEmpty: false | isFull: false
--------------------------------------------
1 2 3 
Front: 0 | Rear: 3 | Peek: 1
isEmpty: false | isFull: false
--------------------------------------------
1 2 3 4 
Front: 0 | Rear: 4 | Peek: 1
isEmpty: false | isFull: true
--------------------------------------------

=====================

Dequeued: 1
2 3 4 
Front: 1 | Rear: 4 | Peek: 2
isEmpty: false | isFull: false
--------------------------------------------
Dequeued: 2
3 4 
Front: 2 | Rear: 4 | Peek: 3
isEmpty: false | isFull: false
--------------------------------------------
Dequeued: 3
4 
Front: 3 | Rear: 4 | Peek: 4
isEmpty: false | isFull: false
--------------------------------------------

=====================

4 5 
Front: 3 | Rear: 0 | Peek: 4
isEmpty: false | isFull: false
--------------------------------------------
4 5 10 
Front: 3 | Rear: 1 | Peek: 4
isEmpty: false | isFull: false
--------------------------------------------
4 5 10 11 
Front: 3 | Rear: 2 | Peek: 4
isEmpty: false | isFull: true
--------------------------------------------
