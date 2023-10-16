//Binary Tree
//Insert, Delete, InOrder, PreOrder, PostOrder, 
//PrintRange, PrintPath

class BinaryTree {

    data class Node(var item: Int) {
        var leftNode: Node? = null
        var rightNode: Node? = null
    }

    fun insert(item: Int, node: Node?) : Node {
        node ?: return Node(item)
        if(item > node.item) {
            node.rightNode = insert(item, node.rightNode)
        } else {
            node.leftNode = insert(item, node.leftNode)
        }
        return node
    }
    fun delete(item: Int, node: Node?): Node? {
        node ?: return null

        when {
            item > node.item -> {
                //right
                node.rightNode = delete(item, node.rightNode)
            }
            item < node.item -> {
                //left
                node.leftNode = delete(item, node.leftNode)
            }
            else -> {
                if(node.leftNode == null && node.rightNode == null) {
                    return null
                }

                node?.leftNode ?: return node.rightNode
                node.rightNode ?: return node.leftNode

                var mNode = node.rightNode
                while (mNode?.leftNode != null) {
                    mNode = mNode.leftNode
                }
                node.item = mNode?.item ?: 0
                node.rightNode = delete(item,node.rightNode)
            }
        }
        return node
    }

    fun readByPreOrder(node:Node?, list: MutableList<Int> = mutableListOf()): MutableList<Int> {
        node ?: return list
        list.add(node.item)
        readByPreOrder(node.leftNode, list)
        readByPreOrder(node.rightNode, list)
        return list
    }
    fun readByInOrder(node:Node?, list: MutableList<Int> = mutableListOf()): MutableList<Int> {
        node ?: return list
        readByInOrder(node.leftNode,list)
        list.add(node.item)
        readByInOrder(node.rightNode, list)
        return list
    }
    fun readByPostOrder(node:Node?, list: MutableList<Int> = mutableListOf()): MutableList<Int> {
        node ?: return list
        readByPostOrder(node.leftNode, list)
        readByPostOrder(node.rightNode, list)
        list.add(node.item)
        return list
    }
    fun printInRange(from: Int, to: Int, node: Node?) {
        node ?: return
        when {
            node.item in from .. to -> {
                printInRange(from, to, node.leftNode)
                print("${node.item} ")
                printInRange(from, to, node.rightNode)
            }
            node.item <= from  -> {
                printInRange(from, to, node.leftNode)
            }
            else -> {
                 printInRange(from, to, node.rightNode)
            }
        }
    }
    fun printPath(node:Node?, subList: MutableList<Int>) {
        node ?: return
        subList.add(node.item)
        if(node.leftNode == null && node.rightNode == null) {
            subList.forEach {
                print("${it} -> ")
            }
            println()
        }  else {
            printPath(node.leftNode, subList)
            printPath(node.rightNode, subList)
        }
        subList.removeLast()

    }
}

fun main() {
    BinaryTree().apply {
        var rootNode: BinaryTree.Node? = null
        listOf(8,4,2,6,9,7,10,25,48,63,100).forEach {
            rootNode = insert(it,rootNode)
        }

        println("PreOrder: ${readByPreOrder(rootNode).toTypedArray().contentToString()}")
        println("InOrder: ${readByInOrder(rootNode).toTypedArray().contentToString()}")
        println("PostOrder: ${readByPostOrder(rootNode).toTypedArray().contentToString()}")

        printInRange(4,10,rootNode)
        println()
        printPath(rootNode, mutableListOf())
    }
}
