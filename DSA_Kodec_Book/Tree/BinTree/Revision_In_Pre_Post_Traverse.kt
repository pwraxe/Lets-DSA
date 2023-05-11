import kotlin.math.max

typealias Visitor<T> = (T) -> Unit
class LetsBinTree<T>(val dataItem: T) {
    var leftNode : LetsBinTree<T>? = null
    var rightNode : LetsBinTree<T>? = null

    fun letsDoPreOrderTraverse(visitor: Visitor<T>) {
        visitor(dataItem)
        leftNode?.letsDoPreOrderTraverse(visitor)
        rightNode?.letsDoPreOrderTraverse(visitor)
    }

    fun letsDoInOrderTraverse(visitor: Visitor<T>) {
        leftNode?.letsDoInOrderTraverse(visitor)
        visitor(dataItem)
        rightNode?.letsDoInOrderTraverse(visitor)
    }

    fun letsDoPostOrderTraverse(visitor: Visitor<T>) {
        leftNode?.letsDoPostOrderTraverse(visitor)
        rightNode?.letsDoPostOrderTraverse(visitor)
        visitor(dataItem)
    }

    fun letsFindMaxSizeOfTree(node: LetsBinTree<T>? = this) : Int {
        return node?.let { 1+ max(letsFindMaxSizeOfTree(node.leftNode), letsFindMaxSizeOfTree(node.rightNode)) } ?: -1
    }
}

fun main() {
    val root = LetsBinTree(1)
    val node2 = LetsBinTree(2)
    val node3 = LetsBinTree(3)
    val node4 = LetsBinTree(4)
    val node5 = LetsBinTree(5)
    val node6 = LetsBinTree(6)
    val node7 = LetsBinTree(7)
    val node8 = LetsBinTree(8)
    val node9 = LetsBinTree(9)
    val node10 = LetsBinTree(10)
    val node11 = LetsBinTree(11)

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

    println("Pre Order : ")
    root.letsDoPreOrderTraverse {
        print("$it, ")
    }

    println("\nIn Order : ")
    root.letsDoInOrderTraverse {
        print("$it, ")
    }

    println("\nPost Order : ")
    root.letsDoPostOrderTraverse {
        print("$it, ")
    }
    println("\nHeight Of Tree : ${root.letsFindMaxSizeOfTree(root)}")
}
