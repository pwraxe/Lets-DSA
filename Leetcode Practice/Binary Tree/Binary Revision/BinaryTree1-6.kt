data class Node(var item: Int) {
    var leftNode: Node? = null
    var rightNode: Node? = null
}

class Queue<T> {
    private val elements = mutableListOf<T?>()

    fun enQ(item: T?) {
        elements.add(item)
    }

    fun deQ(): T? {
        return elements.removeFirstOrNull()
    }

    fun isEmpty() = elements.isEmpty()
}
class BinaryTree {

    //creations
    fun insertNode(item: Int, node: Node?): Node {
        node ?: return Node(item)
        if(item > node.item) {
            node.rightNode = insertNode(item,node.rightNode)
        } else {
            node.leftNode = insertNode(item,node.leftNode)
        }
        return node
    }
    fun deleteNode(key: Int, node: Node?) : Node? {
        node ?: return null

        when {
            key > node.item -> node.rightNode = deleteNode(key, node.rightNode)
            key < node.item -> node.leftNode = deleteNode(key, node.leftNode)
            else -> {
                if(node.leftNode == null && node.rightNode == null) {
                    return null
                }

                node.leftNode ?: return node.rightNode
                node.rightNode ?: return node.leftNode

                var mNode = node.rightNode
                while (mNode?.leftNode != null) {
                    mNode = mNode.leftNode
                }
                node.item = mNode?.item ?: 0
                node.rightNode = deleteNode(key,node.rightNode)
            }
        }


        return node
    }

    var index = -1
    fun buildTree(list: List<Int?>): Node? {
        index++
        list[index] ?: return null

        val newNode = Node(list[index]!!)
        newNode.leftNode = buildTree(list)
        newNode.rightNode = buildTree(list)
        return newNode
    }

    //operations
    fun countNodes(node:Node?): Int{
        node ?: return 0
        val left = countNodes(node.leftNode)
        val right = countNodes(node.rightNode)
        return left+right+1
    }
    fun sumOfNodes(node: Node?): Int {
        node ?: return 0
        val left = sumOfNodes(node.leftNode)
        val right = sumOfNodes(node.rightNode)
        return left + right + node.item
    }
    fun heightOfTree(node:Node?) : Int {
        node ?: return 0
        val left = heightOfTree(node.leftNode)
        val right = heightOfTree(node.rightNode)
        return Math.max(left,right) + 1
    }

    //Traversal
    fun preOrderTraverse(node: Node?) {
        node ?: return
        print("${node.item}, ")
        preOrderTraverse(node.leftNode)
        preOrderTraverse(node.rightNode)
    }
    fun inOrderTraverse(node: Node?) {
        node ?: return
        inOrderTraverse(node.leftNode)
        print("${node.item}, ")
        inOrderTraverse(node.rightNode)
    }
    fun postOrderTraverse(node: Node?) {
        node ?: return
        postOrderTraverse(node.leftNode)
        postOrderTraverse(node.rightNode)
        print("${node.item}, ")
    }
    fun levelOrderTraverse(node: Node?): List<List<Int>> {
        val list = mutableListOf<List<Int>>()
        val subList = mutableListOf<Int>()
        val queue = Queue<Node?>()
        queue.enQ(node)
        queue.enQ(null)

        while (!queue.isEmpty()) {

            val currentNode = queue.deQ()
            if(currentNode == null) {
                list.add(subList.toList())
                subList.clear()
                if(queue.isEmpty()) break else queue.enQ(null)
            } else {
                subList.add(currentNode.item)
                currentNode.leftNode?.let { queue.enQ(it) }
                currentNode.rightNode?.let { queue.enQ(it) }
            }
        }
        return list
    }
}

fun main() {
    BinaryTree().apply {

        var rootNode: Node? = null
        listOf(8,4,12,1,3,5,10,14,0).forEach {
            rootNode = insertNode(it,rootNode)
        }

        print("PreOrder:")
        preOrderTraverse(rootNode)

        print("\nInOrder:")
        inOrderTraverse(rootNode)

        print("\nPostOrder:")
        postOrderTraverse(rootNode)

        println("\nLevel Order: ${levelOrderTraverse(rootNode).toTypedArray().contentToString()}")

        println("\nCountNodes: ${countNodes(rootNode)}")
        println("SumOfNodes: ${sumOfNodes(rootNode)}")
        println("HeightOfTree: ${heightOfTree(rootNode)}")

        val key = 5
        println("\nDeleting $key")
        deleteNode(5,rootNode)

        println("InOrder After Delete $key")
        inOrderTraverse(rootNode)


        //---------------------------------------
        println("\n---------------------------------------")
        println("BuildTree\n")
        val list2 = listOf(8,4,2,null,null,6,5,null,null,7,null,null,10,9,null,null,12,null,null)
        buildTree(list2)

        print("PreOrder:")
        preOrderTraverse(rootNode)

        print("\nInOrder:")
        inOrderTraverse(rootNode)

        print("\nPostOrder:")
        postOrderTraverse(rootNode)

        println("\nLevel Order: ${levelOrderTraverse(rootNode).toTypedArray().contentToString()}")

        println("\nCountNodes: ${countNodes(rootNode)}")
        println("SumOfNodes: ${sumOfNodes(rootNode)}")
        println("HeightOfTree: ${heightOfTree(rootNode)}")

        val key2 = 10
        println("\nDeleting $key2")
        deleteNode(key2,rootNode)

        println("InOrder After Delete $key2")
        inOrderTraverse(rootNode)
    }
}

//------------------ OUTPUT ------------------------

PreOrder:8, 4, 1, 0, 3, 5, 12, 10, 14, 
InOrder:0, 1, 3, 4, 5, 8, 10, 12, 14, 
PostOrder:0, 3, 1, 5, 4, 10, 14, 12, 8, 
Level Order: [[8], [4, 12], [1, 5, 10, 14], [0, 3]]

CountNodes: 9
SumOfNodes: 57
HeightOfTree: 4

Deleting 5
InOrder After Delete 5
0, 1, 3, 4, 8, 10, 12, 14, 
---------------------------------------
BuildTree

PreOrder:8, 4, 1, 0, 3, 12, 10, 14, 
InOrder:0, 1, 3, 4, 8, 10, 12, 14, 
PostOrder:0, 3, 1, 4, 10, 14, 12, 8, 
Level Order: [[8], [4, 12], [1, 10, 14], [0, 3]]

CountNodes: 8
SumOfNodes: 52
HeightOfTree: 4

Deleting 10
InOrder After Delete 10
0, 1, 3, 4, 8, 12, 14, 
 
