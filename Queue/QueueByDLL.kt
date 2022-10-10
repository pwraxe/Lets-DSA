/**Create Queue By Doubly Linked List**/
/**Direction : RTL (Insert or Enqueue from right [last index] and deque or remove from left [first index])**/

class EmptyListException (message: String) : RuntimeException(message)

class QueueByDLL<T> {

    inner class Node<T> (
        internal var previousNode: Node<T>?,
        internal var dataItem : T?,
        internal var nextNode: Node<T>?
    )

    private var headNode: Node<T>? = null
    private var tailNode: Node<T>? = null
    private var size : Int = 0

    fun enqueue(element: T) {
        if(headNode == null) {
            Node<T>(null,element,null).apply {
                headNode = this
                tailNode = this
            }   
        } else {
            val tail = tailNode
            tailNode = Node<T>(tail,element,null)
            tail?.nextNode = tailNode
        }
        size++
    }
    fun dequeue() {
        if(headNode != null) {
            headNode = headNode?.nextNode
            size--
        } else {
            throw EmptyListException("No Element to Remove or Dequeue")
        }
    }

    fun getSize() = size

    fun getList(): Array<Any?> {
        val list = arrayOfNulls<Any?>(size)
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

    fun getFront() : T? = if(size > 0) headNode?.dataItem else null
    fun getRear() : T? = if(size > 0) tailNode?.dataItem else null
}

fun main() {

    QueueByDLL<Any>().apply {

        enqueue(10)
        enqueue(20)
        enqueue(30)
        enqueue(40)
        enqueue(50)

        println("List : ${getList().contentToString()}")
        println("SIZE : ${getSize()} = FRONT : ${getFront()} | REAR : ${getRear()}")

        dequeue()
        dequeue()
        dequeue()


        println("List : ${getList().contentToString()}")
        println("SIZE : ${getSize()} = FRONT : ${getFront()} | REAR : ${getRear()}")
    }
}

