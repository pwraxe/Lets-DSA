data class TreeNode(val item: Int, val parentNode: TreeNode? = null) {
    var leftNode: TreeNode? = null
    var rightNode: TreeNode? = null
}

class BinaryTree {

    fun insertNode(item: Int, node:TreeNode?) : TreeNode {
        if(node == null) {
            return TreeNode(item)
        }
        if(item > node.item) {
            node.rightNode = insertNode(item, node.rightNode)
        } else {
            node?.leftNode = insertNode(item, node.leftNode)
        }
        return node
    }

    fun inOrderRead(node:TreeNode?) {
        node ?: return
        inOrderRead(node.leftNode)
        print("${node.item} ")
        inOrderRead(node.rightNode)
    }
}

fun main() {
    BinaryTree().apply {
        var rootNode: TreeNode? = null
        listOf(8,7,3,5,4,1).forEach {
            rootNode = insertNode(it,rootNode)
        }

        //1 3 4 5 7 8 
        inOrderRead(rootNode)
        println()
    }
}
