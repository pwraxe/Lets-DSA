import java.util.LinkedList

//You also can use LinkedList for Queue
class IntQueue {
    private val queue = mutableListOf<Int>()

    fun offer(item: Int){
        queue.add(item)
    }
    fun poll(): Int = queue.removeFirstOrNull() ?: -1
    fun isEmpty(): Boolean = queue.isEmpty()
    fun peek() = queue.firstOrNull() ?: -1
    val size: Int
        get() = queue.size
}
class StackByTwoQueue {

    private val first = IntQueue()
    private val second = IntQueue()


    fun push(item: Int) {
        if (!first.isEmpty()) {
            first.offer(item)
        } else {
            second.offer(item)
        }
    }
    fun pop(): Int {
        var top = 0
        if (!first.isEmpty()) {
            while (!first.isEmpty()) {
                top = first.poll()
                if (first.isEmpty()) break
                second.offer(top)
            }
        } else {

            while (!second.isEmpty()) {
                top = second.poll()
                if (second.isEmpty()) break
                first.offer(top)
            }
        }
        return top
    }

    fun isEmpty() {
        println("isFirstEmpty: ${first.isEmpty()} | isSecondEmpty: ${second.isEmpty()}")
    }
    fun peek(): Int {
        var top = 0
        if (!first.isEmpty()) {
            while (!first.isEmpty()) {
                top = first.poll()
                second.offer(top)
            }
        } else {
            while (!second.isEmpty()) {
                top = second.poll()
                first.offer(top)
            }
        }
        return top
    }

    fun read() {

        if (!first.isEmpty()) {
            while (!first.isEmpty()) {
                print("${first.peek()}, ")
                second.offer(first.poll())
            }
        } else {
            while (!second.isEmpty()) {
                print("${second.peek()}, ")
                first.offer(second.poll())
            }
        }

        println("\nPeek: ${peek()}")
        isEmpty()
    }
}

fun main() {

    StackByTwoQueue().apply {
        repeat(5) {
            push(it+1)
            read()
        }

        println("====================")
        repeat(3) {
            println("Pop: ${pop()}")
            read()
        }
    }
}


1, 
Peek: 1
isFirstEmpty: true | isSecondEmpty: false
1, 2, 
Peek: 2
isFirstEmpty: true | isSecondEmpty: false
1, 2, 3, 
Peek: 3
isFirstEmpty: true | isSecondEmpty: false
1, 2, 3, 4, 
Peek: 4
isFirstEmpty: true | isSecondEmpty: false
1, 2, 3, 4, 5, 
Peek: 5
isFirstEmpty: true | isSecondEmpty: false
====================
Pop: 5
1, 2, 3, 4, 
Peek: 4
isFirstEmpty: false | isSecondEmpty: true
Pop: 4
1, 2, 3, 
Peek: 3
isFirstEmpty: true | isSecondEmpty: false
Pop: 3
1, 2, 
Peek: 2
isFirstEmpty: false | isSecondEmpty: true
