class StackUnderflowException(message: String) : RuntimeException(message)

class StackByDoublyLinkedList<T> {

    inner class Node<T>(
        internal var previousNode : Node<T>?,
        internal var dataItem: T?,
        internal var nextNode: Node<T>? )

    private var headNode : Node<T>? = null
    private var tailNode : Node<T>? = null
    private var size : Int = 0


    fun push(element : T) {

        if(headNode == null) {
            /** WE Dont have element in list**/
            Node<T>(null,element,null).apply {
                tailNode = this
                headNode = this
            }
        } else {
            val tail = tailNode
            tailNode = Node<T>(tail,element,null)
            tail?.nextNode = tailNode
        }
        ++size
    }

    fun pop() {
        if(tailNode == null) throw StackUnderflowException("No Element in list to Remove/POP")
        tailNode = tailNode?.previousNode
        --size
    }

    fun peek() = tailNode?.dataItem

    fun isStackEmpty() = size == 0

    //I think, this is bad Logic To READ element, bcoz i am using headNode as starting
    fun realAllElements() : Array<Any?> {

        val list = arrayOfNulls<Any?>(size)
        var head = headNode
        for (index in 0 until size) {
            list[index] = head?.dataItem
            head = head?.nextNode
        }
        return list
    }
}

fun main() {
    StackByDoublyLinkedList<Any>().apply {

        push(11)
        push(12)
        push(13)
        push(14)
        push(15)
        push(16)
        push(17)
        push(18)
        push(19)

        println("List : ${realAllElements().contentToString()}")
        println("Peek : ${peek()}")

        pop()
        pop()
        pop()
        pop()

        println("List : ${realAllElements().contentToString()}")
        println("Peek : ${peek()}")
    }
}
