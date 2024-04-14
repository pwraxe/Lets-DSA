import java.util.ArrayDeque
import java.util.Stack

data class Node(
    var item:Int,
    var left: Node? = null,
    var right: Node? = null)

class DiamInfo(val diameter: Int, val height: Int)
class Info(val node: Node?, val hrDist:Int)

class BinaryTree {

    var index = -1

    fun buildTree(list: List<Int>): Node? {
        index++
        if (list[index] == -1) return null
        val node = Node(list[index])
        node.left = buildTree(list)
        node.right = buildTree(list)
        return node
    }
    fun read(node: Node?) {
        node ?: return

        print("${node.item}, ")
        read(node.left)
        read(node.right)
    }
    fun printKthLevel(root:Node?, k:Int) {
        val queue = ArrayDeque<Info>()
        queue.offer(Info(root,1))
        val nullInfo = Info(null, 0)
        queue.offer(nullInfo)

        while (queue.isNotEmpty()) {
            val node = queue.poll()
            if (node.node == null) {
                if (queue.isEmpty()) break else queue.offer(nullInfo)
            } else  {
                if (node.hrDist == k) {
                    print("${node.node.item}, ")
                }
                node.node.left?.let { queue.offer(Info(it,node.hrDist+1)) }
                node.node.right?.let { queue.offer(Info(it,node.hrDist+1)) }
            }
        }
    }
    fun printKthLevelRec(info: Info?,k: Int) {
        info?.node ?: return
        if (info.hrDist == k) {
            print("${info.node.item}, ")
        }
        info.node.left?.let {
            printKthLevelRec(Info(it,info.hrDist+1),k)
        }
        info.node.right?.let {
            printKthLevelRec(Info(it,info.hrDist+1),k)
        }
    }
    fun printKthLevelRec2(root: Node?, level:Int,k:Int) {
        root ?: return

        if (level == k) {
            print("${root.item}, ")
            return
        }
        printKthLevelRec2(root.left,level+1,k)
        printKthLevelRec2(root.right,level+1,k)
    }

    private fun getPath(node: Node?, value:Int, stack: Stack<Node>): Stack<Node> {
        node ?: return stack

        stack.push(node)

        getPath(node.left, value, stack)
        if (stack.isNotEmpty() && stack.peek().item == value) return stack

        getPath(node.right, value, stack)
        if (stack.isNotEmpty() && stack.peek().item == value) return stack

        if (stack.isNotEmpty()) stack.pop()

        return stack
    }
    fun lowestCommonAncestor(root: Node?, n1: Int, n2: Int) {

        val stack1 = getPath(root,n1, Stack())
        val stack2 = getPath(root,n2, Stack())

        while (stack1.isNotEmpty() && stack2.isNotEmpty()) {
            if (stack1.peek().item != stack2.peek().item) {
                stack1.pop()
                stack2.pop()
            } else {
                println("${stack1.peek().item} | ${stack2.peek().item}")
                break
            }
        }

    }
    fun lowestCommonAncestor2(root: Node?,n1: Int,n2: Int): Node? {
        if (root == null || root.item == n1 || root.item == n2) return root

        val leftST = lowestCommonAncestor2(root.left, n1, n2)
        val rightST = lowestCommonAncestor2(root.right, n1, n2)

        if (leftST == null) return rightST
        if (rightST == null) return leftST
        return root
    }

    private fun dist(node: Node?, n:Int): Int {

        node ?: return -1
        if (node.item == n) return 0

        val left = dist(node.left,n)
        val right = dist(node.right,n)

        return when {
            left == -1 && right == -1 -> -1
            left == -1 -> right+1
            else -> left+1
        }
    }
    fun minDistance(root: Node?, n1: Int, n2: Int) {
        val lca = lowestCommonAncestor2(root, n1, n2)
        val dist = dist(lca,n1) + dist(lca,n2)
        println("Min Dist: $dist")
    }
    fun kthAncestor(root: Node?, n:Int, k:Int):Int {
        root ?: return -1
        if (root.item == n) return 0

        val left = kthAncestor(root.left, n, k)
        val right = kthAncestor(root.right, n, k)

        if (left == -1 && right == -1) return -1
        val max = Math.max(left,right)
        if (max+1 == k) {
            println("${k}th Ancestor of $n: ${root.item}")
        }
        return max+1

    }

    fun transformToSumTree(root: Node?): Int {

        root ?: return 0

        val left = transformToSumTree(root.left)
        val right = transformToSumTree(root.right)

        val data = root.item

        root.item = (root.left?.item ?: 0) + left + (root.right?.item ?: 0) + right

        return data
    }
}

/*
*         1
*       /  \
*      2    3
*    / \   / \
*   4  5  6   7
*
* */

fun main() {
    BinaryTree().apply {
        index = -1
        val root = buildTree(listOf(1,2,4,-1,-1,5,-1,-1,3,6,-1,-1,7,-1,-1))

        printKthLevel(root,3)
        println()

        printKthLevelRec(Info(root,1),3)
        println()

        printKthLevelRec2(root,1,3)
        println()

        lowestCommonAncestor(root,4,6)
        lowestCommonAncestor(root,4,5)
        println()

        println(lowestCommonAncestor2(root,4,6)?.item)
        println(lowestCommonAncestor2(root,4,5)?.item)

        minDistance(root,4,6)
        minDistance(root,4,5)

        kthAncestor(root,5,1)
        kthAncestor(root,5,2)

        transformToSumTree(root)
        read(root)
    }
}

//=========================

4, 5, 6, 7, 
4, 5, 6, 7, 
4, 5, 6, 7, 
1 | 1
2 | 2

1
2
Min Dist: 4
Min Dist: 2
1th Ancestor of 5: 2
2th Ancestor of 5: 1
27, 9, 0, 0, 13, 0, 0, 
