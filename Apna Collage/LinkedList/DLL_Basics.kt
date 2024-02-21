class Node(var dataItem: Int, var prev: Node? = null, var next: Node? = null)

class LinkedList {

    private var headNode: Node? = null
    private var tailNode: Node? = null
    private var _size: Int = 0
    val size:Int get() = _size

    fun readAsc() {
        var node = headNode
        while (node != null) {
            print(" -> ${node.dataItem}")
            node = node.next
        }
        println()
    }
    fun readDesc() {
        var node = tailNode
        while (node != null) {
            print(" -> ${node.dataItem}")
            node = node.prev
        }
        println()
    }
    fun addFirst(dataItem: Int) {
        val node = Node(dataItem)
        _size++
        if (headNode == null) {
            headNode = node
            tailNode = node
            return
        }
        node.next = headNode
        headNode?.prev = node
        headNode = node
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
        node.prev = tailNode
        tailNode = node
    }

    fun removeFirst(): Int {
        if (headNode?.next == null) {
            val temp = headNode?.dataItem
            headNode = null
            tailNode = null
            _size = 0
            return temp ?: -1
        }
        val temp = headNode?.dataItem
        headNode = headNode?.next
        headNode?.prev = null
        _size--
        return temp ?: -1
    }
    fun removeLast(): Int {
        if (tailNode?.prev == null) {
            val temp = tailNode?.dataItem
            headNode = null
            tailNode = null
            _size = 0
            return temp ?: -1
        }

        val temp = tailNode?.dataItem
        tailNode = tailNode?.prev
        tailNode?.next = null
        _size--
        return temp ?: -1
    }

    fun reverse() {
        var prev: Node? = null
        var current = headNode
        while (current != null) {
            val next = current?.next

            current.next = prev
            current.prev = next

            prev = current
            current = next
        }

        headNode = prev
    }

}

fun main() {
    LinkedList().apply {
        addFirst(50)
        addFirst(40)
        addFirst(30)
        addLast(60)
        addLast(70)
        addLast(80)
        readAsc()
        readDesc()
        println("================================ Remove First")
        removeFirst()
        removeLast()
        readAsc()

        reverse()
        readAsc()
    }
}









 -> 30 -> 40 -> 50 -> 60 -> 70 -> 80
 -> 80 -> 70 -> 60 -> 50 -> 40 -> 30
================================ Remove First
 -> 40 -> 50 -> 60 -> 70
 -> 70 -> 60 -> 50 -> 40
