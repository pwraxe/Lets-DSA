//TODO --> 9. Create Stack Using SinglyLinkedList

class StackBySLL<T>{

    inner class Node<T>(
        internal var dataItem : T?,
        internal var nextNode : Node<T>?
    )

    private var headNode : Node<T>? = null
    private var tailNode : Node<T>? = null
    private var size : Int = 0

    //CREATE
    fun push(item:T) {
        if(headNode == null) {
            Node<T>(item,null).apply {
                headNode =  this
                tailNode = this
                size++
            }
        } else {
            val tail = tailNode
            tailNode = Node<T>(item,null)
            tail?.nextNode = tailNode
            size++
        }
    }

    //READ
    //By Reading head, violets stack rules
    
//    fun getHead() : T? {
//        return headNode?.let {
//            headNode?.dataItem
//        }
//    }
    fun getSize() : Int = size
    fun getTail() : T? {
        return tailNode?.let {
            tailNode?.dataItem
        }
    }
    fun getAll() : Array<Any?> {
        var list = arrayOfNulls<Any>(size)
        var head = headNode
        for (index in 0 until getSize()) {
            list[index] = head?.dataItem
            head = head?.nextNode
        }
        return list
    }
    fun getPeak() : T? = getTail()

    //UPDATE
    fun setFirst(item: T) {
        headNode?.let {
            headNode?.dataItem = item
        }
    }
    fun setLast(item: T) {
        tailNode?.let {
            tailNode?.dataItem = item
        }
    }
    fun setAt(index:Int,item: T) {
        if(index > size || index < 0) throw IndexOutOfBoundsException("Invalid Index : $index")
        when(index) {
            0 -> setFirst(item)
            getSize() -> setLast(item)
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
    fun pop() {
        var head = headNode
        var prev : Node<T>? = null

        for (i in 0 until getSize()-1) {
            prev = head
            head = head?.nextNode
        }

        tailNode = prev
        size--
    }
    fun popAll() {
        headNode = null
        tailNode = null
        size = 0
    }

}
fun main() {

    StackBySLL<Any>().apply {

        push(10)
        push(11)
        push(12)

        println("${getSize()} | ${getAll().contentToString()} || ${getTail()} | ${getPeak()} ")

        setFirst(100)
        setLast(120)
        setAt(1,111)

        println("${getSize()} | ${getAll().contentToString()} | ${getPeak()}")

        pop()

        println("${getSize()} | ${getAll().contentToString()} | ${getPeak()}")

        popAll()

        println(getAll().contentToString())
    }
}
