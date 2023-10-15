//Binary Tree
//Insert Node, Read PreOrder, InOrder, PostOrder

data class Node(val item: Int) {
    var leftNode : Node? = null
    var rightNode : Node? = null
}

class BinaryTree {

    fun insert(item: Int, node: Node?) : Node {
        node ?: return Node(item)
        if (item > node.item) {
            //right side
            node.rightNode = insert(item,node.rightNode)
        } else {
            //left side
            node.leftNode = insert(item, node.leftNode)
        }
        return node
    }

    fun readByPreOrder(node: Node?) {
        node ?: return
        print("${node.item} ")
        readByPreOrder(node.leftNode)
        readByPreOrder(node.rightNode)
    }

    fun readByInOrder(node: Node?) {
        node ?: return
        readByInOrder(node.leftNode)
        print("${node.item} ")
        readByInOrder(node.rightNode)
    }

    fun readByPostOrder(node:Node?) {
        node ?: return
        readByPostOrder(node.leftNode)
        readByPostOrder(node.rightNode)
        print("${node.item} ")
    }

}


fun main() {
    BinaryTree().apply {
        val list = listOf(4,3,8,5,2,6,1)
        var root: Node? = null
        list.forEach {
            root = insert(it,root)
        }
        println("PreOrder: ")
        readByPreOrder(root)

        println("\nInOrder: ")
        readByInOrder(root)

        println("\nPostOrder: ")
        readByPostOrder(root)
    }
}
