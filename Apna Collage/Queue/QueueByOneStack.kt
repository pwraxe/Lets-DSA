import java.util.Stack

class QueueByOneStack {
    private val stack = Stack<Int>()
    private fun pushAtBottom(item: Int) {
        if (stack.isEmpty()) {
            stack.push(item)
            return
        }
        val top = stack.pop()
        pushAtBottom(item)
        stack.push(top)
    }
    fun enqueue(item: Int) {
        pushAtBottom(item)
    }

    fun dequeue():Int {
        if (stack.isEmpty()) return -1
        return stack.pop()
    }

    fun peek(): Int {
        if (isEmpty()) return -1
        return stack.peek()
    }

    fun isEmpty(): Boolean = stack.isEmpty()

    fun read() {
        if (stack.isEmpty()) {
            println()
            return
        }
        val top = stack.pop()
        print("$top ")
        read()

        stack.push(top)
    }
}

fun main() {
    QueueByOneStack().apply {
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
