class LetsQueue<T> {
    private var queueData = mutableListOf<T>()
    fun enqueue(item: T) {
        queueData.add(item)
    }

    fun dequeue() : T? {
        return if(queueData.isNotEmpty()) {
            queueData.removeAt(0)
        } else null
    }
}
typealias Visitor<T> = (TreeNode<T>) -> Unit

class TreeNode<T> (var node: T) {
    private var children = mutableListOf<TreeNode<T>>()

    fun addNode(treeNode: TreeNode<T>) {
        children.add(treeNode)
    }

    //AKA : Pre-Order Traversal
    fun preOrderTraversal(visitor: Visitor<T>) {
        visitor(this)
        children.forEach {
            it.preOrderTraversal(visitor)
        }
    }

    //AKA : POST Order Traversal
    fun postOrderTraversal(visitor: Visitor<T>) {
        children.forEach { it.postOrderTraversal(visitor) }
        visitor(this)
    }

    fun levelOrderTraversal(visitor: Visitor<T>) {
        visitor(this)
        val queue = LetsQueue<TreeNode<T>>()
        children.forEach { queue.enqueue(it) }

        var node = queue.dequeue()
        while (node != null) {
            visitor(node)
            node.children.forEach { queue.enqueue(it) }
            node = queue.dequeue()
        }
    }

    //Pre-Order Search
    fun searchByPreOrder(item: T) : T? {
        var element : T? = null
        this.preOrderTraversal {
            if(it.node == item) element = it.node
        }
        return element
    }
}

fun main() {

    val one = TreeNode(1)
    val two = TreeNode(2)
    val four = TreeNode(4)
    val eight = TreeNode(8)
    val sixteen = TreeNode(16)
    val thirty2 = TreeNode(32)
    val sixty4 = TreeNode(64)
    val one28 = TreeNode(128)
    val two56 = TreeNode(256)
    val five12 = TreeNode(512)
    val ten24 = TreeNode(1024)
    val twoK48 = TreeNode(2048)
    val fourK96 = TreeNode(4096)

    //Lets add
    one.addNode(two)
    one.addNode(four)

    two.addNode(eight)
    two.addNode(sixteen)

    four.addNode(thirty2)
    four.addNode(sixty4)

    eight.addNode(one28)

    sixteen.addNode(two56)
    sixteen.addNode(five12)

    sixty4.addNode(ten24)
    sixty4.addNode(twoK48)
    sixty4.addNode(fourK96)

    one.preOrderTraversal {
        println("Pre-OT Node : ${it.node}")
    }

    println("---------------------------------------")

    one.postOrderTraversal {
        println("Post-OT : ${it.node}")
    }

    println("---------------------------------------")

    one.levelOrderTraversal {
        println("Level-OT Node : ${it.node}")
    }

    println("Element is : ${one.searchByPreOrder(16) ?: "Not Found"}")

    
    //4 Diff. ways to search element in Tree
    //1. Pre-Order Search
    //2. In-Order Search
    //3. Post-Order Search
    //4. Level-Order Search
}
