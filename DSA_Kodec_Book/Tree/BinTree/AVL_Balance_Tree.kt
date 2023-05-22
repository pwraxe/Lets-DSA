import kotlin.math.max
import kotlin.math.pow

typealias Visitors<T> = (T) -> Unit

class TreeNode<T> (var dataItem : T) {

    var leftNode : TreeNode<T>? = null
    var rightNode: TreeNode<T>? = null

    var height  : Int = 0
    var leftHeight : Int = leftNode?.height ?: -1
    var rightHeight : Int = rightNode?.height ?: -1
    var balanceFactor = leftHeight - rightHeight

    var minValue : TreeNode<T>? = leftNode?.minValue ?: this

    fun preOrderTraverse(visitors: Visitors<T>) {
        visitors(dataItem)
        leftNode?.preOrderTraverse(visitors)
        rightNode?.preOrderTraverse(visitors)
    }
    fun inOrderTraverse(visitors: Visitors<T>){
        leftNode?.inOrderTraverse(visitors)
        visitors(dataItem)
        rightNode?.inOrderTraverse(visitors)
    }
    fun postOrderTraverse(visitors: Visitors<T>){
        leftNode?.postOrderTraverse(visitors)
        rightNode?.postOrderTraverse(visitors)
        visitors(dataItem)
    }

    fun leftRotation(node: TreeNode<T>): TreeNode<T>? {
        val pivot = node.rightNode
        node.rightNode = pivot?.leftNode
        pivot?.leftNode = node

        node.height = max(node.leftHeight, node.rightHeight) + 1
        pivot?.height = max(pivot?.leftHeight ?: -1, pivot?.rightHeight ?: -1) + 1
        return pivot
    }

    fun rightRotation(node: TreeNode<T>) : TreeNode<T>? {
        val pivot = node.leftNode
        node.leftNode = pivot?.rightNode
        pivot?.rightNode = node
        node.height = max(node.leftHeight,node.rightHeight) + 1
        pivot?.height = max(pivot?.leftHeight ?: -1, pivot?.rightHeight ?: -1) + 1
        return pivot
    }

    fun rightLeftRotation(node : TreeNode<T>) : TreeNode<T>? {
        val  rightNode = node.rightNode ?: return node
        node.rightNode = rightRotation(rightNode)
        return leftRotation(node)
    }

    fun leftRightRotation(node: TreeNode<T>) : TreeNode<T>? {
        val leftNode = node.leftNode ?: return node
        node.leftNode = rightRotation(leftNode)
        return rightRotation(node)
    }

    fun balance( ) : TreeNode<T>? {

        return when {
            balanceFactor > 1 -> {
                if(balanceFactor < 0) leftRightRotation(this) else rightRotation(this)
            }
            balanceFactor < -1 -> {
                if(balanceFactor < -1) rightLeftRotation(this) else leftRotation(this)
            }
            else -> this
        }
    }
}

class BinaryTree<T : Comparable<T>> {
    private var rootNode: TreeNode<T>? = null

    fun insert(item: T) {
        rootNode = insertNode(rootNode, item)
    }
    private fun insertNode(node: TreeNode<T>?, item: T): TreeNode<T>? {
        node ?: return TreeNode(item)
        if(item < node.dataItem) {
            node.leftNode = insertNode(node.leftNode,item)
        } else {
            node.rightNode = insertNode(node.rightNode,item)
        }
        node.height = max(node.leftNode?.height ?: -1, node.rightNode?.height ?: -1) + 1
        return node.balance()
    }

    fun remove(item: T) {
        rootNode = removeNode(rootNode,item)
    }
    private fun removeNode(node: TreeNode<T>?, item: T) : TreeNode<T>? {
        node ?: return null
        when {
            node.dataItem == item -> {
                if(node.leftNode == null && node.rightNode == null) return null
                if(node.leftNode == null) return node.rightNode
                if(node.rightNode == null) return node.leftNode
                node.rightNode?.minValue?.dataItem?.let { node.dataItem = it }
            }
            item > node.dataItem -> node.rightNode = removeNode(node.rightNode,item)
            else -> node.leftNode = removeNode(node.leftNode,item)
        }

        val balanceNode = node.balance()
        balanceNode?.height = max(balanceNode?.leftHeight ?: -1, balanceNode?.rightHeight ?: -1) + 1
        return balanceNode
    }

    fun contains(item: T) : Boolean {
        var currentNode = rootNode
        while (currentNode != null) {
            if(currentNode.dataItem == item) {
                return true
            }
            currentNode = if(item < currentNode.dataItem) currentNode.leftNode else currentNode.rightNode
        }
        return false
    }

    fun printAll() {
        println("\nPre Order :")
        rootNode?.preOrderTraverse {
            print("$it, ")
        }
        println("\nIn Order :")
        rootNode?.inOrderTraverse {
            print("$it, ")
        }
        println("\nPost Order :")
        rootNode?.postOrderTraverse {
            print("$it, ")
        }
    }

    //Time Complexity : O(1)
    fun letsCountLeafNode(height: Int) : Int {
        return 2.0.pow(height).toInt()
    }

    //TimeComplexity : O(n)
    fun countNodes(height: Int) : Int {
        var totalNode = 0
        (0..height).forEach {
            totalNode += 2.0.pow(it).toInt()
        }
        return totalNode
    }

    //TimeComplexity : O(1)
    fun letsCountNodes(height: Int) : Int {
        return 2.0.pow(height+1).toInt() - 1
    }
}

fun main() {
    BinaryTree<Int>().apply {
        insert(10)
        insert(20)
        insert(30)
        insert(40)
        insert(50)
        insert(60)

        this.printAll()
        println("\nContains 40? : ${this.contains(40)}")
        println("\nContains 400? : ${this.contains(400)}")
        this.remove(30)
        this.printAll()
    }
}
