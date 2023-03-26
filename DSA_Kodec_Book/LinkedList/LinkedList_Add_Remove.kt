class LetsLinkedList<T> {

    inner class Node<T>(var dataItem: T, var nextNode: Node<T>? = null) {
        override fun toString(): String {
            return if(nextNode != null) {
                //${nextNode?.toString()} -> I forgot toString() always here
                "$dataItem -> ${nextNode?.toString()}"
            } else {
                "$dataItem"
            }
        }
    }

    private var headNode: Node<T>? = null
    private var tailNode : Node<T>? = null
    private var size: Int = 0

    override fun toString(): String {
        return if(headNode == null) "List is Empty" else headNode.toString()
    }

    private fun getSize() = size
    private fun isEmpty() = size == 0 || headNode == null

    //Time Complexity : O(1)
    fun addFirst(value: T) : LetsLinkedList<T> {
        headNode = Node<T>(value,headNode)
        if(tailNode == null) {
            tailNode = headNode
        }
        size++
        return this
    }

    //Time Complexity : O(1)
    fun addLast(value: T) : LetsLinkedList<T> {
        if(isEmpty()) {
            addFirst(value)
        } else{
            tailNode?.nextNode = Node<T>(value)
            tailNode = tailNode?.nextNode
            size++
        }
        return this
    }

    //Time Complexity : O(1)
    fun addAtIndex(index:Int, value: T) {
        if(index < getSize()) {
            val nodeAt = getNodeBeforeIndex(index)
            when {
                index == 0 -> addFirst(value)
                tailNode == nodeAt -> addLast(value)
                else -> {
                    val newNode = Node<T>(value,nodeAt?.nextNode)
                    nodeAt?.nextNode = newNode
                    size++
                }
            }
        } else {
            println("Out Of Scope Index")
        }
    }

    //Time Complexity : O(i) whereAs, 'i' is index which need to search to return
    //Also refer as O(n), Total 'n' element need to traverse to get node
    private fun getNodeBeforeIndex(index: Int) : Node<T>? {
        var currentNode = headNode
        var currentIndex = 0
        if(index > 0) {
            while (currentNode != null && currentIndex < index-1) {
                currentNode = currentNode.nextNode
                currentIndex++
            }
        }
        return currentNode
    }

    //Time Complexity : O(1)
    fun removeFirst() {
        if(headNode == null) {
            tailNode = null
            headNode.toString()
        } else {
            val valueToBeRemove = headNode?.dataItem
            headNode = headNode?.nextNode
            size--
        }
    }

    //Time Complexity : O(1)
    fun removeLast() {

        if(tailNode != null) {
            when {
                getSize() == 0 -> headNode.toString()
                getSize() == 1 -> {
                    headNode = null
                    tailNode = null
                    size = 0
                }
                else -> {
                    val nodeBeforeLast = getNodeBeforeIndex(getSize()-1)
                    tailNode = nodeBeforeLast
                    tailNode?.nextNode = null
                    size--
                }
            }
        } else tailNode.toString()
    }

    //Time Complexity : O(1)
    fun removeAt(index: Int) {
        val nodeAt = getNodeBeforeIndex(index)
        when {
            index == 0 -> removeFirst()
            nodeAt == tailNode -> removeLast()
            else -> {
                val nodeToRemove = nodeAt?.nextNode
                nodeAt?.nextNode = nodeToRemove?.nextNode
                size--
            }
        }
    }
}

fun main() {
    val list = LetsLinkedList<Int>()
        .addFirst(3)
        .addFirst(2)
        .addFirst(1)
        .addLast(4)
        .addLast(5)
        .addLast(6)
    list.addAtIndex(3,30)

    list.removeFirst()
    list.removeLast()

    list.removeAt(2)

    println(list.toString())
}
