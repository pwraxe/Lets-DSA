class MyCircularQueue(val k: Int) {

    val queue = IntArray(k) { 0 }
    private var front = -1
    private var rear = -1

    fun enQueue(value: Int): Boolean {
        return if((rear+1) % k != front) {
            rear = (rear+1) % k
            queue[rear] = value
            if(front == -1) front = rear
            true
        } else false
    }

    fun deQueue(): Boolean {
        if(isEmpty()) return false
        queue[front] = 0
        if(front == rear) {
            front = -1
            rear = -1
        } else {
            front = (front +1) % k
        }
        return true
    }

    fun Front(): Int = if(front >= 0) queue[front] else -1
    fun Rear(): Int = if(rear >= 0) queue[rear] else -1

    fun isEmpty(): Boolean = front == -1 || rear == -1
    fun isFull(): Boolean = (rear + 1) % k == front

    fun read() {
        println("Reading : ${queue.toTypedArray().contentToString()}")
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * var obj = MyCircularQueue(k)
 * var param_1 = obj.enQueue(value)
 * var param_2 = obj.deQueue()
 * var param_3 = obj.Front()
 * var param_4 = obj.Rear()
 * var param_5 = obj.isEmpty()
 * var param_6 = obj.isFull()
 */
