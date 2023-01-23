class LetsDoublyLL<T> {

    private inner class Node<T>(
        internal var previousNode: Node<T>? = null,
        internal var dataItem : T?,
        internal var nextNode: Node<T>?)

    private var headNode: Node<T>? = null
    private var tailNode: Node<T>? = null
    private var size: Int = 0

    //PASS
    fun add(item :T) {
        if(tailNode != null) {
            val tail = tailNode
            tailNode = Node<T>(tail?.previousNode, dataItem = item,null)
            tail?.nextNode = tailNode
            tailNode?.previousNode = tail
        } else {
            Node<T>(null,dataItem = item,null).apply {
                headNode = this
                tailNode = this
            }
        }
        size++
    }

    //PASS
    fun addFirst(item: T) {
        if(headNode == null) {
            Node<T>(null,item,null).apply {
                headNode = this
                tailNode = this
            }
        } else {
            val head = headNode
            headNode = Node<T>(null,item,head)
            headNode?.nextNode = head
            head?.previousNode = headNode
        }
        size++
    }

    //PASS
    fun addLast(item: T) {
        if(tailNode != null) {
            //not null
            val tail = tailNode
            tailNode = Node<T>(tail,item,null)
            tail?.nextNode = tailNode
            tailNode?.previousNode = tail
        } else {
            //null
            Node<T>(null,item,null).apply {
                headNode = this
                tailNode = this
            }
        }

        size++
    }

    //PASS
    fun addAtIndex(index: Int, item: T) {
        if(checkForIndex(index)) {
            when (index) {
                0 -> { addFirst(item) }
                size -> { addLast(item) }
                else -> {
                    var head = headNode
                    for (i in 0 until index-1) {
                        head = head?.nextNode
                    }
                    val newNode = Node<T>(head,item,head?.nextNode)
                    val nextToHead = head?.nextNode
                    head?.nextNode = newNode
                    newNode.previousNode = head

                    newNode.nextNode = nextToHead
                    nextToHead?.previousNode = newNode
                    size++
                }
            }
        }
    }

    //PASS
    fun addAll(vararg items : T) {
        val list = items as Array<Any>
        for (element in list) {
            add(element as T)
        }
    }

    //PASS
    fun readAll() : MutableList<Any> {
        val list = mutableListOf<Any>()
        if(size > 0) {
            var head = headNode
            do {
                list.add(head?.dataItem!!)
                head = head.nextNode
            }while (head != null)
        }
        return list
    }

    //PASS
    fun getSize() = size

    //PASS
    fun readFirst() : T? = headNode?.dataItem

    //PASS
    fun readLast() : T?  = tailNode?.dataItem

    //PASS
    fun readAt(index: Int) : T? {
        var item: T? = null
        if(checkForIndex(index)) {
            item = when(index) {
                0 -> { readFirst() }
                size -> { readLast() }
                else -> {
                    var head = headNode
                    for (i in 0..index-1) {
                        head = head?.nextNode
                    }
                    head?.dataItem
                }
            }
        }
        return item
    }

    //PASS
    fun updateFirst(item: T) { headNode?.dataItem = item }

    //PASS
    fun updateLast(item: T) { tailNode?.dataItem = item }

    //PASS
    fun updateAt(index: Int,item: T) {
        if(checkForIndex(index)) {
            when(index) {
                0 -> { updateFirst(item) }
                size ->{ updateLast(item) }
                else -> {
                    var head = headNode
                    for (i in 0 until index-1) {
                        head = head?.nextNode
                    }
                    head?.dataItem = item
                }
            }
        }
    }

    //PASS
    fun deleteFirst() {
        if (headNode != null) {
            headNode = headNode?.nextNode
            size--
        } else {
            headNode = null
            tailNode = null
            size = 0
        }
    }

    //PASS
    fun deleteLast() {
        if(tailNode != null) {
            tailNode = tailNode?.previousNode
            tailNode?.nextNode = null
            size--
        } else {
            headNode = null
            tailNode = null
            size = 0
        }
    }

    //PASS
    fun deleteAt(index: Int) {
        if(checkForIndex(index)) {
            when(index) {
                0 -> { deleteFirst() }
                size -> { deleteLast() }
                else -> {
                    var head = headNode
                    for (i in 0 until index-1) {
                        head = head?.nextNode
                    }
                    val prevNode = head?.previousNode
                    val nextNodeOfDelete = head?.nextNode
                    prevNode?.nextNode = nextNodeOfDelete
                    nextNodeOfDelete?.previousNode = prevNode
                    size--
                }
            }
        }
    }

    //PASS
    fun deleteAll() {
        headNode = null
        tailNode = null
        size = 0
    }

    private fun checkForIndex(index: Int) : Boolean = if(index < 0) throw IllegalArgumentException("Invalid Index : $index") else true
}

fun main() {

     LetsDoublyLL<Int>().apply {
         add(5)
         add(6)
         add(7)

         addFirst(4)
         addLast(8)

         addAtIndex(0,3)
         addAtIndex(2,66)
         addAtIndex(getSize(),9)

         addAll(10,11,12,13,14,15)

         updateFirst(33)
         updateLast(155)
         updateAt(6,88)

         deleteFirst()
         deleteLast()
         deleteAt(5)

         deleteAll()
         println(readAll().toTypedArray().contentToString())
     }
}
