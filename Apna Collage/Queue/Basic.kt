class StaticQueue(private val size:Int) {

    private val queue = IntArray(size)
    private var index: Int = -1

    fun enqueue(item:Int) {
        if (isFull()) {
            println("Queue full, can't insert")
            return
        }
        queue[++index] = item
    }
    fun dequeue(): Int {
        if (isEmpty()) {
            println("Queue empty, can't delete")
            return -1
        }
        val front = queue[0]
        for (i in 1 .. index) {
            queue[i-1] = queue[i]
        }
        queue[index--] = 0
        return front
    }

    fun peek(): Int {
        if (isEmpty()) {
            println("Queue is empty")
            return -1
        }
        return queue[0]
    }
    fun isEmpty(): Boolean = index == -1
    fun isFull(): Boolean = index == queue.lastIndex

    fun read() {
        println("[$index] = ${queue.toTypedArray().contentToString()}")
    }
}

fun main() {
    StaticQueue(5).apply {
        println("Peek: ${peek()} | isMT: ${isEmpty()} | isFull: ${isFull()}")
        repeat(5) {
            enqueue(it+1)
        }
        read()
        println("Peek: ${peek()} | isMT: ${isEmpty()} | isFull: ${isFull()}")
        println("-----------------------")
        println("Dequeued: ${dequeue()}")
        println("Peek: ${peek()} | isMT: ${isEmpty()} | isFull: ${isFull()}")
        read()
        dequeue()
        dequeue()
        dequeue()
        dequeue()
        dequeue()
        dequeue()
    }
}


Queue is empty
Peek: -1 | isMT: true | isFull: false
[4] = [1, 2, 3, 4, 5]
Peek: 1 | isMT: false | isFull: true
-----------------------
Dequeued: 1
Peek: 2 | isMT: false | isFull: false
[3] = [2, 3, 4, 5, 0]
Queue empty, can't delete
Queue empty, can't delete
