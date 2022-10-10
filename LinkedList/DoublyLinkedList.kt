
class NoElementsException(message: String) : RuntimeException(message)

class LetsDoublyLinkedList<G> {

    inner class Node<G>(
        internal var previousNode : Node<G>?,
        internal var dataItem: G?,
        internal var nextNode: Node<G>?
    )

    private var size: Int = 0
    private var headNode : Node<G>? = null
    private var tailNode : Node<G>? = null
    
    fun getHeadAndTail() = "Size : ${getSize()} || Head : ${headNode?.dataItem}  |  Tail : ${tailNode?.dataItem}"
    
    fun getSize() = size
    
    fun getElementAt(index: Int): Node<G>? {
        var head = headNode
        for (i in 0 until index) {
            head = head?.nextNode
        }
        return head
    }
    
    fun addFirst(element:G) {

        if(headNode == null) {
            /**We have No Element in list**/
            Node<G>(null,element,null).apply {
                headNode = this
                tailNode = this
            }
        } else {
            val head = headNode
            headNode = Node<G>(null,element,head)
            head?.previousNode = headNode?.nextNode
        }
        size++
    }
    
    fun addLast(element: G) {
        if(headNode == null) {
            /**We have No Element in list**/
            Node<G>(null,element,null).apply {
                headNode = this
                tailNode = this
            }
        } else {
            val tail = tailNode
            tailNode = Node<G>(tail,element,null)
            tail?.nextNode = tailNode
        }
        size++
    }
    
    fun addAtIndex(index: Int,element: G) {
        if (index > size || index < 0) {
            throw IndexOutOfBoundsException("Invalid Index : $index")
        }
        when(index) {
            0 -> addFirst(element)
            size -> addLast(element)
            else -> {
                var head = headNode
                for (i in 0 until index-1) {
                    head = head?.nextNode
                }
                val nextOfHead = head?.nextNode
                val newNode = Node<G>(head,element,nextOfHead)
                head?.nextNode = newNode
                size++
            }
        }
    }
    
    fun removeFirst() {
        if(headNode != null) {
            headNode = headNode?.nextNode
            size--
        } else {
            throw NoElementsException("Empty List")
        }
    }
    
    fun removeLast() {
        if (tailNode == null) {
            throw NoElementsException("No Elements in List to remove")
        }
        tailNode = tailNode?.previousNode
        size--
    }
    
    fun removeAt(index: Int) {
        if(index > size || index < 0) {
            throw IndexOutOfBoundsException("Invalid Index : $index")
        }
        var head = headNode
        for (i in 0 until index) {
            head = head?.nextNode
        }
        val prevNode = head?.previousNode
        val nextNode = head?.nextNode
        prevNode?.nextNode = nextNode
        size--
    }
    
    fun removeElement(element: G) {

        if(headNode != null) {
            var head = headNode
            var nextNode : Node<G>? = null
            var prevNode : Node<G>? = null

            for (index in 0 until size) {
                if(head?.dataItem == element) {
                    break
                } else {
                    prevNode = head
                    head = head?.nextNode
                }
            }
            nextNode = head?.nextNode
            prevNode?.nextNode = nextNode
            size--
        } else {
            throw NoElementsException("No Element Found to remove")
        }
    }
    
    fun updateFirst(element: G){
        if(headNode == null) {
            throw NoSuchElementException("No Element Found to Update")
        } else {
            headNode?.dataItem = element
        }
    }
    
    fun updateLast(element: G){
        if(tailNode == null) {
            throw NoSuchElementException("No Element Found to Update")
        } else {
            tailNode?.dataItem = element
        }
    }
    
    fun updateAt(index: Int,element: G){

        if(index > size || index < 0) {
            throw IndexOutOfBoundsException("Invalid index : $index")
        }

        when(index){
            0 -> updateFirst(element)
            size -> updateLast(element)
            else -> {
                var head = headNode
                for (i in 0 until index) {
                    head = head?.nextNode
                }
                head?.dataItem = element
            }
        }
    }
    
    fun cleanAll() {

        if(headNode == null) {
            throw NoElementsException("No Elements Found to clean")
        }
        var head = headNode
        for (index in 0 until size) {
            head?.dataItem = null
            head = head?.nextNode
        }
    }
    
    fun removeAll(){
        headNode = null
        tailNode = null
        size = 0
    }
}

fun main() {

    LetsDoublyLinkedList<Int>().apply {
        addFirst(300)
        addFirst(200)
        addFirst(100)

        addLast(400)
        addLast(200)
        addLast(600)

        addAtIndex(0,50)
        addAtIndex(getSize(),650)

        addAtIndex(3,250)

        removeFirst()
        removeLast()
        removeAt(2)

        updateFirst(11)
        updateLast(55)

        updateAt(0,110)
        updateAt(3,444)
        updateAt(getSize(),555)

        removeElement(300)

        cleanAll()
        removeAll()

        println(getHeadAndTail())
        val list = Array<Any?>(getSize()){ 0 }
        for (index in 0 until getSize()) {
            list[index] = getElementAt(index)?.dataItem
        }
        println(list.contentToString())
    }
}


/**    //CHECK CODE AGAIN, WRONG OUTPUT
fun removeAllElements(element: G) {
var temp = Node<G>(null,10 as G,headNode)

if (headNode != null) {
while (headNode?.nextNode != null) {

if(headNode?.dataItem == element) {
temp?.nextNode = headNode?.nextNode
headNode = headNode?.nextNode
size--
} else {
temp = headNode as Node
headNode = headNode?.nextNode
}
}
} else {
throw NoElementsException("No Element Found to remove")
}
}*/
