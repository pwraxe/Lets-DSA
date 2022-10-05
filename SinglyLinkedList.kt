class NotFoundException(message: String) : RuntimeException(message)

class MasterLinkedList<G> {

    inner class Node<G> (
        internal var dataItem: G,
        internal var nextNode: Node<G>?
    )

    private var size : Int = 0
    private var headNode : Node<G>? = null
    private var tailNode : Node<G>? = null

    fun getSize() = size

    fun getHead() : G? = headNode?.dataItem
    fun getTail() : G? = tailNode?.dataItem

    fun readAll() : String {
        var items = ""
        var head = headNode
        for (index in 0 until size) {
            items += "${head?.dataItem}, "
            head = head?.nextNode
        }
        return items
    }

    fun addAtFirst(element: G) {

        if(headNode == null) {
            /***No Element in List, Create One assign head and tail*/
            Node<G>(element,null).apply {
                headNode = this
                tailNode = this
            }
            size++
        } else if (headNode?.nextNode == null) {
            /**We have only one element in list**/
            var head = headNode
            headNode = Node<G>(element,null) // OR Node<G>(element,head)
            headNode?.nextNode = head
            head = null
            size++
        } else {
            var head = headNode
            headNode = Node<G>(element,head)
            head = null
            size++
        }
    }

    fun addAtLast(element: G) {
        if(tailNode == null) {
            headNode = Node(element,null)
            tailNode = headNode
        } else {
            val tail = tailNode
            tailNode = Node<G>(element,null)
            tail?.nextNode = tailNode
        }
        size++
    }

    fun addAtIndex(index: Int,element: G) {

        if(index > size || index < 0) {
            throw IllegalArgumentException("Invalid Index : $index")
        }

        if(index == 0) {
            /**Add At first**/
            var head = headNode
            headNode = Node<G>(element,head)
            head = null
            size++
        } else {
            var head = headNode
            for (i in 0 until (index-1)) {
                head = head?.nextNode
            }
            val nextNode = head?.nextNode
            val newNode = Node<G>(element,nextNode)
            head?.nextNode = newNode
            size++
        }
    }

    fun getFirst() : G? = headNode?.dataItem

    fun getLast() : G? = tailNode?.dataItem

    fun getIndexElement(index: Int) : G? {
        if(index > size || index < 0) {
            throw IndexOutOfBoundsException("Invalid Index : $index")
        }
        var head = headNode
        for (i in 0..index) {
            head = head?.nextNode
        }
        return head?.dataItem
    }

    fun removeFirst() {
        if(headNode == null) {
            println("No Element Found to Remove")
        } else {
            if(headNode?.nextNode == null) {
                //Only one element in list
                headNode = null
                tailNode = null
            } else {
                //WE are know there is more than 2 element in list
                val head = headNode
                headNode = head?.nextNode
                size--
            }
        }
    }

    //WORKING FINE
    fun removeLast() {
        var head = headNode
        if(headNode == null) {
            println("No Element found to remove")
        } else {
            if(headNode?.nextNode == null) {
                /**we have only one element in list**/
                headNode = null
                tailNode = null
            } else {
                /**we have more than 1 element in list**/
                val lastIndex = size-1
                for (index in 0 until lastIndex-1) {
                    if(head?.nextNode != null)
                        head = head.nextNode
                }
                tailNode = head
            }
            size--
        }


    }

    //WORKING FINE
    fun removedFromIndex(index: Int) {
        if(index > size || index < 0) {
            throw IndexOutOfBoundsException("Invalid Index : $index")
        }

        when (index) {
            0 -> {
                //User wants to remove element at first
                removeFirst()
            }
            size -> {
                //User wants to remove element at last
                removeLast()
            }
            else -> {

                var head = headNode
                for (index in 0 until (index-1)) {
                    head = head?.nextNode
                }
                val itemToRemove = head?.nextNode
                //Next Element of item remove
                val nextElement = itemToRemove?.nextNode
                head?.nextNode = nextElement
                size--
            }
        }
    }

    //WORKING FINE
    fun removedFromElement(element: G) {
        if(headNode == null) {
            throw NotFoundException("No Elements Found, try add first then update")
        } else {
            if(headNode?.nextNode == null) {
                /**Only One Element in List**/
                if(headNode?.dataItem == element) {
                    headNode = null
                    tailNode = null
                    size--
                } else {
                    println("$element, Not Found in List")
                }
            } else {
                var head = headNode
                var prevNode : MasterLinkedList<G>.Node<G>? = null
                var nextNode : MasterLinkedList<G>.Node<G>? = null

                for (index in 0 until size) {
                    if(head?.dataItem == element) {
                        head = head?.nextNode
                        size--
                    } else {
                        prevNode = head
                        head = head?.nextNode  //OR prevNode.newNode
                        nextNode = head?.nextNode

                        if(head?.dataItem == element) {
                            prevNode?.nextNode = nextNode
                            head = nextNode
                            nextNode = head?.nextNode
                            size--
                        } else {
                            prevNode = head
                            head = nextNode
                            nextNode = head?.nextNode
                        }
                    }
                }
            }
        }
    }

