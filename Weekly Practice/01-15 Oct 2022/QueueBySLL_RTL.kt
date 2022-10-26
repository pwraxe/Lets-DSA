//TODO --> 14. Create Queue Using SinglyLinkedList (From RTL), Enqueue From Rear and Dequeue From Front

class QueueBySLL_RTL<T> {

    inner class Node<T> (

        internal var dataItem: T?,
        internal var nextNode: Node<T>?
    )

    private var headNode: Node<T>? = null
    private var tailNode: Node<T>? = null
    private var size : Int = 0

    //CREATE
    //Enqueue from last/Rear
    fun enqueue(item: T) {
        if(tailNode == null) {
            Node<T>(item,null).apply {
                headNode = this
                tailNode = this
            }
            size++
        } else {
            var tail = tailNode
            tailNode = Node<T>(item,null)
            tail?.nextNode = tailNode
            size++
        }
    }

    //READ
    fun getSize() = size
    fun getFront() : T? {
        return headNode?.let {
            headNode?.dataItem
        }
    }
    fun getRear() : T? {
        return tailNode?.let {
            tailNode?.dataItem
        }
    }
    fun getAll() : Array<Any?> {
        val list = arrayOfNulls<Any>(getSize())
        var head = headNode
        for (index in 0 until getSize()) {
            list[index] = head?.dataItem
            head = head?.nextNode
        }
        return list
    }

    //UPDATE
    fun updateFront(item : T) {
        headNode?.let {
            headNode?.dataItem = item
        }
    }
    fun updateRear(item : T) {
        tailNode?.let {
            tailNode?.dataItem = item
        }
    }
    fun updateIndex(index : Int, item: T) {
        if(index > size || index < 0) throw IndexOutOfBoundsException("Invalid Index : $index")
        when(index) {
            0 -> updateFront(item)
            getSize() -> updateRear(item)
            else -> {
                var head = headNode
                for (i in 0 until getSize()-1) {
                    head = head?.nextNode
                }
                head?.dataItem = item
            }
        }
    }

    //DELETE
    //Dequeue from front
    fun dequeue() {
        headNode?.let {

            if (headNode?.nextNode != null) {
                //next node is avail
                headNode = headNode?.nextNode
                size--
            } else {
                headNode = null
                tailNode = null
                size = 0
            }
        }
    }
}

fun main() {
    QueueBySLL_RTL<Any>().apply {

        enqueue(10)
        enqueue(11)
        enqueue(12)
        enqueue(13)

        updateFront(100)
        updateIndex(2,122)
        updateRear(133)

        dequeue()

        println("${getSize()} || ${getFront()} | ${getAll().contentToString()} | ${getRear()}")
    }
}
