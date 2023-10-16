//Binary Tree
//InsertNode, 
//DeleteNode,
//Traverse, Pre-Order, In-Order, Post-Order

data class Node(var item: Int) {
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

    fun searchNumber(key: Int, node: Node?) : Boolean {
        node ?: return false
        if(node.item == key) return true

        return if(key > node.item) {
            //right
            searchNumber(key, node.rightNode)
        } else {
            //left
            searchNumber(key, node.leftNode)
        }
    }

    fun deleteNode(key: Int, node: Node?): Node? {

        //Steps to Delete Node
        //Step 1: Traverse to node
        //Step 2: For Single Child, return left or right which is not null
        //Stpe 3: Get Smallest node of right sub-tree of given node (or node which to delete)
        node ?: return null

        when {
            key > node.item -> {
                node.rightNode = deleteNode(key, node.rightNode)
            }
            key < node.item -> {
                node.leftNode = deleteNode(key, node.leftNode)
            }
            else -> {
                if(node.leftNode == null && node.rightNode == null) {
                    return null
                }

                node.leftNode ?: return node.rightNode
                node.rightNode ?: return node.leftNode

                //Get Leftmost node of right node
                var mNode = node.rightNode
                while (mNode?.leftNode != null) {
                    mNode = mNode?.leftNode
                }
                node.item = mNode?.item ?: 0
                node.rightNode = deleteNode(mNode?.item!!,node.rightNode)

            }
        }
        return node
    }
}


fun main() {
    BinaryTree().apply {
        val list = listOf(4,3,8,5,2,6,1,10)
        var root: Node? = null
        list.forEach {
            root = insert(it,root)
        }

        println("InOrder: ")
        readByInOrder(root)

        deleteNode(4,root)

        println("\nInOrder: ")
        readByInOrder(root)
    }
}
