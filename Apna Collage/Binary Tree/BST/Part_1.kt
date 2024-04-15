import java.util.Stack

data class Node(var item:Int, var left:Node? = null, var right: Node? = null)
class BST {

    fun addNode(node:Node?, item: Int): Node {
        node ?: return Node(item)

        if (node.item > item) {
            node.left = addNode(node.left,item)
        } else {
            node.right = addNode(node.right,item)
        }
        return node
    }
    fun inorderRead(root:Node?) {
        root ?: return
        inorderRead(root.left)
        print("${root.item}, ")
        inorderRead(root.right)
    }
    fun searchKey(node: Node?, key:Int): Boolean {
        node ?: return false

        if (node.item == key) return true

        return if (key > node.item) {
            searchKey(node.right,key)
        } else {
            searchKey(node.left, key)
        }
    }
    fun delete(node:Node?, key: Int): Node? {
        node ?: return null

        when {
            key > node.item -> node.right = delete(node.right,key)
            key < node.item -> node.left = delete(node.left,key)
            else -> {
                if (node.left == null && node.right == null) {
                    return null
                }
                if (node.left == null) return node.right
                if (node.right == null) return node.left

                var successor = node.right
                while (successor?.left != null) {
                    successor = successor.left
                }
                node.item = successor?.item!!
                node.right = delete(node.right,successor.item)
            }
        }
        return node
    }

    fun printRange1(node:Node?, start: Int, end:Int) {
        node ?: return
        printRange1(node.left, start, end)
        if (node.item in start .. end) {
            print("${node.item}, ")
        }
        printRange1(node.right, start, end)
    }
    fun printRange2(node: Node?, start: Int, end: Int) {
        node ?: return

        if (node.item in start .. end) {
            printRange1(node.left, start, end)
            print("${node.item}, ")
            printRange1(node.right, start, end)
        }
        else if (end <= node.item){
            printRange2(node.left,start, end)
        } else {
            printRange2(node.right,start, end)
        }
    }

    val paths1 = mutableListOf<List<Node>>()
    fun rootToLeafPath1(node: Node?, subPath: MutableList<Node>) {
        if (node == null) return

        subPath.add(node)

        if (node.left == null && node.right == null) {
            paths1.add(subPath.toList())
            return
        }
        node.left?.let {
            rootToLeafPath1(it, subPath)
            subPath.removeLast()
        }

        node.right?.let {
            rootToLeafPath1(it,subPath)
            subPath.removeLast()
        }
    }

    val paths2 = mutableListOf<List<Int>>()
    fun rootToLeafPath2(node: Node?, subPath: MutableList<Int>) {
        node ?: return
        subPath.add(node.item)
        if (node.left == null && node.right == null) {
            paths2.add(subPath.toList())
            return
        }

        node.left?.let {
            rootToLeafPath2(it,subPath)
            subPath.removeLast()
        }
        node.right?.let {
            rootToLeafPath2(it,subPath)
            subPath.removeLast()
        }
    }

    fun isValidBST(node: Node?, min:Node?, max:Node?): Boolean {
        node ?: return true
        if (min != null && node.item <= min.item) return false
        else if(max != null && node.item >= max.item) return false
        return isValidBST(node.left, min,node) || isValidBST(node.right,node,max)
    }
    fun mirrorBST(node: Node?): Node? {
        node ?: return null

        val left = mirrorBST(node.left)
        val right = mirrorBST(node.right)
        node.left = right
        node.right = left
        return node
    }
}

fun main() {
    BST().apply {
        var root: Node? = null
        listOf(5,1,3,4,2,7).forEach {
            root = addNode(root,it)
        }
        inorderRead(root)
        println()
        println("Key 5 : ${searchKey(root,5)}")

        var root3: Node? = null
        listOf(5,3,2,1,4,8,7,6,9,10).forEach {
            root3 = addNode(root3,it)
        }
        //delete(root3,3)
        inorderRead(root3)
        println()
        println("Key 5 : ${searchKey(root,5)} && Key 20: ${searchKey(root3,20)}")

        printRange1(root3,4,8)
        println()
        printRange1(root3,2,5)

        println("\n=================================")
        printRange2(root3,4,8)
        println()
        printRange2(root3,2,5)
        println("\n===================================")
        rootToLeafPath1(root3, mutableListOf())
        paths1.forEach {list ->
            list.forEach {
                print("${it.item} -> ")
            }
            println("\b\b\b\b")
        }

        println("\n===================================")
        rootToLeafPath2(root3, mutableListOf())
        paths2.forEach {
            println(it.toTypedArray().contentToString())
        }
        println("is Valid BST: ${isValidBST(root3,null,null)}")
        mirrorBST(root3)
        inorderRead(root3)
    }
}



1, 2, 3, 4, 5, 7, 
Key 5 : true
1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 
Key 5 : true && Key 20: false
4, 5, 6, 7, 8, 
2, 3, 4, 5, 
=================================
4, 5, 6, 7, 8, 
2, 3, 4, 5, 
===================================
5 -> 3 -> 2 -> 1
5 -> 3 -> 4
5 -> 8 -> 7 -> 6
5 -> 8 -> 9 -> 10

===================================
[5, 3, 2, 1]
[5, 3, 4]
[5, 8, 7, 6]
[5, 8, 9, 10]
is Valid BST: true
10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 
