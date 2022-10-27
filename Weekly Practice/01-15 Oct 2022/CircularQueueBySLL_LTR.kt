//TODO --> 20. Circular Queue by SLL (LTR) Enqueue From Front, Dequeue From Rear

class CircularQueueBySLL_LTR<T> {

    inner class Node<T>(
        internal var dataItem : T?,
        internal var nextNode : Node<T>?
    )

    private var headNode : Node<T>? = null
    private var tailNode : Node<T>? = null
    private var size : Int = 0


    //CREATE
    //Enqueue From Front
    fun enqueue(item: T ) {

        headNode?.let {

            val head = headNode
            headNode = Node<T>(item,head)
            headNode?.nextNode = head
            tailNode?.nextNode = headNode
            size++

        }?: run {
            Node<T>(item,null).apply {
                headNode = this
                tailNode = this
            }
            size++
        }
    }

//    //READ
    fun getFront() : Any? {
        return headNode?.let {
            headNode?.dataItem
        }
    }
    fun getRear() : Any? {
        return tailNode?.let {
            tailNode?.dataItem
        }
    }
    fun getSize() = size
    fun getAll() : Array<Any?>{
        val list = arrayOfNulls<Any>(getSize())
        var head = headNode
        for (index in 0 until getSize()) {
            list[index] = head?.dataItem
            head = head?.nextNode
        }
        return list

    }
    fun getAt(index : Int) : T? {

        if(index > size || index < 0) throw IndexOutOfBoundsException("Invalid index : $index")
        var head = headNode
        for (i in 0 until index) {
            head = head?.nextNode
        }
        return head?.dataItem
    }

    //UPDATE
    fun updateFront(item: T) {
        headNode?.let {
            headNode?.dataItem = item
        }
    }
    fun updateRear(item : T) {
        tailNode?.let {
            tailNode?.dataItem = item
        }
    }
    fun updateAt(index:Int,item: T) {
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
    //Dequeue From Front
    fun dequeue() {

        if (tailNode != null) {
            if(headNode == tailNode) {
                headNode = null
                tailNode = null
                size = 0
            } else {
                var head = headNode
                for (index in 0 until getSize()-2) {
                    head = head?.nextNode
                }
                tailNode = head
                tailNode?.nextNode = headNode
                size--
            }
        }
    }

    //OTHER

    fun checkForCircularQueue() {
        var head = headNode
        repeat(8) {
            println(">>--> ${head?.dataItem}")
            head = head?.nextNode
        }
    }
}

fun main() {

    CircularQueueBySLL_LTR<Any>().apply {

        enqueue(10)
        enqueue(11)
        enqueue(12)
        enqueue(13)

        //checkForCircularQueue()

        updateFront(100)
        updateRear(133)
        updateAt(2,122)

        //dequeue()

        println("${getSize()} | ${getFront()} | ${getAll().contentToString()} | ${getRear()} | ${getAt(2)} ")

        dequeue()
        dequeue()
        dequeue()
        dequeue()

        println("${getSize()} | ${getFront()} | ${getAll().contentToString()} | ${getRear()} ")
    }

}
