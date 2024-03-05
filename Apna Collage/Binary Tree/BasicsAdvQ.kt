import java.util.ArrayDeque
import kotlin.math.max
import kotlin.math.min

data class TreeNode(val data:Int, var left: TreeNode? = null, var right: TreeNode? = null)
data class Info(val dim:Int, val ht:Int)
data class TopInfo(val node:TreeNode?, val horDist: Int)

class Solution {
    private var i: Int = -1
    private fun build( list: IntArray): TreeNode? {
        i++
        if (i == list.size || list[i] == -1) return null
        val node = TreeNode(list[i])
        node.left = build(list)
        node.right = build(list)
        return node
    }
    fun buildTree(list:IntArray): TreeNode? {
        return build(list)
    }
    fun preOrderRead(node: TreeNode?) {
        node ?: return
        print("${node.data} ")
        preOrderRead(node.left)
        preOrderRead(node.right)
    }
    fun inOrderRead(node: TreeNode?) {
        node ?: return
        inOrderRead(node.left)
        print("${node.data} ")
        inOrderRead(node.right)
    }
    fun postOrderRead(node: TreeNode?) {
        node ?: return
        postOrderRead(node.left)
        postOrderRead(node.right)
        print("${node.data} ")
    }
    fun levelOrderRead(root: TreeNode?) {
        val queue = ArrayDeque<TreeNode?>()
        queue.offer(root)
        queue.offer(TreeNode(-1))

        while (queue.isNotEmpty()) {
            val node = queue.poll()
            if (node?.data == -1) {
                println()
                if (queue.isEmpty()) break else {
                    queue.offer(TreeNode(-1))
                }
            } else {
                print("${node?.data} ")
                node?.left?.let { queue.offer(it) }
                node?.right?.let { queue.offer(it) }
            }
        }
    }
    fun heightOfTree(root: TreeNode?): Int {
        root ?: return 0
        //if (root?.left == null && root?.right == null) return 1
        //if (root.left == null || root.right == null) return 0
        val leftSt = heightOfTree(root.left)
        val rightSt = heightOfTree(root.right)
        return max(leftSt,rightSt) + 1
    }
    fun countOfNodes(root: TreeNode?): Int {
        root ?: return 0
        val left = countOfNodes(root.left)
        val right = countOfNodes(root.right)
        return left + right + 1
    }
    fun sumOfNodes(root: TreeNode?): Int {
        root ?: return 0
        val left = sumOfNodes(root.left)
        val right = sumOfNodes(root.right)
        return left + right + root.data
    }
    fun dimeterOfTree(root: TreeNode?): Int {
        root ?: return 0
        val leftDim = dimeterOfTree(root.left)
        val leftHeight = heightOfTree(root.left)

        val rightDim = dimeterOfTree(root.right)
        val rightHeight = heightOfTree(root.right)

        val selfDim = leftHeight + rightHeight + 1
        return maxOf(leftDim, rightDim, selfDim)
    }
    fun dimOfTreeWay2(root: TreeNode?) :Info {
        root ?: return Info(0,0)
        val left = dimOfTreeWay2(root.left)
        val right = dimOfTreeWay2(root.right)

        val dim = maxOf(left.dim, right.dim, left.ht+right.ht+1)
        val ht = max(left.ht, right.ht) + 1
        return Info(dim, ht)
    }

    private fun isIdentical(root: TreeNode?, sub: TreeNode?): Boolean {
        if (root == null && sub == null) {
            return true
        } else if (root == null || sub == null || root.data != sub.data) {
            return false
        }

        if (!isIdentical(root.left, sub.left)) return false
        if (!isIdentical(root.right, sub.right)) return false
        return true
    }
    fun isSubTree(root: TreeNode?, sub:TreeNode?):Boolean {

        if (root?.data == sub?.data) {
            if (isIdentical(root, sub)) {
                return true
            }
        }
        return isSubTree(root?.left, sub) ||  isSubTree(root?.right, sub)
    }

    fun topView(node: TreeNode?) {
        val queue = ArrayDeque<TopInfo>()
        val map = hashMapOf<Int,TreeNode?>()
        val dummy = TopInfo(TreeNode(Int.MIN_VALUE),Int.MAX_VALUE)
        queue.add(TopInfo(node,0))
        queue.add(dummy)
        
        while (queue.isNotEmpty()) {
            val current = queue.poll()
            if (current.node == dummy.node) {
                if (queue.isEmpty()) break else queue.offer(dummy)
            } else {
                if (!map.containsKey(current.horDist)) {
                    map[current.horDist] = current.node
                }

                if (current.node?.left != null) {
                    queue.offer(TopInfo(current.node.left, current.horDist-1))
                }

                if (current?.node?.right != null) {
                    queue.offer(TopInfo(current.node.right, current.horDist+1))
                }
            }
        }
        map.keys.sorted().forEach {
            print("${map.get(it)?.data} ")
        }
    }
}

fun main() {
    Solution().apply {
        val list = intArrayOf(1,2,4,-1,-1,5,-1,-1,3,-1, 6,-1,-1)
        val node = buildTree(list)
        preOrderRead(node)
        println()
        inOrderRead(node)
        println()
        postOrderRead(node)
        println()
        levelOrderRead(node)
        println()
        println("Height: ${heightOfTree(node)}")
        println("Total Nodes: ${countOfNodes(node)}")
        println("Node Sum: ${sumOfNodes(node)}")
        println("Dimeter: ${dimeterOfTree(node)}")
        println("Dim: ${dimOfTreeWay2(node)}")

        val sub = TreeNode(2,TreeNode(4),TreeNode(5))
        println(isSubTree(node, sub))

        topView(node)
    }
}


1 2 4 5 3 6 
4 2 5 1 3 6 
4 5 2 6 3 1 
1 
2 3 
4 5 6 

Height: 3
Total Nodes: 6
Node Sum: 21
Dimeter: 5
Dim: Info(dim=5, ht=3)
true
4 2 1 3 6 
