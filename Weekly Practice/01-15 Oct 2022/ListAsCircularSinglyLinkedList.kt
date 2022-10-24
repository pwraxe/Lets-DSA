//TODO --> 5. Circular Singly Linked List

class ListAsCircularLinkedList<T> {

     inner class Node<T>(
         internal var dataItem: T?,
         internal var nextNode: Node<T>?
     )

    private var headNode: Node<T>? = null
    private var tailNode: Node<T>? = null
    private var size : Int = 0

    //CREATE
    fun addFirst(item:T) {
        if(headNode == null) {
            Node<T>(item,null).apply {
                headNode = this
                tailNode = this
                size++
            }
        } else {
            val head = headNode
            headNode = Node<T>(item,head)
            headNode?.nextNode = head
            tailNode?.nextNode = headNode
            size++
        }
    }
    fun addLast(item: T) {
        if(tailNode == null) {
            Node<T>(item,null).apply {
                headNode = this
                tailNode = this
                size++
            }
        } else {
            val tail = tailNode
            tailNode = Node<T>(item,headNode)
            tail?.nextNode = tailNode
            tailNode?.nextNode = headNode
            size++
        }
    }
    fun addAtIndex(index:Int,item: T) {
        checkForIndex(index)
        when(index) {
            0 -> addFirst(item)
            getSize() -> addLast(item)
            else -> {
                var head = headNode
                for (i in 0 until index-1) {
                    head = head?.nextNode
                }
                head?.nextNode = Node<T>(item,head?.nextNode)
                size++
            }
        }
    }
    fun addAll(vararg items:T){
        val list = items as Array<T>
        for (index in list.indices) {
            addAtIndex(index,list[index])
        }
    }

    //READ
    fun getSize() : Int = size
    fun getFirst() : T? = if(headNode != null) headNode?.dataItem else null
    fun getLast() : T? = if (tailNode != null) tailNode?.dataItem else null
    fun getAll() : Array<Any?> {
        val list = arrayOfNulls<Any>(getSize())
        var head = headNode
        for (index in 0 until getSize()) {
            list[index] =head?.dataItem
            head = head?.nextNode
        }
        return list
    }
    fun getAtIndex(index: Int) : T? {
        checkForIndex(index)
        return when (index) {
            0 -> getFirst()
            getSize() -> getLast()
            else -> {
                var head = headNode
                for (i in 0 until index) {
                    head = head?.nextNode
                }
                head?.dataItem
            }
        }
    }

    //UPDATE
    fun updateFirst(item: T){
        headNode?.let {
            headNode?.dataItem = item
        }
    }
    fun updateLast(item: T) {
        tailNode.let {
            tailNode?.dataItem = item
        }
    }
    fun updateAt(index: Int,item: T) {
        checkForIndex(index)
        when(index) {
            0 -> updateFirst(item)
            getSize() -> updateLast(item)
            else -> {
                var head = headNode
                for (i in 0 until index) {
                    head = head?.nextNode
                }
                head?.dataItem= item
            }
        }
    }
    fun updateAllByNull() {
        var head = headNode
        for (index in 0 until getSize()) {
            head?.apply {
                dataItem = null
                head = nextNode
            }
        }
    }

    //DELETE
    fun deleteFirst() {
        when (headNode) {
            null -> { reset() }
            tailNode -> { reset() }
            else -> {
                headNode = headNode?.nextNode
                tailNode?.nextNode = headNode
                size--
            }
        }
    }

    fun deleteLast() {
        if(tailNode != null) {
            if (headNode == tailNode) {
                reset()
            } else {
                var head = headNode
                while (true) {
                    if(head?.nextNode == tailNode) {
                        break
                    }
                    head = head?.nextNode
                }
                tailNode = head
                tailNode?.nextNode = headNode
                size--
            }
        }
    }
    fun deleteAt(index: Int) {
        checkForIndex(index)
        when(index) {
            0 -> deleteFirst()
            getSize() -> deleteLast()
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
    fun deleteAll() { reset() }

    private fun checkForIndex(index: Int) {
        if(index > size || index < 0) throw IndexOutOfBoundsException("Invalid Index")
    }

    //@TestOnly, to Check after tailNode getting head or not : PASS
    fun checkForCLL(num:Int) {
        //For Testing
        var head = headNode
        repeat(num) {
            println("Data : ${head?.dataItem}")
            head = head?.nextNode
        }
    }
    private fun reset() {
        headNode = null
        tailNode = null
        size = 0
    }
 }

fun main() {

    ListAsCircularLinkedList<Any>().apply {

        addFirst(20)
        addFirst(19)
        addFirst(18)
        //checkForCLL(7)

        addLast(22)
        addLast(23)
        addLast(24)
        //checkForCLL(10)

        addAtIndex(0,17)
        addAtIndex(4,21)
        addAtIndex(getSize(),25)

        addAll(1,2,3,4,5,6,7,8,9,10)

        println(getAll().contentToString())
        println("${getAtIndex(0)} | ${getAtIndex(5)} | ${getAtIndex(getSize())}")

        updateFirst(111)
        updateLast(225)
        updateAt(10,1100)

        println(getAll().contentToString())

        deleteFirst()
        deleteLast()

        deleteAt(0)
        deleteAt(9)
        deleteAt(getSize())

        println("--> "+getAll().contentToString())

        deleteAll()
        updateAllByNull()
        checkForCLL(getSize()*2)
    }
}
