
//TODO --> 16. Create Queue Using DoublyLinkedList (From RTL), Enqueue From Rear and Dequeue From Front

class QueueByDLL_RTL<T> {

     inner class Node<T>(
         internal var prevNode: Node<T>?,
         internal var dataItem : T?,
         internal var nextNode : Node<T>?
     )

    private var headNode : Node<T>? = null
    private var tailNode : Node<T>? = null
    private var size : Int = 0

    //CREATE
    //enqueue from rear
    fun enqueue(item: T) {
       if(tailNode == null) {
           Node<T>(null,item,null).apply {
               headNode = this
               tailNode = this
           }
           size++
       } else {
           var tail = tailNode
           tailNode = Node<T>(tail,item,null)
           tail?.nextNode = tailNode
           tailNode?.prevNode = tail
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
    //Dequeue from front
    fun dequeue() {

        if (headNode != null) {
            if(headNode == tailNode) {
                headNode = null
                tailNode = null
                size = 0
            } else {
                headNode = headNode?.nextNode
                size--
            }
        }
    }
 }

fun main() {

    QueueByDLL_RTL<Any>().apply {

        enqueue(6)
        enqueue(7)
        enqueue(8)
        enqueue(9)
        enqueue(10)

        dequeue()
//
//        updateFront(66)
//        updateIndex(1,77)
//        updateRear(99)

        println("${getSize()} || ${getFront()} | ${getAll().contentToString()} | ${getRear()}")

    }

}
