//TODO  --> 10. Create Stack Using DoublyLinkedList
class StackByDLL<T> {

    inner class Node<T> (
        internal var prevNode: Node<T>?,
        internal var dataItem : T,
        internal var nexrNode: Node<T>? )

    private var headNode : Node<T>? = null
    private var tailNode : Node<T>? = null
    private var size : Int = 0

    //CREATE
    fun push(item : T) {
        if(headNode == null) {
            Node<T>(null,item,null).apply {
                headNode = this
                tailNode = this
                size++
            }
        } else {
            val tail = tailNode
            tailNode = Node<T>(tail,item,null)
            tail?.nexrNode = tailNode
            size++
        }
    }
    fun pushAll(vararg items:T) {
        for (index in items.indices) {
            push(items[index])
        }
    }

    //READ
    fun getTail() : T? {
        return tailNode?.let {
            tailNode?.dataItem
        }
    }
    fun getPeak() : T? = getTail()
    fun getSize() : Int = size
    fun getAll() : Array<Any?> {
        var list = arrayOfNulls<Any>(getSize())
        var head = headNode
        for (index in 0 until getSize()) {
            list[index] = head?.dataItem
            head = head?.nexrNode
        }
        return list
    }

    //UPDATE
    fun set(index:Int, item: T) {
        if(index > size || index < 0) throw IndexOutOfBoundsException("Invalid Index : $index")
        when(index) {
            0 -> headNode?.dataItem = item
            getSize() -> tailNode?.dataItem = item
            else -> {
                var head = headNode
                for (i in 0 until index) {
                    head = head?.nexrNode
                }
                head?.dataItem = item
            }
        }
    }

    //DELETE
    fun pop() {
        tailNode?.let {
            tailNode = tailNode?.prevNode
            size--
        }
    }
    fun popAll(){
        headNode = null
        tailNode = null
        size = 0
    }

}

fun main() {

    StackByDLL<Any>().apply {

        push(10)
        push(11)
        push(12)
        push(13)

        println("${getSize()} | ${getAll().contentToString()} | ${getPeak()} || ${getTail()}")

        set(0,100)
        set(1,111)
        set(getSize(),133)

        println("${getSize()} | ${getAll().contentToString()} | ${getPeak()} || ${getTail()}")

        pop()

        println("${getSize()} | ${getAll().contentToString()} | ${getPeak()} || ${getTail()}")
    }

}
