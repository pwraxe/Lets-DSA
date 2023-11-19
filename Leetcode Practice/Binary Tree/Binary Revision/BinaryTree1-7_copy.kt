data class TreeNode(var dataItem: Int, var leftNode: TreeNode? = null, var rightNode: TreeNode? = null)
class Solution {

    fun add(item: Int, node:TreeNode?): TreeNode {
        node ?: return TreeNode(item)
        if (item > node.dataItem) {
            node.rightNode = add(item, node.rightNode)
        } else {
            node.leftNode = add(item, node.leftNode)
        }
        return node
    }
    fun remove(item: Int, node: TreeNode?): TreeNode? {
        node ?: return null
        when {
            item > node.dataItem -> remove(item,node.rightNode)
            item < node.dataItem -> remove(item, node.leftNode)
            else -> {
                //Condition 1 : Leaf Node || Node with no child
                if (node.leftNode == null && node.rightNode == null) return null

                //Condition 2 : Node has 1 child, either left or right
                if (node.leftNode == null) return node.rightNode
                if (node.rightNode == null) return node.leftNode

                //Condition 3 : Node has 2 Child
                //Way 1: Max Node of Left Sub Tree, Not Deleting, NOT WORKING AS EXPECTED
//                var leftMax = node.leftNode
//                while (leftMax?.rightNode != null) {
//                    leftMax = leftMax.rightNode
//                }
//                node.dataItem = leftMax?.dataItem ?: 0
//                node.leftNode = remove(node.dataItem, node.leftNode)


                //====================================================================
//                Way 2: Min Node of Right Sub Tree
                var rightMin = node.rightNode
                while (rightMin?.leftNode != null) {
                    rightMin = rightMin.leftNode
                }
                node.dataItem = rightMin?.dataItem ?: 0
                node.rightNode = remove(node.dataItem, node.rightNode)
            }
        }
        return node
    }
    fun search(item: Int, node: TreeNode?): Boolean {
        node ?: return false
        if (node.dataItem == item) return true
        return search(item, node.leftNode) || search(item, node.rightNode)

    }

    var index = -1
    fun serializedTree(node: TreeNode?, text: StringBuilder) : String {
        node ?: run {
            text.append("# ")
            return text.toString()
        }

        text.append("${node.dataItem} ")
        serializedTree(node.leftNode,text)
        serializedTree(node.rightNode,text)
        return text.toString()
    }
    fun deSerializedTree(list: List<String>): TreeNode? {
        index++
        if (list[index] == "#") return null
        val newNode = TreeNode(list[index].toInt())
        newNode.leftNode = deSerializedTree(list)
        newNode.rightNode = deSerializedTree(list)
        return newNode
    }

    fun preOrderTraverse(node:TreeNode?) {
        node ?: return
        print("${node.dataItem}, ")
        preOrderTraverse(node.leftNode)
        preOrderTraverse(node.rightNode)
    }
    fun inOrderTraverse(node: TreeNode?) {
        node ?: return
        inOrderTraverse(node.leftNode)
        print("${node.dataItem}, ")
        inOrderTraverse(node.rightNode)
    }
    fun postOrderTraverse(node: TreeNode?) {
        node ?: return
        postOrderTraverse(node.leftNode)
        postOrderTraverse(node.rightNode)
        print("${node.dataItem}, ")
    }
    fun levelOrderTraversal(root: TreeNode?) {
        val queue = mutableListOf<TreeNode?>()
        val list = mutableListOf<Int>()

        queue.add(root)

        while (queue.isNotEmpty()) {
            val node = queue.removeFirstOrNull()
            if (node != null) {
                list.add(node.dataItem)
                queue.add(node.leftNode)
                queue.add(node.rightNode)
            }
        }
        println("Level Order: ${list.toTypedArray().contentToString()}")
    }
    fun levelOrderTree(root: TreeNode?) {
        val list = mutableListOf<List<Int>>()
        val subList = mutableListOf<Int>()

        val queue = mutableListOf<TreeNode?>()
        queue.add(root)
        queue.add(null)
        while (queue.isNotEmpty()) {
            val node = queue.removeFirstOrNull()
            if (node == null) {
                list.add(subList.toList())
                subList.clear()
                if (queue.isEmpty()) break else queue.add(null)
            } else {
                subList.add(node.dataItem)
                node?.leftNode?.let { queue.add(it) }
                node.rightNode?.let { queue.add(it) }
            }
        }

        list.forEach {
            println(it.toTypedArray().contentToString())
        }
    }

    fun countNode(node: TreeNode?) : Int {
        node ?: return 0
        val left = countNode(node.leftNode)
        val right = countNode(node.rightNode)
        return left + right + 1
    }
    fun sumOfNodes(node:TreeNode?) : Int {
        node ?: return 0
        val left = sumOfNodes(node.leftNode)
        val right = sumOfNodes(node.rightNode)
        return left + right + node.dataItem
    }
    fun maxDepth(node: TreeNode?) : Int {
        node ?: return 0
        val left = maxDepth(node.leftNode)
        val right = maxDepth(node.rightNode)
        return Math.max(left,right) + 1
    }
}

fun main() {
    Solution().apply {
        var rootNode: TreeNode? = null
        listOf(8,4,5,7,9,6,2,1,3).forEach {
            rootNode = add(it,rootNode)
        }

        println("Nodes Traversal Before Delete 4")
        print("PreOrder: ")
        preOrderTraverse(rootNode)
        println()
        print("InOrder: ")
        inOrderTraverse(rootNode)
        println()
        print("PostOrder: ")
        postOrderTraverse(rootNode)
        println()
        levelOrderTraversal(rootNode)
        println()

        remove(4,rootNode)

        println("Nodes Traversal After Delete 4")
        print("PreOrder: ")
        preOrderTraverse(rootNode)
        println()
        print("InOrder: ")
        inOrderTraverse(rootNode)
        println()
        print("PostOrder: ")
        postOrderTraverse(rootNode)
        println()
        levelOrderTraversal(rootNode)
        println()
        levelOrderTree(rootNode)
        val k = 50
        println("is $k available? = ${search(k,rootNode)}")
        println("Serialized | DeSerialized")

        val text = serializedTree(rootNode, StringBuilder())
        println(text)
        val newRoot = deSerializedTree(text.split(" "))
        print("After Serialized DeSerialised, PreOrder: ")
        preOrderTraverse(newRoot)

        println("\n")
        println("Total Nodes: ${countNode(rootNode)}")
        println("Sum of Nodes : ${sumOfNodes(rootNode)}")
        println("Max Depth : ${maxDepth(rootNode)}")
    }
}
