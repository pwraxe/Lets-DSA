//TODO --> 21. Circular Queue by DLL (RTL) Enqueue From Rear, Dequeue From Front

class CirclularQueueByDLL_RTL<T> {

    inner class Node<T>(

        internal var prevNode: Node<T>?,
        internal var dataItem : T,
        internal var nextNode: Node<T>?
    )

    private var headNode: Node<T>? = null
    private var tailNode: Node<T>? = null
    private var size : Int = 0

    //CREATE
    //Enqueue From Rear
    fun enqueue(item: T) {
        tailNode?.let {
            var tail = tailNode
            tailNode = Node<T>(tail,item,headNode)
            tail?.nextNode = tailNode
            tailNode?.prevNode = tailNode
            tailNode?.nextNode = headNode
            size++
        } ?: run {
            Node<T>(null,item,null).apply {
                headNode = this
                tailNode = this
                size++
            }
        }
    }

    //READ
    fun getSize() = size
    fun getFront() :T? {
        return headNode?.let {
            headNode?.dataItem
        }
    }
    fun getRear() :T? {
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
    fun updateRear(item: T) {
        tailNode?.let {
            tailNode?.dataItem = item
        }
    }
    fun updateAt(index: Int, item:T) {
        if(index > getSize() || index < 0) throw IndexOutOfBoundsException("Invalid Index : $index")

        when(index) {
            0 -> updateFront(item)
            getSize() -> updateRear(item)
            else -> {
                var head = headNode
                for (index in 0 until index) {
                    head = head?.nextNode
                }
                head?.dataItem = item
            }
        }
    }

    //DELETE
    //Dequeue From Front
    fun dequeue() {
        headNode?.let {
            if(headNode == tailNode) {
                headNode = null
                tailNode = null
                size = 0
            } else {
                headNode = headNode?.nextNode
                tailNode?.nextNode = headNode
                headNode?.prevNode = tailNode
                size--
            }
        }
    }

    fun checkForCircularQueue() {

        var head = headNode
        repeat(8) {
            println(">>--> ${head?.dataItem}")
            head = head?.nextNode
        }
    }
}

fun main() {

    CirclularQueueByDLL_RTL<Any>().apply {

        enqueue(10)
        enqueue(11)
        enqueue(12)
        enqueue(13)

        updateFront(100)
        updateAt(2,144)
        updateRear(133)

        //checkForCircularQueue()

        println("${getSize()} || ${getFront()} | ${getAll().contentToString()} | ${getRear()}")

        dequeue()
        dequeue()
        dequeue()
        dequeue()

        println("${getSize()} || ${getFront()} | ${getAll().contentToString()} | ${getRear()}")

    }

}
