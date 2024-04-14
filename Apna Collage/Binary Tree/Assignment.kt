data class Node(
    var item:Int,
    var left: Node? = null,
    var right: Node? = null)

class Assignment {

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


    //is the Tree containing the same value?
    fun assignment1(root:Node?, value: Int) : Boolean {
        root ?: return true
        if (root.item != value) return false
        return assignment1(root.left, value) && assignment1(root.right, value)
    }

    //Inverse Binary Tree
    fun assignment2(root: Node?) {
        root ?: return
        if (root.left != null && root.right != null) {

            val left = root.left
            val right = root.right
            root.left = right
            root.right = left

        } else if (root.left != null) {
            root.right = root.left
            root.left = null
        } else {
            root.left = root.right
            root.right = null
        }

        assignment2(root.left)
        assignment2(root.right)
    }

    //delete Leaf Node if its equal to target
    fun assignment3(root: Node?, target:Int): Node? {
        root ?: return null

        if (root.left == null && root.right == null) {
            if (root.item == target) return null
        }


        root.left = assignment3(root.left, target)
        root.right = assignment3(root.right, target)

        return root
    }
}


fun main() {
    Assignment().apply {
        index = -1
        val root1 = buildTree(listOf(2,2,5,-1,-1,2,-1,-1,2,-1,-1))
        read(root1)
        println()
        println(assignment1(root1,root1?.item!!))

        index = -1
        val root2 = buildTree(listOf(1,2,4,-1,-1,5,-1,-1,3,6,-1,-1,7,-1,-1))
        read(root2)
        println()

        assignment2(root2)
        read(root2)
        println()

        index = -1
        val root3 = buildTree(listOf(1,3,3,-1,-1,2,-1,-1,3,-1,-1))
        read(root3)
        println()

        val root = assignment3(root3,3)
        read(root)
    }
}


2, 2, 5, 2, 2, 
false
1, 2, 4, 5, 3, 6, 7, 
1, 3, 7, 6, 2, 5, 4, 
1, 3, 3, 2, 3, 
1, 3, 2, 
