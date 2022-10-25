//TODO --> 6. Circular Doubly Linked List

class ListAsCircularDoublyLinkedList<T> {

    inner class Node<T> (
        internal var prevNode: Node<T>?,
        internal var dataItem : T?,
        internal var nextNode : Node<T>?
    )

    private var headNode: Node<T>? = null
    private var tailNode: Node<T>? = null
    private var size : Int = 0

    //Create
    fun addFirst(item:T) {
        if(headNode == null) {
            Node<T>(prevNode = null, dataItem = item, nextNode = null).apply {
                headNode = this
                tailNode = this
            }
        } else {
            val head = headNode
            headNode = Node<T>(prevNode = tailNode, dataItem = item, nextNode = head)
            headNode?.nextNode = head
            headNode?.prevNode = tailNode
            tailNode?.nextNode = headNode
        }
        size++
    }
    fun addLast(item: T) {
        if(tailNode == null) {
            Node<T>(prevNode = null, dataItem = item, nextNode = null).apply {
                headNode = this
                tailNode = this
            }
            size++
        } else {
            val tail = tailNode
            tailNode = Node<T>(prevNode = tail,item,headNode)
            tail?.nextNode = tailNode
            size++
        }

    }
    fun addAt(index:Int,item: T) {
        checkForIndex(index)
        when(index) {
            0 -> addFirst(item)
            getSize() -> addLast(item)
            else -> {
                var head = headNode
                for (i in 0 until index-1) {
                    head = head?.nextNode
                }
                val newNode = Node<T>(head,item,head?.nextNode)
                head?.nextNode = newNode
                size++
            }
        }
    }
    fun addAll(vararg items: T) {
        val list = items as Array<T>
        for (index in list.indices) {
            addLast(list[index])
        }
    }

    //Read
    fun getSize() : Int = size
    fun getFirst() : T? = if (headNode != null) headNode?.dataItem else null
    fun getLast() : T? = if(tailNode != null) tailNode?.dataItem else null
    fun getAt(index: Int) : T? {
        checkForIndex(index)
        var head = headNode
        for (i in 0 until index) {
            head = head?.nextNode
        }
        return head?.dataItem
    }
    fun getAll() : Array<Any?> {
        val list = arrayOfNulls<Any>(getSize())
        var head = headNode
        for (i in 0 until getSize()) {
            list[i] = head?.dataItem
            head = head?.nextNode
        }
        return list
    }

    //Update
    fun updateFirst(item: T) {
        headNode?.let {
            headNode?.dataItem = item
        }
    }
    fun updateLast(item: T) {
        tailNode?.let {
            tailNode?.dataItem = item
        }
    }
    fun updateAt(index:Int,item: T){
        checkForIndex(index)
        when(index) {
            0 -> updateFirst(item)
            getSize() -> updateLast(item)
            else -> {
                var head = headNode
                for (i in 0 until index){
                    head = head?.nextNode
                }
                head?.dataItem = item
            }
        }
    }
    fun updateAllByNull() {
        var head = headNode
        for (index in 0 until getSize()) {
            head?.dataItem = null
            head = head?.nextNode
        }
    }

    //Delete
    fun removeFirst(){
        if(headNode != null) {
            if(headNode?.nextNode != null) {
                headNode = headNode?.nextNode
                headNode?.prevNode = tailNode
                size--
            }else {
                reset()
            }
        }
    }
    fun removeLast() {
        if(tailNode != null) {
            if(tailNode != headNode) {
                tailNode = tailNode?.prevNode
                tailNode?.nextNode = headNode
                size--
            } else {
                reset()
            }
        }
    }
    fun removeAt(index:Int){
        checkForIndex(index)
        when(index) {
            0 -> removeFirst()
            getSize() -> removeLast()
            else -> {
                var head = headNode
                var prev : Node<T>? = null
                for (i in 0 until index) {
                    prev = head
                    head = head?.nextNode
                }
                prev?.nextNode = head?.nextNode
                size--
            }
        }
    }
    fun removeAll() { reset() }

    //Other
    private fun checkForIndex(index : Int) {
        if(index > size || index < 0) throw IndexOutOfBoundsException("Invalid Index : $index")
    }

    private fun reset() {
        headNode = null
        tailNode = null
        size = 0
    }

    fun checkForCLL(num : Int) {
        var head = headNode
        repeat(num) {
            println("--> ${head?.dataItem}")
            head = head?.nextNode
        }
    }
}

fun main() {
    ListAsCircularDoublyLinkedList<Any>().apply {

        addFirst(20)
        addFirst(19)
        addFirst(18)
        addFirst(17)

        println("${getFirst()} | ${getLast()}")
        checkForCLL(8)
        addLast(22)
        addLast(23)
        addLast(24)

        addAt(0,16)
        addAt(4,21)
        addAt(getSize(),25)

        checkForCLL(22)

        //addAll(1,2,3,4,5,6,7,8,9)
        println(getAll().contentToString())
        println("${getSize()} || ${getFirst()} | ${getAt(5)} | ${getLast()}")

        updateFirst(166)
        updateLast(225)
        updateAt(5,200)

        removeFirst()
        removeLast()
        removeAt(1)

        println(getAll().contentToString())

        removeAll()
        updateAllByNull()
    }
}
