interface MyStack {
    fun push(item:Int)
    fun pop(): Int
    fun peek(): Int
    fun read()
    fun getSize(): Int
    fun isEmpty(): Boolean
    fun isNotEmpty(): Boolean
}
class StackByInBuiltFun: MyStack {
    private val list = mutableListOf<Int>()

    override fun push(item: Int) {
        list.add(item)
    }

    override fun pop(): Int = if (isNotEmpty()) list.removeLast() else -1

    override fun peek(): Int = if (isNotEmpty()) list.last() else -1
    override fun read() {
        for (index in getSize()-1 downTo 0) {
            println(list[index])
        }
    }

    override fun getSize(): Int = list.size

    override fun isEmpty(): Boolean = list.isEmpty()

    override fun isNotEmpty(): Boolean = list.isNotEmpty()

}
class StackByOwnCode: MyStack {
    private val list = mutableListOf<Int>()

    override fun push(item: Int) {
        list.add(item)
    }

    override fun pop(): Int {
        if (list.size == 0 || isEmpty()) return -1
        return list.removeLast()
    }

    override fun peek(): Int {
        if (isEmpty()) return -1
        return list.last()
    }

    override fun getSize(): Int = list.size

    override fun read() {
        print("[")
        for (index in getSize()-1 downTo 0) {
            print("${list[index]}, ")
        }
        println("]")
    }

    override fun isEmpty(): Boolean = getSize() == 0

    override fun isNotEmpty(): Boolean = getSize() > 0
}

class Node(val dataItem: Int,var next: Node? = null)
class StackByLinkedList : MyStack {
    private var headNode: Node? = null

    private var size: Int = 0

    override fun push(item: Int) {
        val node = Node(item)
        size++
        if (headNode == null) {
            headNode = node
            return
        }
        node.next = headNode
        headNode = node
    }

    override fun pop(): Int {
        if (headNode == null) {
            return -1
        }
        if (headNode?.next == null) {
            val value = headNode?.dataItem
            headNode = null
            size = 0
            return value ?: -1
        }
        val value = headNode?.dataItem
        headNode = headNode?.next
        size--
        return value ?: -1
    }

    override fun peek(): Int {
        if (headNode == null) return -1
        return headNode?.dataItem ?: -1
    }

    override fun read() {
        var node = headNode
        while (node != null) {
            print("-> ${node.dataItem}")
            node = node.next
        }
        println()
    }

    override fun getSize(): Int = size

    override fun isEmpty(): Boolean = headNode == null

    override fun isNotEmpty(): Boolean = headNode != null
}

fun main() {
    println("Stack Built By Inbuilt Functions ================================")
    StackByInBuiltFun().apply {

        println("isEmpty: ${isEmpty()} | isNotEmpty: ${isNotEmpty()} | Size: ${getSize()} | Peek: ${peek()}")
        (1..5).forEach {
            push(it)
        }
        read()
        println("isEmpty: ${isEmpty()} | isNotEmpty: ${isNotEmpty()} | Size: ${getSize()} | Peek: ${peek()}")

        (1..2).forEach {
            println("pop: ${pop()}")
        }
        println("isEmpty: ${isEmpty()} | isNotEmpty: ${isNotEmpty()} | Size: ${getSize()} | Peek: ${peek()}")
    }

    println("\nStack Built By Own Logic ================================")
    StackByOwnCode().apply {
        println("isEmpty: ${isEmpty()} | isNotEmpty: ${isNotEmpty()} | Size: ${getSize()} | Peek: ${peek()}")
        (1..10).forEach {
            push(it)
        }
        println("isEmpty: ${isEmpty()} | isNotEmpty: ${isNotEmpty()} | Size: ${getSize()} | Peek: ${peek()}")
        read()
        print("Popped: ")
        repeat(3) {
            print("-> ${pop()}")
        }
        println()
        read()
    }

    println("\nStack Built By LinkedList================================")
    StackByLinkedList().apply {
        println("isEmpty: ${isEmpty()} | isNotEmpty: ${isNotEmpty()} | Size: ${getSize()} | Peek: ${peek()}")
        (1..8).forEach {
            push(it)
        }
        println("isEmpty: ${isEmpty()} | isNotEmpty: ${isNotEmpty()} | Size: ${getSize()} | Peek: ${peek()}")
        read()
        repeat(3) {
            print("popped: ${pop()}, ")
        }
        println()
        read()
        println("isEmpty: ${isEmpty()} | isNotEmpty: ${isNotEmpty()} | Size: ${getSize()} | Peek: ${peek()}")

    }
}



Stack Built By Inbuilt Functions ================================
isEmpty: true | isNotEmpty: false | Size: 0 | Peek: -1
5
4
3
2
1
isEmpty: false | isNotEmpty: true | Size: 5 | Peek: 5
pop: 5
pop: 4
isEmpty: false | isNotEmpty: true | Size: 3 | Peek: 3

Stack Built By Own Logic ================================
isEmpty: true | isNotEmpty: false | Size: 0 | Peek: -1
isEmpty: false | isNotEmpty: true | Size: 10 | Peek: 10
[10, 9, 8, 7, 6, 5, 4, 3, 2, 1, ]
Popped: -> 10-> 9-> 8
[7, 6, 5, 4, 3, 2, 1, ]

Stack Built By LinkedList================================
isEmpty: true | isNotEmpty: false | Size: 0 | Peek: -1
isEmpty: false | isNotEmpty: true | Size: 8 | Peek: 8
-> 8-> 7-> 6-> 5-> 4-> 3-> 2-> 1
popped: 8, popped: 7, popped: 6, 
-> 5-> 4-> 3-> 2-> 1
isEmpty: false | isNotEmpty: true | Size: 5 | Peek: 5
