data class Node(val item:Int, var next: Node? = null)
class StaticQueueByLL {

    private var headNode: Node? = null
    private var tailNode: Node? = null
    private var size: Int = 0

    fun enqueue(item: Int) {
        val node = Node(item)
        size++
        if (headNode == null) {
            headNode = node
            tailNode = node
            return
        }
        tailNode?.next = node
        tailNode = node
    }
    fun dequeue(): Int {
        if (headNode == null) {
            return -1
        }
        val value = headNode?.item ?: -1
        size--
        if (headNode?.next == null || headNode == tailNode) {
            headNode = null
            tailNode = null
            size = 0
            return value
        }
        headNode = headNode?.next
        return value
    }

    fun peek(): Int {
        return headNode?.item ?: -1
    }
    fun isEmpty(): Boolean = headNode == null
    fun getSize(): Int = size

    fun read() {

        var node = headNode
        while (node != null) {
            print("${node.item} ")
            node = node.next
        }
        println("\nPeek: ${peek()} | isEmpty: ${isEmpty()} | Size: $size")
    }
}

fun main() {
    StaticQueueByLL().apply {

        repeat(5) {
            enqueue(it+1)
            read()
        }

        println("=============================")

        repeat(5) {
            println("Dequeued: ${dequeue()}")
            read()
        }
    }
}



1 
Peek: 1 | isEmpty: false | Size: 1
1 2 
Peek: 1 | isEmpty: false | Size: 2
1 2 3 
Peek: 1 | isEmpty: false | Size: 3
1 2 3 4 
Peek: 1 | isEmpty: false | Size: 4
1 2 3 4 5 
Peek: 1 | isEmpty: false | Size: 5
=============================
Dequeued: 1
2 3 4 5 
Peek: 2 | isEmpty: false | Size: 4
Dequeued: 2
3 4 5 
Peek: 3 | isEmpty: false | Size: 3
Dequeued: 3
4 5 
Peek: 4 | isEmpty: false | Size: 2
Dequeued: 4
5 
Peek: 5 | isEmpty: false | Size: 1
Dequeued: 5

Peek: -1 | isEmpty: true | Size: 0
