// TODO --> 13. Create Queue Using SinglyLinkedList (From LTR), Enqueue From Front and Dequeue From Read

class QueueBySLL_LTR<T>{

    inner class Node<T>(
        internal var dataItem : T?,
        internal var nextNode : Node<T>?
    )

    private var headNode : Node<T>? = null
    private var tailNode : Node<T>? = null
    private var size : Int = 0

    //CREATE
    //Add Node from first
    fun enqueue(item:T) {

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
    fun updateFront(item: T) {
        headNode?.let {
            headNode?.dataItem = item
        }
    }
    fun updateRear(item: T) {
        tailNode?.let {
            tailNode?.dataItem = item
        }
    }
    fun updateIndex(index:Int,item: T) {
        if(index > size || index < 0) throw IndexOutOfBoundsException("Invalid index : $index")
        when(index) {
            0 -> updateFront(item)
            getSize() -> updateRear(item)
            else -> {
                var head = headNode
                for (i in 0 until index) {
                    head = head?.nextNode
                }
                head?.dataItem = item
            }
        }
    }

    //DELETE
    //remove from end/rear
    fun dequeue() {
        tailNode?.let {

            if(tailNode == headNode) {
                headNode = null
                tailNode = null
                size = 0
            } else {
                var head = headNode
                for (index in 0 until getSize()-2) {
                    head = head?.nextNode
                }
                tailNode = head
                size--
            }
        }
    }
}

fun main() {

    QueueBySLL_LTR<Any>().apply {

        enqueue(10)
        enqueue(9)
        enqueue(8)
        enqueue(7)

        updateFront(77)
        updateIndex(2,99)
        updateRear(100)

        dequeue()
        dequeue()
        dequeue()
        dequeue()

        println("${getSize()} || ${getFront()} | ${getAll().contentToString()} | ${getRear()} ")
    }
}
