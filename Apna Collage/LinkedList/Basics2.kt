class Node(var dataItem: Int, var next: Node? = null)

class LinkedList {

    private var headNode: Node? = null
    private var tailNode: Node? = null
    private var _size: Int = 0
    val size:Int get() = _size

    fun addFirst(dataItem: Int) {
        val node = Node(dataItem)
        _size++
        if (headNode == null) {
            headNode = node
            tailNode = node
            return
        }
        node.next = headNode
        headNode = node
    }
    fun addAt(index: Int, dataItem: Int) {
        if (index < 0 || index > _size) {
            println("InvalidIndexException")
            return
        }
        when(index) {
            0 -> addFirst(dataItem)
            _size -> addLast(dataItem)
            else -> {
                var prevIndex = 0
                var node = headNode
                while (prevIndex < index-1) {
                    node = node?.next
                    prevIndex++
                }

                val new = Node(dataItem,node?.next)
                node?.next = new
                _size++
            }
        }
    }
    fun addLast(dataItem: Int) {
        val node = Node(dataItem)
        _size++
        if (tailNode == null) {
            headNode = node
            tailNode = node
            return
        }

        tailNode?.next = node
        tailNode = node
    }

    fun removeFirst(): Int {
        if (headNode == null || headNode?.next == null) {
            headNode = null
            tailNode = null
            _size = 0
            return -1
        }
        val value = headNode?.dataItem
        headNode = headNode?.next
        _size--
        return value ?: -1
    }
    fun removeAt(index: Int): Int {
        if (index < 0 || index > _size) {
            println("InvalidIndexException")
            return -1
        }

        return when(index) {
            0 -> removeFirst()
            _size -> removeLast()
            else -> {
                var prev = 0
                var node = headNode
                while (prev < index-1) {
                    node = node?.next
                    prev++
                }
                val value = node?.next?.dataItem
                node?.next = node?.next?.next
                value ?: -1
            }
        }
    }
    fun removeLast(): Int {
        if (headNode == null || headNode?.next == null) {
            headNode = null
            tailNode = null
            _size--
            return -1
        }

        var node = headNode
        while (node?.next != tailNode) {
            node = node?.next
        }
        val value = tailNode?.dataItem
        node?.next = null
        tailNode = node
        _size--
        return value ?: -1
    }
    fun removeNthNodeFromLast() {}

    private fun recRead(node: Node?) {
        node ?: run {
            println()
            return
        }
        print("-> ${node.dataItem} ")
        recRead(node.next)
    }
    fun readRecursively() {
        recRead(headNode)
    }
    fun readIteratively() {
        var node = headNode
        while (node != null) {
            print("-> ${node.dataItem} ")
            node = node.next
        }
        println()
    }

    private fun recSearch(node: Node?, key:Int,index: Int): Int {
        node ?: return -1
        if (node.dataItem == key) return index
        return recSearch(node.next, key,index+1)
    }
    fun searchRecursively(key: Int): Int {
        return recSearch(headNode,key,0)
    }
    fun searchIteratively(key: Int):Int {
        var node = headNode
        var index = 0
        while (node != null) {
            if (node.dataItem == key) {
                return index
            }
            index++
            node = node.next
        }
        return -1
    }

    private fun recRev(node: Node?):Node? {
        return if (node?.next == null) node else {
            recRev(node.next).also {
                node.next?.next = node
                node.next = null
            }
        }
    }
    fun reversedRecursively() {
        headNode = recRev(headNode)
    }
    fun reversedIteratively() {
        var prev : Node? = null
        var current = headNode
        while (current != null) {
            val next = current.next
            current.next = prev
            prev = current
            current = next
        }
        headNode = prev
    }

    private fun getMidNode(): Node? {
        var slow = headNode
        var fast = headNode
        while (fast?.next != null) {
            slow = slow?.next
            fast = fast.next?.next
        }
        return slow
    }
    fun isPalindrome(): Boolean {
        //Step 1: Find Mid Node
        val midNode = getMidNode()

        //Rev Second half
        var prev: Node? = null
        var current = midNode
        while (current != null) {
            val next = current.next
            current.next = prev
            prev = current
            current = next
        }

        //Compare
        var left = headNode
        var right = prev
        while (right != null) {
            if (left?.dataItem != right.dataItem) {
                return false
            }
            left = left.next
            right = right.next
        }
        return true
    }
}

fun main() {
    LinkedList().apply {

        (50 downTo 10 step 10).forEach {
            addFirst(it)
        }

        addLast(60)

        addAt(0,9) //addFirst
        addAt(3,25)//addMiddle
        addAt(size,70)  //addLast
        readIteratively()

        removeFirst()
        removeLast()
        removeAt(2)
        readIteratively()
        readRecursively()

        println(searchIteratively(50))
        println(searchRecursively(50))

        println("==============================")
        reversedIteratively()
        readIteratively()

        reversedRecursively()
        readRecursively()

        println(isPalindrome())
    }

    println("===============New Object============")
    LinkedList().apply {
        addFirst(1)
        addFirst(2)
        addFirst(3)
        addFirst(2)
        addFirst(1)
        readIteratively()
        println(isPalindrome())
    }
}




-> 9 -> 10 -> 20 -> 25 -> 30 -> 40 -> 50 -> 60 -> 70 
-> 10 -> 20 -> 30 -> 40 -> 50 -> 60 
-> 10 -> 20 -> 30 -> 40 -> 50 -> 60 
4
4
==============================
-> 60 -> 50 -> 40 -> 30 -> 20 -> 10 
-> 10 -> 20 -> 30 -> 40 -> 50 -> 60 
false
===============New Object============
-> 1 -> 2 -> 3 -> 2 -> 1 
true
