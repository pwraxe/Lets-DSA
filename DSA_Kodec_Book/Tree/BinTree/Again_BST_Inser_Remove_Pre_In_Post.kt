typealias Visitor<T> = (T) -> Unit
class TreeNode<T> (var dataItem: T) {
    var leftNode: TreeNode<T>? = null
    var rightNode: TreeNode<T>? = null

    val minValue : TreeNode<T>
        get() = leftNode?.minValue ?: this
    
    override fun equals(other: Any?): Boolean {
        return if(other != null && other is TreeNode<*>) {
            this.dataItem == other.dataItem
            && this.leftNode == other.leftNode
            && this.rightNode == other.rightNode
        } else false
    }

    fun letsPreOrderTraversal(visitor: Visitor<T>){
        visitor(dataItem)
        leftNode?.letsPreOrderTraversal(visitor)
        rightNode?.letsPreOrderTraversal(visitor)
    }
    fun letsInOrderTraversal(visitor: Visitor<T>) {
        leftNode?.letsInOrderTraversal(visitor)
        visitor(dataItem)
        rightNode?.letsInOrderTraversal(visitor)
    }
    fun letsPostOrderTraversal(visitor: Visitor<T>) {
        leftNode?.letsPostOrderTraversal(visitor)
        rightNode?.letsPostOrderTraversal(visitor)
        visitor(dataItem)
    }
}

class BinaryTree<T : Comparable<T>> {
    private var rootNode : TreeNode<T>? = null

    fun insert(item: T) {
        rootNode = insertNode(rootNode,item)
    }
    private fun insertNode(node:TreeNode<T>?, item: T) : TreeNode<T> {
        node ?: return TreeNode(item)
        if(item < node.dataItem) {
            node.leftNode = insertNode(node.leftNode, item)
        } else {
            node.rightNode = insertNode(node.rightNode, item)
        }
        return node
    }

    fun remove(item: T) {
        rootNode = removeNode(rootNode,item)
    }
    private fun removeNode(node: TreeNode<T>?, item: T) : TreeNode<T>? {

        node ?: return null
        when {
            item == node.dataItem -> {
                //Leaf Node, OR Node with 0 child
                if(node.leftNode == null && node.rightNode == null) return null
                if(node.leftNode == null) return node.rightNode
                if(node.rightNode == null) return node.leftNode

                node.rightNode?.minValue?.dataItem?.let { node.dataItem = it }
            }
            item < node.dataItem -> {
                node.leftNode = removeNode(node.leftNode, item)
            }
            else -> {
                node.rightNode = removeNode(node.rightNode, item)
            }
        }
        return node
    }

    fun contains(item: T) : Boolean {
        var currentNode = rootNode
        while (currentNode != null) {
            if(currentNode.dataItem == item)
                return true
            currentNode = if(item < currentNode.dataItem) currentNode.leftNode else currentNode.rightNode
        }
        return false
    }

    fun printAll() {

        println("\nPre Order : ")
        rootNode?.letsPreOrderTraversal {
            print("$it, ")
        }

        println("\nIn Order : ")
        rootNode?.letsInOrderTraversal {
            print("$it, ")
        }

        println("\nPost Order : ")
        rootNode?.letsPostOrderTraversal {
            print("$it, ")
        }
    }

    //Challenge 1 :IsBST?
    fun isBST() : Boolean = isBinaryTree(rootNode, null, null)
    private fun isBinaryTree(node: TreeNode<T>?, min:T?,max:T?) : Boolean {

        //Base Code
        node ?: return true

        if(min != null && node.dataItem <= min) return false
        else if(max != null && node.dataItem > max) return false

        return isBinaryTree(node.leftNode,min, node.dataItem)
                && isBinaryTree(node.rightNode, node.dataItem, max)
    }

}

fun main() {
    BinaryTree<Int>().apply {
        insert(50)
        insert(10)
        insert(20)
        insert(60)
        insert(80)
        insert(30)
        insert(40)

        println("contains : ${contains(20)} | ${contains(120)} || ${isBST()}")
        printAll()

        remove(80)

        printAll()
    }
}


/****OUTPUT
contains : true | false
Pre Order : 
50, 10, 20, 30, 40, 60, 80, 
In Order : 
10, 20, 30, 40, 50, 60, 80, 
Post Order : 
40, 30, 20, 10, 80, 60, 50, 
**/
