
//TODO --> 21. Circular Queue by DLL (RTL) Enqueue From Front, Dequeue From Rear

class CirclularQueueByDLL_LTR<T> {


    inner class Node<T>(

        internal var prevNode: Node<T>?,
        internal var dataItem : T,
        internal var nextNode: Node<T>?
    )

    private var headNode: Node<T>? = null
    private var tailNode: Node<T>? = null
    private var size : Int = 0

    //CREATE
    //Enqueue From Front
    fun enqueue(item: T) {


        headNode?.let {
            var head = headNode
            headNode = Node<T>(tailNode,item,head)
            headNode?.nextNode = head
            head?.prevNode = headNode
            headNode?.prevNode = tailNode
            tailNode?.nextNode = headNode
            size++
        } ?: run {
            Node<T>(null, item,null).apply {
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
    //Dequeue From Rear
    fun dequeue() {


        tailNode?.let {

            if(tailNode == headNode) {
                headNode = null
                tailNode = null
                size = 0
            } else {
                tailNode = tailNode?.prevNode
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

    CirclularQueueByDLL_LTR<Any>().apply {

        enqueue(10)
        enqueue(11)
        enqueue(12)
        enqueue(13)
//
//        updateFront(100)
//        updateAt(2,144)
//        updateRear(133)
//
//        checkForCircularQueue()
//
//        println("${getSize()} || ${getFront()} | ${getAll().contentToString()} | ${getRear()}")
//
//        dequeue()
//        dequeue()
        dequeue()
        dequeue()

        println("${getSize()} || ${getFront()} | ${getAll().contentToString()} | ${getRear()}")

    }

}
