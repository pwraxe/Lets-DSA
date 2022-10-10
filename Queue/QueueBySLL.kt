/**Create Queue From Singly Linked List **/
/**{RTL Direction : EnQ from right(last index) and Dequeue from left (first index)**/

class EmptyListException(message : String) : RuntimeException(message)

class QueueBySLL<T> {

    inner class Node<T> (
        internal var dataItem: T,
        internal var nextNode : Node<T>?
    )

    private var headNode : Node<T>? = null
    private var tailNode : Node<T>? = null
    private var size: Int = 0

    fun enqueue(element: T) {

        if(tailNode == null) {
            Node<T>(element,null).apply {
                headNode = this
                tailNode = this
            }
        } else {
            val tail = tailNode
            tailNode = Node<T>(element,null)
            tail?.nextNode = tailNode
        }
        size++
    }

    fun dequeue() {
        if(headNode == null) {
            throw EmptyListException("No Items in List")
        }
        headNode = headNode?.nextNode
        size--
    }

    fun getFront() = if (size > 0) headNode?.dataItem else null

    fun getRear() = if(size > 0) tailNode?.dataItem else null

    fun getSize () = size

    fun getList() : Array<Any?> {

        val list = arrayOfNulls<Any>(size)

        for (index in 0 until size) {
            list[index] = getElementAt(index)
        }
        return list
    }

    private fun getElementAt(index: Int): Any? {
        var head = headNode
        for (i in 0 until index) {
            head = head?.nextNode
        }
        return head?.dataItem
    }
}

fun main() {
    QueueBySLL<Any>().apply {

        enqueue(10)
        enqueue(20)
        enqueue(30)
        enqueue(40)
        enqueue(50)
        println("List : ${getList().contentToString()}")
        println("SIZE : ${getSize()}  || FRONT : ${getFront()} | REAR : ${getRear()}")

        dequeue()
        dequeue()
        dequeue()
        dequeue()
        dequeue()

        println("List : ${getList().contentToString()}")
        println("SIZE : ${getSize()}  || FRONT : ${getFront()} | REAR : ${getRear()}")

    }
}
