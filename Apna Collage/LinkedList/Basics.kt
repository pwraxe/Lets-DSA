data class Node(val dataItem:Int, var nextNode: Node? = null)

class Solution {
    private var headNode: Node? = null
    private var tailNode: Node? = null
    private var size: Int = 0

    fun read() {
        if (headNode == null) {
            println("Empty")
            return
        }
        var node = headNode
        while (node != null) {
            print("-> ${node.dataItem}")
            node = node.nextNode
        }
        println("\nSize: $size")
    }

    fun addFirst(data:Int) {
        val newNode = Node(data)
        if (headNode == null) {
            headNode = newNode
            tailNode = newNode
            size++
            return
        }
        newNode.nextNode = headNode
        headNode = newNode
        size++
    }
    fun addAt(index: Int, data: Int) {
        if (index < 0 || index > size) {
            println("OutOfIndexException")
            return
        }
        when (index) {
            0 -> {
                addFirst(data)
            }
            size -> {
                addLast(data)
            }
            else -> {
                var node = headNode
                var i = 0
                while (i++ < index-1) node = node?.nextNode
                val newNode = Node(data, node?.nextNode)
                node?.nextNode = newNode
                size++
            }
        }
    }
    fun addLast(data: Int) {
        val node = Node(data)
        if (tailNode == null) {
            headNode = node
            tailNode = node
            size++
            return
        }
        tailNode?.nextNode = node
        tailNode = node
        size++
    }

    fun removeFirst(): Int {
        if (headNode == null) return -1
        if (headNode?.nextNode == null) {
            headNode = null
            tailNode = null
            size = 0
            return -1
        }
        val removedValue = headNode?.dataItem
        headNode = headNode?.nextNode
        size--
        return removedValue ?: -1
    }
    fun removeLast(): Int {
        if (tailNode == null) return -1
        if (headNode?.nextNode == null) {
            headNode = null
            tailNode = null
            size = 0
            return -1
        }
        var node = headNode
        while (node?.nextNode != tailNode) {
            node = node?.nextNode
        }
        val removed = tailNode?.dataItem
        node?.nextNode = null
        tailNode = node
        size--
        return removed ?: -1
    }
    fun removeNthFromLast(n:Int): Int {
        if (n == size) {
            return removeFirst()
        }
        val prevIndex = size - n
        var node = headNode
        var i = 0
        while (i++ < prevIndex-1) {
            node = node?.nextNode
        }

        val removed = node?.nextNode?.dataItem
        node?.nextNode = node?.nextNode?.nextNode
        size--
        return removed ?: -1
    }

    fun searchIteratively(key: Int): Int {
        var node = headNode
        var index = 0
        while (node != null) {
            if (node.dataItem == key) return index
            index++
            node = node.nextNode
        }
        return -1
    }
    private fun recursiveSearch(index: Int, key: Int, node: Node?): Int {
        node ?: return -1
        if (node.dataItem == key) return index
        return recursiveSearch(index+1, key, node.nextNode)
    }
    fun searchRecursively(key: Int): Int {
        return recursiveSearch(0,key, headNode)
    }

    fun reverseIteratively() {
        var current = headNode
        var prev: Node? = null
        while (current != null) {
            val next = current.nextNode
            current.nextNode = prev
            prev = current
            current = next
        }
        headNode = prev
    }
    private fun reverseRec(node: Node?): Node? {
        return if (node?.nextNode == null) node else {
            reverseRec(node.nextNode).also {
                node.nextNode?.nextNode = node
                node.nextNode = null
            }
        }
    }
    fun reverseRecursively() {
        headNode = reverseRec(headNode)
    }

    private fun getMidNode(): Node? {
        var slow = headNode
        var fast = headNode
        while (fast?.nextNode != null) {
            slow = slow?.nextNode
            fast = fast.nextNode?.nextNode
        }
        return slow
    }
    fun isPalindrome(): Boolean {
        //Step1: Find Middle Node
        val midNode = getMidNode()

        //Step2: Reverse Second Half
        var prev: Node? = null
        var current = midNode

        while (current != null) {
            val next = current.nextNode
            current.nextNode = prev
            prev = current
            current = next
        }

        //Check Left and Right
        var left = headNode
        var right = prev
        while (right != null) {
            if (left?.dataItem != right.dataItem) {
                return false
            }
            left = left.nextNode
            right = right.nextNode
        }
        return true
    }
}

fun main() {
    Solution().apply {
        (1..10).forEach {
            when(it) {
                in 1..3 -> addFirst(it)
                in 4..6 -> addAt(it%5, it)
                else -> addLast(it)
            }
        }
        read()
        println("------------------------------------")

        println("First was: ${removeFirst()}")
        read()
        println("------------------------------------")

        println("Last was: ${removeLast()}")
        read()
        println("------------------------------------")

        val index = searchIteratively(10)
        if (index >= 0) {
            println("Found at index $index")
        } else {
            println("not found")
        }

        val index2 = searchRecursively(10)
        if (index2 >= 0) {
            println("Found at index $index")
        } else {
            println("not found")
        }

        println("======================================")
        reverseIteratively()
        read()
        reverseRecursively()
        read()

        println("------------------------------------")

        removeNthFromLast(4)
        read()

        println("------------------------------------")

    }
    println("------0---------0--------0-------")
    Solution().apply {

        addLast(1)
        addLast(2)
        addLast(3)
        addLast(2)
        addLast(1)
       
        println(isPalindrome())
    }
}

//======================================================================
OutOfIndexException
-> 5-> 6-> 3-> 2-> 1-> 7-> 8-> 9-> 10
Size: 9
------------------------------------
First was: 5
-> 6-> 3-> 2-> 1-> 7-> 8-> 9-> 10
Size: 8
------------------------------------
Last was: 10
-> 6-> 3-> 2-> 1-> 7-> 8-> 9
Size: 7
------------------------------------
not found
not found
======================================
-> 9-> 8-> 7-> 1-> 2-> 3-> 6
Size: 7
-> 6-> 3-> 2-> 1-> 7-> 8-> 9
Size: 7
------------------------------------
-> 6-> 3-> 2-> 7-> 8-> 9
Size: 6
------------------------------------
------0---------0--------0-------
false

