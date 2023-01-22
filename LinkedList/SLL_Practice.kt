class LetsSinglyLL<T> {

    private inner class Node<T>(internal var dataItem : T?, internal var nextNode: Node<T>?)
    private var headNode: Node<T>? = null
    private var tailNode: Node<T>? = null
    private var size: Int = 0

    //PASS
    fun add(item :T) {

        Node<T>(dataItem = item,nextNode = null).apply {
            if(headNode == null) {
                headNode = this
                tailNode = this
            } else {
                val tail = tailNode
                tailNode = this
                tail?.nextNode = tailNode
            }
            size++
        }
    }

    //PASS
    fun addFirst(item: T) {
        if(headNode == null) {
            Node<T>(item,null).apply {
                headNode = this
                tailNode = this
            }
        } else {
            var head = headNode
            headNode = Node<T>(item,head)
            headNode?.nextNode = head
        }
        size++
    }

    //PASS
    fun addLast(item: T) { add(item) }

    //PASS
    fun addAtIndex(index: Int, item: T) {
        if(index < 0) throw IllegalArgumentException("Invalid Index : $index")
        when {
            index == 0 -> { addFirst(item) }
            index >= size -> addLast(item)
            else -> {
                //in between 1..size
                var head = headNode
                for (i in 0 until index-1) {
                    head = head?.nextNode
                }
                val nextNode = head?.nextNode
                val toAdd = Node<T>(item,nextNode)
                head?.nextNode = toAdd
                toAdd.nextNode = nextNode
                size++
            }
        }
    }

    //PASS
    fun addAll(vararg items : T) {
        val list = items.toList()
        for (item in list) {
            add(item)
        }
    }

    //PASS
    fun readFirst() : T? = headNode?.dataItem

    //PASS
    fun readLast() : T?  = tailNode?.dataItem

    //PASS
    fun getSize() = size

    //PASS
    fun readAll() : MutableList<Any> {

        val list = mutableListOf<Any>()
        var head = headNode
        if (head != null) {
            do {
                list.add(head?.dataItem!!)
                head = head.nextNode
            }while (head != null)
        } else list
        return list
    }

    //PASS
    fun readAt(index: Int) : T? {
        if(index < 0) throw IllegalArgumentException("Invalid Index : $index")
        return when (index) {
            0 -> readFirst()
            size -> readLast()
            else -> {
                var head = headNode
                for (i in 0 until index) {
                    head = head?.nextNode
                }
                return head?.dataItem
            }
        }
    }

    //PASS
    fun updateFirst(item: T) { headNode?.dataItem = item }

    //PASS
    fun updateLast(item: T) { tailNode?.dataItem = item }

    //PASS
    fun updateAt(index: Int,item: T) {
        if(index < 0) throw IllegalArgumentException("Invalid Index : $index")
        when(index) {
            0 -> updateFirst(item)
            size -> updateLast(item)
            else -> {
                var head = headNode
                for (i in 0 until index) {
                    head = head?.nextNode
                }
                head?.dataItem = item
            }
        }
    }

    fun deleteFirst() {
        if(headNode?.nextNode != null) {
            headNode = headNode?.nextNode
        } else {
            headNode = null
            tailNode = null
        }
        size--
    }
    fun deleteLast() {
        var head = headNode
        for (i in 0 until (size-2)) {
            head = head?.nextNode
        }
        println("HEAd : ${head?.dataItem}")
        tailNode = head
        tailNode?.nextNode = null
        size--
    }
    //PASS
    fun deleteAt(index: Int) {
        if(index < 0) throw IllegalArgumentException("Invalid Index : $index")
        when(index) {
            0 -> deleteFirst()
            size -> deleteLast()
            else -> {
                var head = headNode
                for (i in 0 until index-1) {
                    head = head?.nextNode
                }
                var nodeToDelete = head?.nextNode
                val nextNodeOfDeleteNode = nodeToDelete?.nextNode
                head?.nextNode = nextNodeOfDeleteNode
                size--
            }
        }
    }
    fun deleteAll() {
        headNode = null
        tailNode = null
        size = 0
    }
}

fun main() {
    LetsSinglyLL<Int> ().apply {
        add(10)
        add(11)
        add(14)
        add(15)
        addFirst(9)
        addLast(16)
        addAtIndex(0,8)
        addAtIndex(getSize(),17)
        addAtIndex(3,12)
        //addAll(10,11,12,13,14,15,16,17,18,19)

        println(readAll().toTypedArray().contentToString())
        println("FIRST : ${readFirst()} | LAST : ${readLast()}")
        println("Read 0 : ${readAt(0)} | 3 : ${readAt(3)} | ${getSize()} -> ${readAt(getSize())}")

        updateFirst(88)
        updateLast(177)
        updateAt(0,8800)
        updateAt(2,1000)
        updateAt(getSize(),1770)
        println("Updated : ${readAll().toTypedArray().contentToString()}")

        deleteFirst()
        deleteLast()
        deleteAt(0)
        deleteAt(getSize())
        deleteAt(1)
        println("DELETED : ${readAll().toTypedArray().contentToString()}")

        deleteAll()
        println("Delete All : ${readAll().toTypedArray().contentToString()}")

    }
}

//OUTPUT
[8, 9, 10, 12, 11, 14, 15, 16, 17]
FIRST : 8 | LAST : 17
Read 0 : 8 | 3 : 12 | 9 -> 17
Updated : [8800, 9, 1000, 12, 11, 14, 15, 16, 1770]
HEAd : 16
HEAd : 15
DELETED : [1000, 11, 14, 15]
Delete All : []
