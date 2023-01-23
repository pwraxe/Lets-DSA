import java.lang.Exception

class LetsCircularSLL<T> {

    private inner class Node<T>(
        internal var dataItem : T?,
        internal var nextNode: Node<T>?)

    private var headNode: Node<T>? = null
    private var tailNode: Node<T>? = null
    private var size: Int = 0

    //PASS
    fun add(item :T) {
        if(headNode != null) {
            val tail = tailNode
            tailNode = Node<T>(item,headNode)
            tail?.nextNode = tailNode
            tailNode?.nextNode = headNode
            size++
        } else createNewNode(item)
    }

    //PASS
    fun addFirst(item: T) {
        if(headNode != null) {
            val head = headNode
            headNode = Node<T>(item,head)
            headNode?.nextNode = head
            tailNode?.nextNode = headNode
            size++
        } else createNewNode(item)

    }

    //PASS
    fun addLast(item: T) {
        if(tailNode != null) {
            add(item)
        } else createNewNode(item)
    }

    //PASS
    private fun createNewNode(item: T) {
        Node<T>(item,null).apply {
            headNode = this
            tailNode = this
        }
        size++
    }

    //PASS
    fun addAtIndex(index: Int, item: T) {
        if(checkForIndex(index)) {
            when(index) {
                0 -> addFirst(item)
                size -> addLast(item)
                else -> {
                    var head = headNode
                    for (i in 0 until index-1) {
                        head = head?.nextNode
                    }
                    val nextNode = head?.nextNode
                    val newNode = Node<T>(item,head?.nextNode)
                    head?.nextNode = newNode
                    newNode?.nextNode = nextNode
                    size++
                }
            }
        }
    }

    //PASS
    fun addAll(vararg items : T) {
        val list = items as List<T>
        for (i in list.indices) {
            add(list[i])
        }
    }

    //PASS
    fun readAll(): MutableList<Any> {

        val list = mutableListOf<Any>()
        return if(size > 0 && headNode != null) {
            var head = headNode
            for (i in 0 until size * 2) {
                list.add(head?.dataItem as Any)
                head = head.nextNode
            }
            list
        } else list
    }

    //PASS
    fun getSize() = size

    //PASS
    fun readFirst() : T? = headNode?.dataItem

    //PASS
    fun readLast() : T? = tailNode?.dataItem

    //PASS
    fun readAt(index: Int) : T? {
        var data: T? = null
        if(checkForIndex(index)) {
            data = when(index) {
                0 -> readFirst()
                size -> readLast()
                else -> {
                    var head = headNode
                    for (i in 0 until index) {
                        head = head?.nextNode
                    }
                    head?.dataItem
                }
            }
        }
        return data
    }

    //PASS
    fun updateFirst(item: T) {
        if(headNode != null) headNode?.dataItem = item else createNewNode(item)
    }

    //PASS
    fun updateLast(item: T) {
        if(tailNode != null) tailNode?.dataItem = item else createNewNode(item)
    }

    //PASS
    fun updateAt(index: Int,item: T) {
        if(checkForIndex(index)) {
            when(index) {
                0 -> { updateFirst(item) }
                size -> { updateLast(item) }
                else -> {
                    var head = headNode
                    for (i in 0 until index) {
                        head = head?.nextNode
                    }
                    head?.dataItem = item
                }
            }
        }
    }

    //PASS
    fun deleteFirst() {
        if(headNode != null) {
            headNode = headNode?.nextNode
            tailNode?.nextNode = headNode
            size--
        } else println("No Head to Delete")
    }

    //PASS
    fun deleteLast() {
        if(tailNode != null) {
            var head = headNode
            for (i in 0 until size-1) {
                head = head?.nextNode
            }
            tailNode = head
            tailNode?.nextNode = headNode
            size--
        } else println("No Tail to Delete")
    }

    //PASS
    fun deleteAt(index: Int) {
        if(checkForIndex(index)) {
            when(index) {
                0 -> deleteFirst()
                size -> deleteLast()
                else -> {
                    var head = headNode
                    for (i in 0 until index-1) {
                        head = head?.nextNode
                    }

                    head?.nextNode = head?.nextNode?.nextNode
                    size--
                }
            }
        }
    }
    
    //PASS
    fun deleteAll() {
        headNode = null
        tailNode = null
        size--
    }

    private fun checkForIndex(index: Int) : Boolean = if(index < 0) throw IllegalArgumentException("Invalid Index : $index") else true
}

fun main() {
    LetsCircularSLL<Int>().apply {
        add(10)
        add(11)
        add(12)
        add(13)
        addFirst(9)
        addLast(14)
        addAtIndex(4,103)

        updateFirst(99)
        updateLast(144)
        updateAt(4,1333)
        println(readAll().toTypedArray().contentToString())
        println("${readFirst()} | ${readLast()} | ${readAt(4)}")
        println("DELETING... : ${readAll().toTypedArray().contentToString()}")
        deleteFirst()
        deleteLast()
        deleteAt(4)
        deleteAll()
        println("After Delete... : ${readAll().toTypedArray().contentToString()}")
    }
}
