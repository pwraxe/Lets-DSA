/**
 * DONE: 1. Insert
 * DONE: 2. Delete
 * DONE: 3. Read InOrder
 * DONE: 4. Read PreOrder
 * DONE: 5. Read PostOrder
 * DONE: 6. Read LevelOrder in single list
 * DONE: 7. Read LevelOrder in nested list
 * DONE: 8. Build Tree from String
 * DONE: 9. count nodes
 * DONE: 10. take sum of nodes
 * DONE: 11. max depth
 * DONE: 12. Search Node
 * **/

class Queue<T> {
    private val elements = mutableListOf<T?>()
    fun enQ(item: T?) { elements.add(item) }
    fun deQ(): T? = elements.removeFirstOrNull()
    fun isNotEmpty() = elements.isNotEmpty()
}
class BinaryTree {

    private var index: Int = -1
    data class TreeNode(var item: Int) {
        var leftNode: TreeNode? = null
        var rightNode: TreeNode? = null
    }

    fun insert(item: Int, node: TreeNode?): TreeNode {
        node ?: return TreeNode(item)

        if(item > node.item) {
            node.rightNode = insert(item, node.rightNode)
        } else {
            node.leftNode = insert(item, node.leftNode)
        }
        return node
    }
    fun delete(item: Int, node: TreeNode?) : TreeNode? {
        node ?: return null

        when {
            item > node.item -> node.rightNode = delete(item,node.rightNode)
            item < node.item -> node.leftNode = delete(item,node.leftNode)
            else -> {
                if(node.leftNode == null && node.rightNode == null) return null

                node.leftNode ?: return node.rightNode
                node.rightNode ?: return node.leftNode

                var mNode = node.rightNode
                while (mNode?.leftNode != null) {
                    mNode = mNode.leftNode
                }
                node.item = mNode?.item ?: 0
                node.rightNode = delete(item, node.rightNode)
            }
        }
        return node
    }
    fun serializedTree(node: TreeNode?, text:StringBuilder) : String {

        node ?: run {
            text.append("# ")
            return text.toString()
        }
        text.append("${node.item} ")
        serializedTree(node.leftNode,text)
        serializedTree(node.rightNode,text)
        return text.toString()
    }
    fun deSerializedTree(list: List<String>): TreeNode? {
        index++
        if(list[index] == "#") return null

        val newNode = TreeNode(list[index].toInt())
        newNode.leftNode = deSerializedTree(list)
        newNode.rightNode = deSerializedTree(list)
        return newNode
    }

    fun preOrder(node: TreeNode?) {
        node ?: return
        print("${node.item} ")
        preOrder(node.leftNode)
        preOrder(node.rightNode)
    }
    fun inOrder(node: TreeNode?) {
        node ?: return
        inOrder(node.leftNode)
        print("${node.item} ")
        inOrder(node.rightNode)
    }
    fun postOrder(node: TreeNode?) {
        node ?: return
        postOrder(node.leftNode)
        postOrder(node.rightNode)
        print("${node.item} ")
    }
    fun levelOrderSingleList(node: TreeNode?): List<Int> {
        val list = mutableListOf<Int>()
        val queue = Queue<TreeNode>()
        queue.enQ(node)

        while (queue.isNotEmpty()) {
            val treeNode = queue.deQ()
            list.add(treeNode?.item!!)
            treeNode.leftNode?.let { queue.enQ(it) }
            treeNode.rightNode?.let { queue.enQ(it) }
        }
        return list
    }
    fun levelOrderSubList(node:TreeNode?): List<List<Int>> {

        val list = mutableListOf<List<Int>>()
        val subList = mutableListOf<Int>()
        val queue = Queue<TreeNode?>()
        queue.enQ(node)
        queue.enQ(null)

        while (queue.isNotEmpty()) {
            val currentNode = queue.deQ()

            if(currentNode == null) {
                list.add(subList.toList())
                subList.clear()
                if(queue.isNotEmpty()) queue.enQ(null) else break
            } else {
                subList.add(currentNode.item)
                currentNode.leftNode?.let { queue.enQ(it) }
                currentNode.rightNode?.let { queue.enQ(it) }
            }
        }
        return list
    }

