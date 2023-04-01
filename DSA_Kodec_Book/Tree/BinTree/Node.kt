class LetsBinaryTree<T> (val dataItem: T) {
    var leftNode : LetsBinaryTree<T>? = null
    var rightNode : LetsBinaryTree<T>? = null
}

fun main() {
    val root = LetsBinaryTree(10)
    val node1 = LetsBinaryTree(1)
    val node2 = LetsBinaryTree(2)
    val node3 = LetsBinaryTree(3)
    val node4 = LetsBinaryTree(4)
    val node5 = LetsBinaryTree(5)

    root.leftNode = node1
    root.rightNode = node2

    node1.leftNode = node3
    node1.rightNode = node4
    
    node2.leftNode = node5
}
