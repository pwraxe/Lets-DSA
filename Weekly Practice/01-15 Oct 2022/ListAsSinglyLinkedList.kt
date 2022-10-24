
// TODO --> 3. CRUD Operation on Singly Linked List
class ListAsSinglyLinkedList<T> {

    inner class Node<T>(
        internal var dataItem: T?,
        internal var nextNode: Node<T>?
    )

    private var headNode : Node<T>? = null
    private var tailNode : Node<T>? = null
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
            size++
        }
    }
    fun addAt(index: Int, item: T){
        if (index > size || index < 0) throw IndexOutOfBoundsException("Invalid index : $index")

        when (index) {
            0 -> addFirst(item)
            getSize() -> addLast(item)
            else -> {
                var head = headNode
                for (i in 0 until index-1) {
                    head = head?.nextNode
                }
                val next = head?.nextNode
                Node<T>(item,next).apply {
                    head?.nextNode = this
                }
                size++
            }
        }
    }
    fun addLast(item: T) {
        if(headNode == null) {
           addFirst(item)
        } else {
            val tail = tailNode
            Node(item,null).apply {
                tailNode = this
                tail?.nextNode = tailNode
            }
            size++
        }

    }
    fun addAll(vararg items:T){
        val list = items as Array<T>
        for (index in list.indices) {
            addLast(list[index])
        }
    }

    //READ
    fun getSize() : Int = size
    fun getFirst() : T? = if(headNode != null) headNode?.dataItem else null
    fun getLast() : T? = if (tailNode != null) tailNode?.dataItem else null
    fun getAt(index: Int) : T? {
        var head = headNode
        for (i in 0 until index) {
           head = head?.nextNode
        }
        return head?.dataItem
    }
    fun getAll() : Array<Any?> {
        val list = arrayOfNulls<Any>(size)
        var head = headNode
        for (index in 0 until size) {
            list[index] = head?.dataItem
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
    fun updateAt(index : Int, item: T){
        if(size > 0) {
            var head = headNode
            for (index in 0 until index) {
                head = head?.nextNode
            }
            head?.dataItem = item
        }
    }

    //Delete
    fun deleteFirst() {
        if(headNode != null) {
            if(headNode?.nextNode != null) {
                headNode = headNode?.nextNode
                size--
            } else {
                headNode = null
                tailNode = null
                size--
            }
        }
    }
    fun deleteLast() {
        if(tailNode != null) {
            if(headNode == tailNode) {
                headNode = null
                tailNode = null
                size--
            } else {
                var head = headNode
                for (index in 0 until size-1) {
                    head = head?.nextNode
                }
                tailNode = head
                size--
            }
        }
    }
    fun deleteAt(index : Int) {
        if(index > size || index < 0) throw IndexOutOfBoundsException("Invalid Index : $index")

        when (index) {
            0 -> deleteFirst()
            getSize() -> deleteLast()
            else -> {
                var head = headNode
                for (i in 0 until index-1) {
                    head = head?.nextNode
                }
                val next = head?.nextNode?.nextNode
                head?.nextNode = next
                size--
            }
        }
    }

    fun deleteAll(){
        headNode = null
        tailNode = null
        size = 0
    }

}

fun main() {
    ListAsSinglyLinkedList<Int>().apply {

        addFirst(10)
        addFirst(9)
        addFirst(8)
        addFirst(7)
        addLast(11)
        addLast(12)
        addLast(13)
        addAt(0,100)
        addAt(2,222)
        addAt(getSize(),999)

        addAll(1,2,3,6,5,4,7,8,9)

        println("Size : ${getSize()} | First ${getFirst()} |Last : ${getLast()}  | Index 5 :${getAt(5)} | All : ${getAll().contentToString()}")

        updateFirst(77)
        updateLast(900)
        updateAt(5,5555)

        deleteFirst()
        deleteLast()
        deleteAt(0)
        deleteAt(2)
        deleteAt(getSize())

        deleteAll()
        println("--> "+getAll().contentToString())

    }
}