    fun countNode(node: TreeNode?):Int {
        node ?: return 0
        val left = countNode(node.leftNode)
        val right = countNode(node.rightNode)
        return left + right + 1
    }
    fun sumOfNodes(node: TreeNode?): Int {
        node ?: return 0
        val left = sumOfNodes(node.leftNode)
        val right = sumOfNodes(node.rightNode)
        return left + right + node.item
    }
    fun heightOfTree(node: TreeNode?): Int {
        node ?: return 0
        val left = heightOfTree(node.leftNode)
        val right = heightOfTree(node.rightNode)
        return 1 + Math.max(left,right)
    }
    fun searchNode(key: Int, node: TreeNode?): Boolean {
        node?: return false
        if(node.item == key) return true
        val left = searchNode(key, node.leftNode)
        val right = searchNode(key,node.rightNode)
        return left || right
    }
}

fun main() {
    BinaryTree().apply {
        var rootNode: BinaryTree.TreeNode? = null
        listOf(8,4,12,1,3,5,10,14,0).forEach {
            rootNode = insert(it,rootNode)
        }

        println("PreOrder: ")
        preOrder(rootNode)

        println("\n\nInOrder: ")
        inOrder(rootNode)

        println("\n\nPostOrder: ")
        postOrder(rootNode)

        println("\n\nLevel Order SingleList: \n${levelOrderSingleList(rootNode).toTypedArray().contentToString()}")
        println("\nLevel Order SubList: \n${levelOrderSubList(rootNode).toTypedArray().contentToString()}")

        println("\nTotal Nodes: ${countNode(rootNode)}")
        println("\nSum Of Nodes: ${sumOfNodes(rootNode)}")
        println("\nHeight of Tree: ${heightOfTree(rootNode)}")
        println("is 5 Found? : ${searchNode(5,rootNode)}")
        println("is 2 Found? : ${searchNode(2,rootNode)}")

        println("\n============================================")

        val tree = serializedTree(rootNode,StringBuilder())
        println("Serialized Tree: $tree")
        val root = deSerializedTree(tree.split(" "))

        println()
        preOrder(root)
        println()
        inOrder(root)

        println("\n\nLevel Order SingleList: \n${levelOrderSingleList(root).toTypedArray().contentToString()}")
        println("\nLevel Order SubList: \n${levelOrderSubList(root).toTypedArray().contentToString()}")


        println("\n============================================")
        delete(5,rootNode)
        println("Inorder After delete")
        inOrder(rootNode)

        println("\n============================================")
    }
}


//======================OUTPUT
PreOrder: 
8 4 1 0 3 5 12 10 14 

InOrder: 
0 1 3 4 5 8 10 12 14 

PostOrder: 
0 3 1 5 4 10 14 12 8 

Level Order SingleList: 
[8, 4, 12, 1, 5, 10, 14, 0, 3]

Level Order SubList: 
[[8], [4, 12], [1, 5, 10, 14], [0, 3]]

Total Nodes: 9

Sum Of Nodes: 57

Height of Tree: 4
is 5 Found? : true
is 2 Found? : false

============================================
Serialized Tree: 8 4 1 0 # # 3 # # 5 # # 12 10 # # 14 # # 

8 4 1 0 3 5 12 10 14 
0 1 3 4 5 8 10 12 14 

Level Order SingleList: 
[8, 4, 12, 1, 5, 10, 14, 0, 3]

Level Order SubList: 
[[8], [4, 12], [1, 5, 10, 14], [0, 3]]

============================================
Inorder After delete
0 1 3 4 8 10 12 14 
============================================
