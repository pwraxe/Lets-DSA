import java.util.Stack

class QueueByTwoStack {

    private val first = Stack<Int>()
    private val second = Stack<Int>()
    private var peek: Int = -1

    fun enqueue(item: Int) {
        if (first.isEmpty()) {
            peek = item
        }
        first.push(item)
    }

    fun dequeue(): Int {
        if (isEmpty()) {
            return -1
        }

        while (first.isNotEmpty()) {
            second.push(first.pop())
        }
        val value = second.pop()
        peek = second.peek()
        while (second.isNotEmpty()) {
            first.push(second.pop())
        }
        return value
    }

    fun isEmpty(): Boolean = first.isEmpty()
    fun peek(): Int = peek
    fun read() {
        if (first.isEmpty()) {
            return
        }
        val top = first.pop()
        read()
        print("$top ")
        first.push(top)
    }
}

fun main() {
    QueueByTwoStack().apply {
        repeat(5){
            enqueue(it+1)
        }
        read()

        repeat(3) {
            println("\nDequeued: ${dequeue()} | Peek: ${peek()} | isEmpty: ${isEmpty()}")
            read()
            println("\n===========")
        }
    }
}


1 2 3 4 5 
Dequeued: 1 | Peek: 2 | isEmpty: false
2 3 4 5 
===========

Dequeued: 2 | Peek: 3 | isEmpty: false
3 4 5 
===========

Dequeued: 3 | Peek: 4 | isEmpty: false
4 5 
===========
