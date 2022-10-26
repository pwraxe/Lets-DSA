
//TODO --> 15. Create Queue Using DoublyLinkedList (From LTR), Enqueue from Front Dequeue From Rear

class QueueByDLL_LTR<T> {

     inner class Node<T>(
         internal var prevNode: Node<T>?,
         internal var dataItem : T?,
         internal var nextNode : Node<T>?
     )

    private var headNode : Node<T>? = null
    private var tailNode : Node<T>? = null
    private var size : Int = 0

    //CREATE
    //enqueue from front
    fun enqueue(item: T) {
        if(headNode == null) {
            Node<T>(null,item,null).apply {
                headNode = this
                tailNode = this
            }
            size++
        } else {
            var head = headNode
            headNode = Node<T>(null,item,head)
            head?.prevNode = headNode
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
        var list = arrayOfNulls<Any>(getSize())
        var head = headNode
        for (index in 0 until getSize()) {
            list[index]  = head?.dataItem
            head = head?.nextNode
        }
        return list
    }

    //UPDATE
    fun updateFront(item: T){
        headNode?.let {
            headNode?.dataItem = item
        }
    }
    fun updateRear(item: T) {
        tailNode?.let {
            tailNode?.dataItem = item
        }
    }
    fun updateIndex(index : Int, item: T) {
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
    //Dequeue from rear
    fun dequeue() {
        tailNode?.let {
            if(tailNode == headNode) {
                headNode = null
                tailNode = null
                size = 0
            } else {
                tailNode = tailNode?.prevNode
                size--
            }
        }
    }
 }

fun main() {

    QueueByDLL_LTR<Any>().apply {

        enqueue(10)
        enqueue(9)
        enqueue(8)
        enqueue(7)
        enqueue(6)

        dequeue()

        updateFront(66)
        updateIndex(1,77)
        updateRear(99)

        println("${getSize()} || ${getFront()} | ${getAll().contentToString()} | ${getRear()}")

    }

}
