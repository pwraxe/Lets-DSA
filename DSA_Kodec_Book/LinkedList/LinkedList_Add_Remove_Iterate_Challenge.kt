import java.util.*

class LetsLinkedList<T> : Iterable<T> {

    var dataItemList = mutableListOf<Any>()

    inner class Node<T>(var dataItem: T, var nextNode: Node<T>? = null) {
        override fun toString(): String {
            dataItemList.add(dataItem as Any)
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
    fun addFirst(value: T) : Node<T> {
        headNode = Node(value,headNode)
        if(tailNode == null) {
            tailNode = headNode
        }
        size++
        return this.headNode!!
    }

    //Time Complexity : O(1)
    fun addLast(value: T) : Node<T> {
        if(isEmpty()) {
            addFirst(value)
        } else{
            tailNode?.nextNode = Node(value)
            tailNode = tailNode?.nextNode
            size++
        }
        return this.tailNode!!
    }

    //Time Complexity : O(1)
    fun addAtIndex(index:Int, value: T) {
        if(index < getSize()) {
            val nodeAt = getNodeBeforeIndex(index)
            when {
                index == 0 -> addFirst(value)
                tailNode == nodeAt -> addLast(value)
                else -> {
                    val newNode = Node(value,nodeAt?.nextNode)
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
    private fun removeFirst() {
        if(headNode == null) {
            tailNode = null
            headNode.toString()
        } else {
            headNode = headNode?.nextNode
            size--
        }
    }

    //Time Complexity : O(1)
    private fun removeLast() {

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

    class LinkedListIterator<T>(private val list : LetsLinkedList<T>) : Iterator<T>{

        private var index = 0
        private var lastNode : LetsLinkedList<T>.Node<T>? = null

        override fun hasNext(): Boolean = index < list.size

        override fun next(): T {
            if(index >= list.size) throw IndexOutOfBoundsException("Index going more than size : $index")
            lastNode = if (index == 0) {
                list.getNodeBeforeIndex(0)
            } else {
                lastNode?.nextNode
            }
            index++
            return lastNode?.dataItem!!
        }
    }

    override fun iterator(): Iterator<T> {
        return LinkedListIterator(this)
    }

    //Challenge 1: Reverse LinkedList
    fun reverseLinkedList() {
        this.getNodeBeforeIndex(0)?.reverseList()
    }
    //Challenge 1 : Reverse LinkedList
    private fun<T> Node<T>.reverseList() {
        this.nextNode?.reverseList()
        if(this.nextNode != null) {
            print(" -> ")
        }
        print(this.dataItem.toString())
    }

    //Challenge 2 : Get Middle Node of LinkedList
    fun getMiddleNode() : Node<T>? {
        return if(getSize() > 0) {
            val middleIndex = getSize()/2
            getNodeBeforeIndex(middleIndex+1)
        } else {
            headNode.toString()
            null
        }
    }
}

fun main() {
    val list = LetsLinkedList<Int>()
    list.addFirst(3)
    list.addFirst(2)
    list.addFirst(1)
    list.addLast(4)
    list.addLast(5)
//    list.addLast(6)
//    list.addLast(7)

    for (item in list) {
        println("Element : $item")
    }

    println(list.toString())
    println(list.dataItemList)

    //Challenge 1
    list.reverseLinkedList()
    println()
    //Challenge 2
    println("Middle Node : ${list.getMiddleNode()?.dataItem}")
}
