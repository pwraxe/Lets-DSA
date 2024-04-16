import kotlin.math.max

data class Node(
    val item: Int,
    var left: Node? = null,
    var right: Node? = null
)

class BST {

    fun heightOfTree(node: Node?): Int {
        node ?: return 0
        val left = heightOfTree(node.left)
        val right = heightOfTree(node.right)
        return 1 + max(left,right)
    }
    fun buildBST(root:Node?, item: Int): Node {
        root ?: return Node(item)

        if (item >= root.item) {
            root.right = buildBST(root.right,item)
        } else {
            root.left = buildBST(root.left,item)
        }
        return root
    }
    fun buildBalanceBST(root: Node?, list: List<Int>): Node? {
        root ?: return null
        if (list.size == 1) {
            return Node(list.first())
        }
        val mid = list.size/2
        val node = Node(list[mid])

        node.left = buildBalanceBST(node,list.subList(0,mid))
        node.right = buildBalanceBST(node,list.subList(mid+1,list.size))

        return node
    }
    fun buildBalanceBST2(start:Int, end:Int, list: List<Int>): Node? {
        if (start > end) return null

        val mid = (start + end)/2
        val root = Node(list[mid])

        root.left = buildBalanceBST2(start, mid-1, list)
        root.right = buildBalanceBST2(mid+1, end, list)

        return root
    }
    fun readPreOrder(node: Node?) {
        node ?: return
        print("${node.item}, ")
        readPreOrder(node.left)
        readPreOrder(node.right)
    }

    fun getInOrder(node: Node?, list: MutableList<Int>): List<Int> {
        node ?: return list.toList()
        getInOrder(node.left,list)
        list.add(node.item)
        getInOrder(node.right,list)
        return list
    }
    fun bstToBalanceBT(node: Node?): Node? {
        val inOrder = getInOrder(node, mutableListOf())
        val root = buildBalanceBST2(0,inOrder.lastIndex,inOrder)
        println("Height: ${heightOfTree(root)}")
        readPreOrder(root)
        return root
    }

}

fun main() {
    BST().apply {
        var root: Node? = null
        val list = listOf(3,5,6,8,10,11,12)
        list.forEach {
            root = buildBST(root,it)
        }
        println("Height1: ${heightOfTree(root)}")
        readPreOrder(root)

        println()
        val root2 = buildBalanceBST(root,list)
        println("\nHeight2: ${heightOfTree(root2)}")
        readPreOrder(root2)

        println()
        val root3 = buildBalanceBST2(0,list.lastIndex,list)
        println("\nHeight2: ${heightOfTree(root3)}")
        readPreOrder(root3)

        println("\n")
        bstToBalanceBT(root)
    }
    println("================================")
    BST().apply {

        val root1 = buildBalanceBST2(0,2, listOf(1,2,4))
        val root2 = buildBalanceBST2(0,2, listOf(3,9,12))

        val list1 = getInOrder(root1, mutableListOf())
        val list2 = getInOrder(root2, mutableListOf())

        val list = (list1+list2).sorted()
        val root = buildBalanceBST2(0, list.lastIndex, list)
        println(getInOrder(root, mutableListOf()).toTypedArray().contentToString())
        readPreOrder(root)
    }
}


Height1: 7
3, 5, 6, 8, 10, 11, 12, 

Height2: 3
8, 5, 3, 6, 11, 10, 12, 

Height2: 3
8, 5, 3, 6, 11, 10, 12, 

Height: 3
8, 5, 3, 6, 11, 10, 12, 
================================
[1, 2, 3, 4, 9, 12]
3, 1, 2, 9, 4, 12, 
