class Queue<T> {
    private val elements = mutableListOf<T?>()
    fun enQ(item: T?) {
        elements.add(item)
    }
    fun deQ(): T? {
        return elements.removeFirstOrNull()
    }
    fun isEmpty() : Boolean = elements.isEmpty()
}
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
    fun levelOrderTraversal(node: Node?) {
        node ?: return
        val queue = Queue<Node>()
        queue.enQ(node)
        queue.enQ(null)
        while (!queue.isEmpty()) {
            val currentNode = queue.deQ()
            if(currentNode == null) {
                println()
                if (queue.isEmpty()) break else queue.enQ(null)
            } else {
                print("${currentNode.item}, ")
                currentNode.leftNode?.let { queue.enQ(it) }
                currentNode.rightNode?.let { queue.enQ(it) }
            }
        }
    }
    fun countNodes(node: Node?): Int {
        node ?: return 0
        val leftCount = countNodes(node.leftNode)
        val rightCount = countNodes(node.rightNode)
        return leftCount+rightCount+1
    }
    fun sumOfNodes(node: Node?) : Int {
        node ?: return 0

        val leftSum = sumOfNodes(node.leftNode)
        val rightSum = sumOfNodes(node.rightNode)
        return leftSum + rightSum + node.item
    }
    fun heightOfTree(node:Node?): Int {
        node ?: return 0
        val leftHeight = heightOfTree(node.leftNode)
        val rightHeight = heightOfTree(node.rightNode)
        return Math.max(leftHeight, rightHeight) + 1
    }

    //O(n*n)
    fun getTreeDiameter(node: Node?): Int {
        node ?: return 0
        val left = getTreeDiameter(node.leftNode)
        val right = getTreeDiameter(node.rightNode)
        val dim = heightOfTree(node.leftNode) + heightOfTree(node.rightNode)
        return Math.max(dim, Math.max(left,right))
    }

    //O(n)
    data class TreeInfo(val height: Int, val diameter: Int)
    fun getTreeDiameter2(node: Node?): TreeInfo {
        node ?: return TreeInfo(0,0)
        val left = getTreeDiameter2(node.leftNode)
        val right = getTreeDiameter2(node.rightNode)

        val height = left.height + right.height + 1
        val maxD = Math.max(Math.max(left.diameter,right.diameter),height)
        return TreeInfo(height,maxD)
    }
}

fun main() {
    BinaryTree().apply {
        val tree = buildBinaryTree(listOf(8,4,2,null,null,6,5,null,null,7,null,null,10,9,null,null,12,null,null))
        //inOrderTraversal(tree)
        levelOrderTraversal(tree)
        println("Total Nodes: ${countNodes(tree)}")
        println("Sum of Nodes: ${sumOfNodes(tree)}")
        println("Height: ${heightOfTree(tree)}")
        println("Diameter: ${getTreeDiameter(tree)}")
        println("Diameter2: ${getTreeDiameter2(tree)}")
    }
}
