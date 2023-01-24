class LetsQueueByDLL<T>() {

    private inner class Node<T>(
        internal var previousNode: Node<T>? = null,
        internal var dataItem : T?,
        internal var nextNode : Node<T>? = null
    )

    private var headNode : Node<T>? = null
    private var tailNode : Node<T>? = null
    private var size: Int = 0

    fun enqueue(item: T) {
        if(tailNode != null) {
            val tail = tailNode
            tailNode = Node<T>(tail,item,null)
            tail?.nextNode = tailNode
            tailNode?.previousNode = tail
        } else {
            Node<T>(null,item,null).apply {
                headNode = this
                tailNode = this
            }
        }
        size++
    }
    fun dequeue() {
        if(headNode != null) {
            headNode = headNode?.nextNode
            headNode?.previousNode = null
            size--
        } else {
            println("No More Dequeue , isHeadNull : ${headNode == null}")
        }
    }

    fun getSize() = size
    fun getFront() : Any? = if (headNode != null) headNode?.dataItem else null
    fun getRear() : Any? = if(tailNode != null) tailNode?.dataItem else null
    fun isFull() { println("fullness of LL, can be determine when we want n no. of fixed node, otherwise we cant")}
    fun isEmpty() = headNode == null || tailNode == null

    fun readAll() {
        if(headNode != null) {
            var head= headNode
            val list = arrayListOf<Any>()
            while (head != null) {
                list.add(head.dataItem!!)
                head = head.nextNode
            }
            println(list)
        } else println("list is empty")
    }
}

fun main() {

    LetsQueueByDLL<Int>().apply {
        enqueue(10)
        enqueue(11)
        enqueue(12)
        enqueue(13)
        enqueue(14)
        enqueue(15)

        dequeue()
        dequeue()
        dequeue()
        
        readAll()

        println("${getSize()} | ${getFront()} | ${getRear()} | ${isFull()} | ${isEmpty()}")
    }

}
