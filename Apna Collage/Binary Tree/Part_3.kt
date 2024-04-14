import java.util.ArrayDeque
import kotlin.math.max
import kotlin.math.min

data class Node(
    val item:Int,
    var left: Node? = null,
    var right: Node? = null)

/*
*         1
*       /  \
*      2    3
*    / \   / \
*   4  5  -   6
*
* */

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
    fun heightOfTree(root: Node?): Int {
        root ?: return 0
        val left = heightOfTree(root.left)
        val right = heightOfTree(root.right)
        return 1 + max(left,right)
    }
    fun diameterWay1(node: Node?): Int { //O(n2)
        node ?: return 0
        val left = diameterWay1(node.left)
        val leftHeight = heightOfTree(node.left)

        val right = diameterWay1(node.right)
        val rightHeight = heightOfTree(node.right)

        return maxOf(left,right,leftHeight+rightHeight+1)
    }
    fun diameterWay2(node: Node?): DiamInfo {
        node ?: return DiamInfo(0,0)

        val leftDiam = diameterWay2(node.left)
        val rightDiam = diameterWay2(node.right)

        val diameter = maxOf(leftDiam.diameter,rightDiam.diameter, leftDiam.height + rightDiam.height + 1)
        val height = 1 + max(leftDiam.height, rightDiam.height)
        return DiamInfo(diameter, height)
    }

    private fun isSame(root: Node?,subRoot: Node?): Boolean {
        if (root == null && subRoot == null) {
            return true
        }
        if (root == null || subRoot == null || root.item != subRoot.item) {
            return false
        }

        if (!isSame(root.left, subRoot.left)) return false
        if (!isSame(root.right, subRoot.right)) return false
        return true
    }
    fun isSubTree(root: Node?, subRoot: Node?): Boolean {
        root ?: return false
        if (root.item == subRoot?.item) {
            if (isSame(root,subRoot)) return true
        }
        return isSubTree(root.left,subRoot) || isSubTree(root.right,subRoot)
    }

    fun topViewOfTree1(root: Node?) {
        val hashMap = hashMapOf<Int,Node>()
        val queue = ArrayDeque<Info>()

        var min = 0
        var max = 0

        queue.offer(Info(root,0))
        queue.offer(Info(null,0))

        while (queue.isNotEmpty()) {
            val node = queue.poll()
            if (node.node == null) {
                if (queue.isEmpty()) break else queue.offer(Info(null,0))
            }
            if (!hashMap.containsKey(node.hrDist)) {
                hashMap[node.hrDist] = node.node!!
            }

            node.node?.left?.let {
                queue.offer(Info(it,node.hrDist-1))
                min = min(min, node.hrDist-1)
            }

            node.node?.right?.let {
                queue.offer(Info(it,node.hrDist+1))
                max = max(max, node.hrDist + 1)
            }
        }

        for (i in min .. max) {
            print("${hashMap[i]?.item} ")
        }
    }
    //Same as above
    fun topViewOfTree2(root: Node?) {

        val queue = ArrayDeque<Info>()
        val hashMap = hashMapOf<Int,Node>()

        val nullNode = Info(null, 0)
        queue.offer(Info(root,0))
        queue.offer(nullNode)

        while (queue.isNotEmpty()) {
            val value = queue.poll()
            if (value.node == null) {
                if (queue.isEmpty()) break else {
                    queue.offer(nullNode)
                }
            }
            if (!hashMap.containsKey(value.hrDist)) {
                hashMap[value.hrDist] = value.node!!
            }
            value.node?.left?.let {
                queue.offer(Info(it,value.hrDist-1))
            }
            value.node?.right?.let {
                queue.offer(Info(it,value.hrDist+1))
            }
        }

        for (key in hashMap.keys.min() .. hashMap.keys.max()) {
            print("${hashMap[key]?.item}, ")
        }
        println()
    }
}

fun main() {
    BinaryTree().apply {
        index = -1
        val root = buildTree(listOf(1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1))

        println("Height: ${heightOfTree(root)}")
        println("Diameter: ${diameterWay1(root)}")
        val diam = diameterWay2(root)
        println("Diameter: ${diam.diameter} | Height: ${diam.height}")

        index = -1
        val subRoot = buildTree(listOf(2,4,-1,-1,5,-1,-1))
        println("Is SubTree Contains : ${isSubTree(root,subRoot)}")

        topViewOfTree1(root)
        println()
        topViewOfTree2(root)
    }
}

//=================================OUTPUT===================
Height: 3
Diameter: 5
Diameter: 5 | Height: 3
Is SubTree Contains : true
4 2 1 3 6 
4, 2, 1, 3, 6, 
