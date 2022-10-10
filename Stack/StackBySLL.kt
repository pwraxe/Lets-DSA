/**Create Stack Using Singly-Linked-List**/

/**For Linked List Case we get StackUnderFlow all time when no element**/
class StackUnderflowException(message : String) : RuntimeException(message)

class StackBySLL<T> {

    inner class Node<T>(
        internal var dataItem : T,
        internal var nextNode : Node<T>?
    )

    private var headNode: Node<T>? = null
    private var tailNode: Node<T>? = null
    private var size: Int = 0


    fun push(element : T) {
        if(headNode == null) {

            Node<T> (element,null).apply {
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

    fun pop() {

        if(tailNode == null) {
            throw StackUnderflowException("No Element in List to remove")
        }
        var head = headNode
        val prevIndex = size-1

        for (index in 0 until (prevIndex-1)) {
            head = head?.nextNode
        }
        tailNode = head
        --size
    }

    fun getPeek() : T? = if(size > 0) tailNode?.dataItem else null

    fun getSize() : Int = size

    private fun getElementAt(index : Int) : T? {
        var head = headNode
        for (i in 0 until index) {
            head = head?.nextNode
        }
        return head?.dataItem
    }
    fun getList() : Array<Any?> {
        val list = Array<Any?>(size){ null }
        for (index in 0 until size) {
            list[index] = getElementAt(index)
        }
        return list
    }
}

fun main() {

    StackBySLL<Any>().apply {

        push("AAA")
        push("MMM")
        push(10)
        push(13)
        push(true)
        push(3.145)

        println(getList().contentToString())
        println("Peak B4 : ${getPeek()} | ${getSize()}")

        pop()
        pop()
        pop()
        pop()
        pop()
        pop()

        println(getList().contentToString())
        println("Peak After : ${getPeek()} | ${getSize()}")

    }
}
