data class Node(val item: Int, var next: Node? = null)
class LinkedList {

    private var headNode: Node? = null
    private var tailNode: Node? = null
    private var size: Int = 0

    fun read() {
        println("Reading Linked List")
        var node = headNode
        while (node != null) {
            print("${node.item} -> ")
            node = node.next
        }
        println("\b\b\b\b \nSize: $size")
    }

    fun addFirst(item: Int) {
        val node = Node(item)
        size++
        if (headNode == null) {
            headNode = node
            tailNode = node
            return
        }

        node.next = headNode
        headNode = node
    }
    fun addAt(index:Int, item: Int) {
        if (index < 0 || index > size) return
        if (index == 0) {
            addFirst(item)
            return
        }

        if (index == size) {
            addLast(item)
            return
        }

        var node = headNode
        for (i in 0 ..< index-1) {
            node = node?.next
        }
        val new = Node(item,node?.next)
        node?.next = new
        size++
    }
    fun addLast(item: Int) {
        val node = Node(item)
        size++
        if (tailNode == null) {
            headNode = node
            tailNode = node
            return
        }
        tailNode?.next = node
        tailNode = node
    }
    fun formCycle() {
        tailNode?.next = headNode?.next
    }
    fun removeFirst(): Int {
        size--
        if (headNode?.next == null) {
            val item = headNode?.item
            headNode = null
            tailNode = null
            return item!!
        }
        val data = headNode?.next?.item ?: -1
        headNode = headNode?.next
        return data
    }
    fun removeLast(): Int {
        size--
        if (headNode?.next == null) {
            val item = headNode?.item!!
            headNode = null
            tailNode = null
            return item
        }
        var node = headNode
        while (node?.next != tailNode) {
            node = node?.next
        }
        val item = tailNode?.item!!
        node?.next = null
        tailNode = node
        return item
    }
    fun removeNthFromEnd(n:Int) {

        if (n == size) {
            removeFirst()
            return
        }

        var index = 1
        var toIndex = size - n
        var node = headNode
        while (index < toIndex) {
            node = node?.next
            index++
        }
        node?.next = node?.next?.next
    }

    fun searchItemIteratively(item:Int): Int {
        if (headNode == null) return -1
        var node = headNode
        var index = 0
        while (node != null) {
            if (node.item == item) return index
            index++
            node = node.next
        }

        return -1
    }
    private fun searchRec(node: Node?, item: Int, index:Int): Int {
        node ?: return -1
        if (node.item == item) return index
        return searchRec(node?.next,item, index+1)
    }
    fun searchItemRecursively(item: Int): Int {
        return searchRec(headNode,item,0)
    }

    fun revLinkedList() {
        var node = headNode
        var prev : Node? = null

        while (node != null) {
            val next = node.next
            node.next = prev
            prev = node
            node = next
        }

        println("Reversed LinkedList")
        node = prev
        while (node != null) {
            print("${node.item} -> ")
            node = node.next
        }
        println("\b\b\b\b")
    }

    //================ADV======================
    fun isPalindrome(): Boolean {
        //split list
        var fast = headNode
        var slow = headNode

        while (fast?.next != null) {
            slow = slow?.next
            fast = fast.next?.next
        }
        fast = slow?.next
        slow?.next = null

        slow = headNode

        //rev second half
        var prev: Node? = null
        var curr = fast
        while (curr != null) {
            val next = curr.next
            curr.next = prev
            prev = curr
            curr = next
        }

        //iterate
        while (prev != null) {
            if (slow?.item != prev.item) return false
            slow = slow.next
            prev = prev.next
        }
        return true
    }
    fun detectCycle():Boolean {
        var slow = headNode
        var fast = headNode

        while (fast?.next != null) {
            slow = slow?.next
            fast = fast.next?.next
            if (fast == slow) return true
        }
        return false

    }
    fun removeCycle() {
        var slow = headNode
        var fast = headNode
        while (fast?.next != slow) {
            slow = slow?.next
            fast = fast?.next?.next
        }
        fast?.next = null
    }

}

fun main() {
    LinkedList().apply {
        addFirst(30)
        addFirst(25)
        addLast(35)
        addLast(40)
        addAt(2,31)
        addAt(0,24)
        addAt(6,41)

        removeFirst()
        removeLast()

        read()
        println()
        println("Index of 35: ${searchItemIteratively(35)}")
        println("Index of 30: ${searchItemRecursively(30)}")

        println()
        removeNthFromEnd(2)
        read()

        println()
        revLinkedList()
    }

    println("================================")

    LinkedList().apply {
        addLast(1)
        addLast(2)
        addLast(3)
        addLast(2)
        addLast(1)
        read()
        println("is List has Cycle: ${detectCycle()}")
        formCycle()
        println("is List has Cycle: ${detectCycle()}")
        removeCycle()
        println("is List has Cycle: ${detectCycle()}")


    }

    println("================================")

    LinkedList().apply {
        addLast(1)
        addLast(2)
        addLast(3)
        addLast(4)
        addLast(5)
        addLast(6)

        println("Is Palindrome : ${isPalindrome()}")
    }
}


//=======================================================

Reading Linked List
25 -> 30 -> 31 -> 35 -> 40 
Size: 5

Index of 35: 3
Index of 30: 1

Reading Linked List
25 -> 30 -> 31 -> 40 
Size: 5

Reversed LinkedList
40 -> 31 -> 30 -> 25
================================
Reading Linked List
1 -> 2 -> 3 -> 2 -> 1 
Size: 5
is List has Cycle: false
is List has Cycle: true
is List has Cycle: false
================================
Is Palindrome : false
