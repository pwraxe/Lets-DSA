//TODO --> 4. DoublyLinkedList

class LetsDoublyLinkedList<T> {

    inner class Node<T>(
        internal var prevNode: Node<T>?,
        internal var dataItem: T?,
        internal var nextNode : Node<T>?
    )
    private var headNode: Node<T>? = null
    private var tailNode: Node<T>? = null
    private var size : Int = 0

    //Create
    fun addFirst(item:T) {
        if(headNode != null) {
            val head = headNode
            headNode = Node<T>(null,item,head)
            size++
        } else {
            Node<T>(null,item,null).apply {
                headNode = this
                tailNode = this
                size++
            }
        }
    }
    fun addLast(item:T) {
        if(tailNode != null) {
            val tail = tailNode
            tailNode = Node<T>(tail,item,null)
            tail?.nextNode = tailNode
            size++
        } else {
            //No node
            Node<T>(null,item,null).apply {
                headNode = this
                tailNode = this
                size++
            }
        }
    }
    fun addAt(index:Int,item:T) {

        if(index > size || index < 0) throw IndexOutOfBoundsException("Invalid Index : $index")

        when(index) {
            0 -> addFirst(item)
            size -> addLast(item)
            else -> {
                var head = headNode
                for (i in 0 until index-1) {
                    head = head?.nextNode
                }
                head?.nextNode = Node<T>(head,item,head?.nextNode)
                size++
            }
        }
    }

    //Read
    fun getFirst() : T? = if(headNode != null) headNode?.dataItem else null
    fun getLast() : T? = if (tailNode != null) tailNode?.dataItem else null
    fun getSize() : Int = size
    fun getAt(index:Int) : T? {
        if(index > size || index < 0) throw IndexOutOfBoundsException("Invalid Index : $index")
        return when(index) {
            0 -> getFirst()
            size -> getLast()
            else -> {
                var head = headNode
                for (i in 0 until index) {
                    head = head?.nextNode
                }

                return head?.dataItem
            }
        }
    }
    fun getAll() : Array<Any?> {
        val list = arrayOfNulls<Any>(size)
        var head = headNode
        for (index in 0 until size) {
            //val num = getAt(index)
            //OR
            list[index] = head?.dataItem
            head = head?.nextNode
        }
        return list
    }

    //Update
    fun updateFirst(item:T){
        headNode?.let {
            headNode?.dataItem = item
        }
    }
    fun updateAt(index: Int,item:T){
        if (index > size || index < 0) throw IndexOutOfBoundsException("Invalid Index : $index")
        when(index) {
            0 -> updateFirst(item)
            getSize() -> updateLast(item)
            else -> {
                var head = headNode
                for (i in 0 until index) {
                    head = head?.nextNode
                }
                head?.dataItem = item
            }
        }
    }
    fun updateLast(item:T){
        tailNode?.let {
            tailNode?.dataItem = item
        }
    }
    fun updateAllWithNull(){
        var head = headNode
        for (index in 0 until size) {
            head?.dataItem = null
            head = head?.nextNode
        }
    }

    //Delete
    fun removeFirst() {
        if(headNode != null) {
            if(headNode?.nextNode != null) {
                headNode = headNode?.nextNode
                size--
            } else {
               reset()
            }
        }
    }
    fun removeLast() {
        if(tailNode != null) {
            if(tailNode == headNode) {
                reset()
            } else {
                tailNode = tailNode?.prevNode
                size--
            }
        }
    }
    fun removeAt(index:Int) {
        if (index > size || index < 0) throw IndexOutOfBoundsException("Invalid Index : $index")
        when(index) {
            0 -> removeFirst()
            getSize() -> removeLast()
            else -> {
                var head = headNode
                var prevNode: Node<T>? = null
                for (i in 0 until index) {
                    prevNode = head
                    head = head?.nextNode
                }
                prevNode?.nextNode = head?.nextNode
                size--
            }
        }
    }
    fun removeAll(){ reset() }

    fun reset() {
        headNode = null
        tailNode = null
        size = 0
    }
}

fun main() {
    LetsDoublyLinkedList<Any>().apply {

        addFirst(10)
        addFirst(9)
        addFirst(8)

        addLast(11)
        addLast(12)
        addLast(13)

        addAt(0,7)
        addAt(3,111)
        addAt(getSize(),14)

        println("${getFirst()} | ${getAll().contentToString()} | ${getAt(3)} | ${getLast()}")

        updateFirst(77)
        updateLast(144)
        updateAt(3,100)

        //updateAllWithNull()

        println("${getFirst()} | ${getAll().contentToString()} | ${getAt(3)} | ${getLast()}")

        removeFirst()
        removeLast()
        println(getAll().contentToString())
        removeAt(3)
        //removeAll()
        println(getAll().contentToString())


    }
}
