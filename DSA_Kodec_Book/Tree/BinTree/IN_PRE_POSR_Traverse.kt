typealias Visitor<T> = (T) -> Unit

class LetsBinaryTree<T> (private val dataItem: T) {
    var leftNode : LetsBinaryTree<T>? = null
    var rightNode : LetsBinaryTree<T>? = null

    
    //Traverse : Left --> Root --> Right
    fun letsDo_IN_OrderTraverse(visitor: Visitor<T>) {
        leftNode?.letsDo_IN_OrderTraverse(visitorvisitor)
        visitor(dataItem)
        rightNode?.letsDo_IN_OrderTraverse(visitor)
    }

    //Traverse : Root --> Left --> Right
    fun letsDo_PRE_Order(visitor: Visitor<T>) {
        visitor(dataItem)
        leftNode?.letsDo_PRE_Order(visitor)
        rightNode?.letsDo_PRE_Order(visitor)
    }

    //Traverse : Left --> Right --> root
    fun letsDo_POST_Order(visitor: Visitor<T>) {
        leftNode?.letsDo_POST_Order(visitor)
        rightNode?.letsDo_POST_Order(visitor)
        visitor(dataItem)
    }
}

fun main() {
    val root = LetsBinaryTree(1)
    val node2 = LetsBinaryTree(2)
    val node3 = LetsBinaryTree(3)
    val node4 = LetsBinaryTree(4)
    val node5 = LetsBinaryTree(5)
    val node6 = LetsBinaryTree(6)
    val node7 = LetsBinaryTree(7)
    val node8 = LetsBinaryTree(8)
    val node9 = LetsBinaryTree(9)
    val node10 = LetsBinaryTree(10)
    val node11 = LetsBinaryTree(11)

    root.leftNode = node2
    root.rightNode = node3

    node2.leftNode = node4
    node2.rightNode = node5

    node3.leftNode = node6
    node3.rightNode = node7

    node4.leftNode = node8

    node6.leftNode = node9

    node7.leftNode = node10
    node7.rightNode = node11

    //Correct in Sequence
    println("------------------------- In Order")
    root.letsDo_IN_OrderTraverse { print("$it ") }

    //Correct In Sequence
    println("\n------------------------- Pre Order")
    root.letsDo_PRE_Order { print("$it ") }

    //Correct In Sequence
    println("\n------------------------- Post Order")
    root.letsDo_POST_Order { print("$it ") }
}

//OUTPUT
/**
 *
------------------------- In Order
8 4 2 5 1 9 6 3 10 7 11
------------------------- Pre Order
1 2 4 8 5 3 6 9 7 10 11
------------------------- Post Order
8 4 5 2 9 6 10 11 7 3 1
 * **/
