import java.util.ArrayDeque
import kotlin.math.max

data class Node(
    val item:Int,
    var left: Node? = null,
    var right: Node? = null)

class BinaryTree {

    private var index = -1

    fun buildTree(list: List<Int>): Node? {
        index++
        if (list[index] == -1) return null
        val node = Node(list[index])
        node.left = buildTree(list)
        node.right = buildTree(list)
        return node
    }
    fun preOrderTraversal(node: Node?, list:MutableList<Int>): List<Int> {
        node ?: return list
        list.add(node.item)
        preOrderTraversal(node.left, list)
        preOrderTraversal(node.right, list)
        return list
    }
    fun inOrderTraversal(node: Node?, list: MutableList<Int>): List<Int> {
        node ?: return list
        inOrderTraversal(node.left, list)
        list.add(node.item)
        inOrderTraversal(node.right,list)
        return list
    }
    fun postOrderTraversal(node: Node?, list: MutableList<Int>): List<Int> {
        node ?: return list
        postOrderTraversal(node.left, list)
        postOrderTraversal(node.right, list)
        list.add(node.item)
        return list
    }
    fun levelOrderTraversal1(root: Node?): List<Int> {
        val queue = ArrayDeque<Node?>()
        val list = mutableListOf<Int>()
        queue.offer(root)

        while (queue.isNotEmpty()) {
            val node = queue.poll()
            list.add(node!!.item)
            node.left?.let { queue.offer(it) }
            node.right?.let { queue.offer(it) }
        }
        return list
    }
    fun levelOrderTraversal2(root: Node) {
        val queue = ArrayDeque<Node>()
        queue.offer(root)
        queue.offer(Node(-1))
        while (queue.isNotEmpty()) {
            val node = queue.poll()
            if (node.item == -1) {
                println()
                //Add Dummy Node at end if queue not empty
                if (queue.isEmpty()) break else queue.offer(Node(-1))
            }else {
                print("${node.item} ")
                node.left?.let { queue.offer(it) }
                node.right?.let { queue.offer(it) }
            }
        }
    }


    fun heightOfTree(root: Node?): Int {
        root ?: return 0
        val left = heightOfTree(root.left)
        val right = heightOfTree(root.right)
        return 1 + max(left,right)
    }
    fun countNodes(root: Node?): Int {
        root ?: return 0
        val left = countNodes(root.left)
        val right = countNodes(root.right)
        return 1 + left + right
    }
    fun sumOfNodes(root: Node?): Int {
        root ?: return 0
        val left = sumOfNodes(root.left)
        val right = sumOfNodes(root.right)
        return left + right + root.item
    }
}

fun main() {
    BinaryTree().apply {
        val list = listOf(1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1)
        val root = buildTree(list)


        println("Pre-Order: ${preOrderTraversal(root, mutableListOf()).toTypedArray().contentToString()}")
        println("In-Order: ${inOrderTraversal(root, mutableListOf()).toTypedArray().contentToString()}")
        println("Post-Order: ${postOrderTraversal(root, mutableListOf()).toTypedArray().contentToString()}")
        println("Level-Order: ${levelOrderTraversal1(root).toTypedArray().contentToString()}")
        levelOrderTraversal2(root!!)

        println("Height: ${heightOfTree(root)}")
        println("Count Nodes: ${countNodes(root)}")
        println("Sum of Nodes: ${sumOfNodes(root)}")
    }
}

//==========================================OUTPUT=================================
Pre-Order: [1, 2, 4, 5, 3, 6]
In-Order: [4, 2, 5, 1, 3, 6]
Post-Order: [4, 5, 2, 6, 3, 1]
Level-Order: [1, 2, 3, 4, 5, 6]
1 
2 3 
4 5 6 
Height: 3
Count Nodes: 6
Sum of Nodes: 21