    //WORKING FINE
    fun updateFirst(element: G) {
        if(headNode == null) {
            throw NotFoundException("No Elements Found, try add first then update")
        } else {
            headNode?.dataItem = element
        }
    }
    //----------------------------------------

    //Update
    fun updateLast(element: G) {
        if(tailNode == null) {
            throw NotFoundException("No Elements Found, try add first then update")
        } else {
            tailNode?.dataItem = element
        }
    }
    fun updateAtIndex(index: Int,element: G) {
        var head = headNode
        val prevIndex = index-1
        for (i in 0..prevIndex) {
            head = head?.nextNode
        }
        head?.dataItem = element
    }

    fun searchOnceByElement(element: G) {

        if(headNode == null) {
            throw NotFoundException("No Elements in list to search")
        } else {
            var head = headNode

            for (index in 0 until size) {
                if(head?.dataItem == element) {
                    println("Element Found at Location $index")
                    break
                }
                head = head?.nextNode
            }
        }
    }
    fun searchAllElements(element: G) {
        if(headNode == null) {
            throw NotFoundException("No Elements in list to search")
        } else {
            var head = headNode
            var elementIndexes = ""
            for (index in 0 until size) {
                if(head?.dataItem == element) {
                    elementIndexes += "$index, "
                }
                head = head?.nextNode
            }
            println("Elements Found at Location : $elementIndexes")
        }
    }

}

fun main() {

    MasterLinkedList<Int?>().apply {
        println("1 ---> Head ${getHead()} | Tail : ${getTail()}")
        addAtFirst(111)
        println("2 ---> Head ${getHead()} | Tail : ${getTail()}")
        addAtFirst(222)
        println("3 ---> Head ${getHead()} | Tail : ${getTail()}")
        addAtFirst(333)
        println("4 ---> Head ${getHead()} | Tail : ${getTail()}")
        addAtFirst(99)
        println("5 ---> Head ${getHead()} | Tail : ${getTail()}")
        addAtFirst(88)
        println("6 ---> Head ${getHead()} | Tail : ${getTail()}")

        println("Add At First : ${getSize()} || ${readAll()}\n\n\n")

        addAtLast(444)
        println("7 ---> Head ${getHead()} | Tail : ${getTail()}")
        addAtLast(555)
        println("8 ---> Head ${getHead()} | Tail : ${getTail()}")
        addAtLast(666)
        println("9 ---> Head ${getHead()} | Tail : ${getTail()}")
        addAtLast(777)
        println("10 ---> Head ${getHead()} | Tail : ${getTail()}")
        addAtLast(888)
        println("11 ---> Head ${getHead()} | Tail : ${getTail()}")
        addAtLast(999)
        println("12 ---> Head ${getHead()} | Tail : ${getTail()}")
        println("Add at Last : ${getSize()} || ${readAll()}\n\n\n")


        addAtIndex(3, 100)
        println("13 ---> Head ${getHead()} | Tail : ${getTail()}")
        addAtIndex(5, 500)
        println("14 ---> Head ${getHead()} | Tail : ${getTail()}")
        println("Add At Index : ${getSize()} || ${readAll()}\n\n\n")

        println("First : ${getFirst()} | Last : ${getLast()} | Index 3 : ${getIndexElement(3)}")
        println("15 ---> Head ${getHead()} | Tail : ${getTail()}")
        println("${getSize()} || List : ${readAll()}")

        removeFirst()
        println("16 ---> Head ${getHead()} | Tail : ${getTail()}")
        println("${getSize()} | rm 1st : ${readAll()}\n\n\n")

        removeLast()
        println("17 ---> Head ${getHead()} | Tail : ${getTail()}")
        println("${getSize()} | rmLst : ${readAll()}\n\n\n")

        removedFromIndex(2) //Check this
        println("16 ---> Head ${getHead()} | Tail : ${getTail()}")
        println("Removed From Index 2 : ${readAll()}\n\n\n")

        removedFromElement(500)
        println("17 ---> Head ${getHead()} | Tail : ${getTail()}")
        println("After Removed 500 : ${readAll()}\n\n\n")

        println("\n\n Start Updating")
        println("Current List : ${getSize()} || ${readAll()}\n\n\n")


        updateFirst(9999)
        println("18 ---> Head ${getHead()} | Tail : ${getTail()}")
        println("Current List : ${getSize()} || ${readAll()}\n\n\n")

        updateLast(8080)
        println("19 ---> Head ${getHead()} | Tail : ${getTail()}")
        println("Current List : ${getSize()} || ${readAll()}\n\n\n")

        updateAtIndex(3, 5000)
        println("20 ---> Head ${getHead()} | Tail : ${getTail()}")
        println("After Update : ${readAll()}\n\n\n")

        searchAllElements(444)
        searchOnceByElement(8080)
    }

}
