class BinaryTree {

    data class Node(var item: Int) {
        var leftNode: Node? = null
        var rightNode: Node? = null
    }

    private var index: Int = -1
    fun buildBinaryTree(list: List<Int?>): Node? {
        index++
        list[index] ?: return null

        val newNode = Node(list[index]!!)
        newNode.leftNode = buildBinaryTree(list)
        newNode.rightNode = buildBinaryTree(list)
        return newNode
    }

    fun inOrderTraversal(node:Node?) {
        node ?: return

        inOrderTraversal(node.leftNode)
        print("${node?.item}, ")
        inOrderTraversal(node.rightNode)
    }
}

fun main() {
    BinaryTree().apply {
        val tree = buildBinaryTree(listOf(8,4,2,null,null,6,5,null,null,7,null,null,10,9,null,null,12,null,null))

        //2, 4, 5, 6, 7, 8, 9, 10, 12
        inOrderTraversal(tree)
    }
}
