import java.lang.RuntimeException

class StackUnderFlowException(message: String) : RuntimeException(message)

class LetsStackByDLL<T> {

    internal class Node<T>(
        internal var previousNode: Node<T>? = null,
        internal var dataItem : T? = null,
        internal var nextNode: Node<T>? = null
    )

    private var headNode: Node<T>? = null
    private var tailNode : Node<T>? = null
    private var size : Int = 0


    fun push(item : T) {

        if(headNode != null) {
            var tail = tailNode
            tailNode = Node<T>(tail, dataItem = item, null)
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

    fun pop() {
        if(tailNode != null) {
            tailNode = tailNode?.previousNode
            tailNode?.nextNode = null
            size--
        } else {
            //you can throw exception here,
            println("Stack is Empty")
        }
    }

    fun isEmpty() : Boolean = headNode == null || tailNode == null

    fun isFull(){ println("we cant predict list is full or not in LL, it can be possible if we want n no. of nodes")}

    fun peek() : Any? = if(tailNode != null) tailNode?.dataItem else null

    fun readAll() {
        if(headNode != null) {
            var head = headNode
            var list = arrayListOf<T>()
            while (head != null) {
                list.add(head.dataItem!!)
                head = head.nextNode
            }
            println(list)
        } else emptyList<T>()

    }
}
fun main() {
    LetsStackByDLL<Int>().apply {
        println("${isEmpty()} | ${isFull()} | ${peek()}")
        
        push(10)
        push(11)
        push(12)
        push(13)
        push(14)
        push(15)
        push(16)

        pop()
        pop()

        println("${isEmpty()} | ${isFull()} | ${peek()}")

        readAll()
    }
}
