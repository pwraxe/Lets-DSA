//Leetcode: Design SLL 
//After Giving Appx 2 Days and + 4Hrs :(

data class Node(val item: Int, var prev: Node? = null, var next: Node? = null)

class MyLinkedList {

    private var headNode: Node? = null
    private var tailNode: Node? = null
    private var size : Int = 0

    fun get(index: Int): Int {
        if(index > size || index < 0) return -1
        var node = headNode
        for(i in 0 until index) {
            node = node?.next
        }
        return node?.item ?: -1
    }

    fun addAtHead(`val`: Int) {
        val newNode = Node(`val`)
        if(headNode == null) {
            headNode = newNode
            tailNode = newNode
        } else {
            newNode.next = headNode
            headNode = newNode
        }
        size++
    }

    fun addAtTail(`val`: Int) {
        val newNode = Node(`val`)
        if(tailNode == null) {
            headNode = newNode
            tailNode = newNode
        } else {
            tailNode?.next = newNode
            tailNode = newNode
        }
        size++
    }

    fun addAtIndex(index: Int, `val`: Int) {
        if(index > size || index < 0) return

        when (index) {
            0 -> addAtHead(`val`)
            size -> addAtTail(`val`)
            in 1 until size -> {
                var node = headNode
                for(i in 0 until index-1) {
                    node = node?.next
                }

                val nextNode = node?.next
                val newNode= Node(`val`)
                node?.next = newNode
                newNode.next = nextNode
                size++
            }
        }
    }

    fun getMeta() = "H: ${headNode?.item} | T: ${tailNode?.item} | Size: ${size} "
    fun deleteAtIndex(index: Int) {
        if(index >= size || index < 0) return

        //index : 30 | size = 31
        when (index) {
            0 -> {
                //Remove Head
                if(headNode != null && headNode?.next != null) {
                    headNode = headNode?.next
                    size--
                } else if(headNode?.next == null) {
                    //Last Node remain
                    headNode = null
                    tailNode = null
                    size = 0
                }
            }
            size-1 -> {
                //Remove Tail
                //Check for single node
                if(tailNode == headNode) {
                    //we have only one node
                    headNode = null
                    tailNode = null
                    size = 0
                } else {
                    var node = headNode
                    var position = 0
                    while (position < index-1) {
                        node = node?.next
                        position++
                    }
                    tailNode = node
                    tailNode?.next = null
                    size--
                }
            }
            else -> {
                //Remove In Middle
                var node = headNode

                for (i in 0 until index-1) {
                    node = node?.next
                }
                //1->2
                node?.next = node?.next?.next
                size--
            }
        }
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * var obj = MyLinkedList()
 * var param_1 = obj.get(index)
 * obj.addAtHead(`val`)
 * obj.addAtTail(`val`)
 * obj.addAtIndex(index,`val`)
 * obj.deleteAtIndex(index)
 */
