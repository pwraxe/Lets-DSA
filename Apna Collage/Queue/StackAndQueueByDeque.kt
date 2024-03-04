class StackByDeque {

    private val deque = ArrayDeque<Int>()
    fun push(item:Int) {
        deque.addFirst(item)
        //deque.addLast(item)
    }
    fun pop(): Int {
        return deque.removeFirstOrNull() ?: -1
        //deque.removeLastOrNull() ?: -1
    }
    fun peek(): Int {
        return deque.firstOrNull() ?: -1
        //return deque.lastOrNull() ?: -1
    }
    fun isEmpty(): Boolean {
        return deque.isEmpty()
    }

    fun read() {
        println("Peek: ${peek()} | isEmpty: ${isEmpty()} | ${deque.toTypedArray().contentToString()}")
    }
}

class QueueByDeque {
    private val deque = ArrayDeque<Int>()
    fun offer(item:Int) {
        deque.addLast(item)
        //deque.addFirst(item)
    }
    fun poll(): Int {
        return deque.removeFirstOrNull() ?: -1
        //return deque.removeLastOrNull() ?: -1
    }
    fun peek(): Int {
        return deque.firstOrNull() ?: -1
        //return deque.lastOrNull() ?: -1
    }
    fun isEmpty(): Boolean {
        return deque.isEmpty()
    }
    fun read() {
        println("Peek: ${peek()} | isEmpty: ${isEmpty()} | ${deque.toTypedArray().contentToString()}")
    }
}

fun main() {
    StackByDeque().apply {
        repeat(5) {
            push(it+1)
        }
        read()
        repeat(2) {
            pop()
        }
        read()
    }
    println("================================================")
    QueueByDeque().apply {
        repeat(5) {
            offer(it+1)
        }
        read()
        repeat(2) {
            poll()
        }
        read()
    }
}


Peek: 5 | isEmpty: false | [5, 4, 3, 2, 1]
Peek: 3 | isEmpty: false | [3, 2, 1]
================================================
Peek: 1 | isEmpty: false | [1, 2, 3, 4, 5]
Peek: 3 | isEmpty: false | [3, 4, 5]
