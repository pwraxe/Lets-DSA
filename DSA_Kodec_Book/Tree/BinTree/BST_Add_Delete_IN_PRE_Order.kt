typealias Visitors<T> = (T) -> Unit
class TreeNode<T>(var dataItem: T) {
    var leftNode : TreeNode<T>? = null
    var rightNode: TreeNode<T>? = null

    val min : TreeNode<T> = leftNode?.min ?: this

    fun inOrderTraverse(visitors: Visitors<T>) {
        leftNode?.inOrderTraverse(visitors)
        visitors(dataItem)
        rightNode?.inOrderTraverse(visitors)
    }

    fun preOrderTraverse(visitors: Visitors<T>) {
        visitors(dataItem)
        leftNode?.preOrderTraverse(visitors)
        rightNode?.preOrderTraverse(visitors)
    }
}

class BinarySearch<T : Comparable<T>> {
    private var rootNode:TreeNode<T>? = null

    fun insert(item:T) {
        rootNode = insertNode(rootNode,item)
    }
    private fun insertNode(node: TreeNode<T>?, item: T) : TreeNode<T> {

        node ?: return TreeNode(item)
        if(item < node.dataItem) {
            node.leftNode = insertNode(node.leftNode, item)
        } else {
            node.rightNode = insertNode(node.rightNode, item)
        }
        return node
    }

    fun remove(item: T) {
        rootNode = removeNodeAgain(rootNode, item)
    }


    private fun removeNodeAgain(node: TreeNode<T>?, item: T) : TreeNode<T>? {
        node ?: return null
        when {
            //If Node item and search item both same
            node.dataItem == item -> {
                //Case 1 : When to remove Leaf Node
                if(node.leftNode == null && node.rightNode == null) return null
                //Case 2 : When to remove left/right node
                if (node.leftNode == null) return node.rightNode
                if(node.rightNode == null) return node.leftNode

                //get minimum value of right subTree of node to deleted,
                node.rightNode?.min?.dataItem?.let { node.dataItem = it }
            }

            //item is less than node item
            item < node.dataItem -> {
                node.leftNode = removeNodeAgain(node.leftNode,item)
            }

            //item is grater than node item
            else -> {
                node.rightNode = removeNodeAgain(node.rightNode,item)
            }
        }
        return node
    }
    fun readByInOrder() {
        println("\nIn Order : ")
        rootNode?.inOrderTraverse {
            print("$it, ")
        }
        println("\nPre Order : ")
        rootNode?.preOrderTraverse {
            print("${it}, ")
        }
    }


    fun contains(item: T) : Boolean {

        var currentNode = rootNode

        while (currentNode != null) {
            if(currentNode.dataItem == item) {
                return true
            }
            currentNode = if (item < currentNode.dataItem) currentNode.leftNode
            else currentNode.rightNode
        }
        return false

        /****
        var isFound : Boolean = false
        rootNode?.letsDoPreOrderTraverse {
            if(it?.dataItem == item) {
                isFound = true
            }
        }
        return isFound
        ***/
    }
}

fun main() {
    BinarySearch<Int>().apply {
        insert(5)
        insert(7)
        insert(12)
        insert(21)
        insert(37)
        insert(50)
        insert(60)
        insert(15)

        readByInOrder()

        remove(50)
        
        readByInOrder()
    }
}
