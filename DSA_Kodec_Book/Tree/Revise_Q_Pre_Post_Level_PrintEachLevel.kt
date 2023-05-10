class LetsQueue<T> {
    private var queueList = mutableListOf<T>()
    fun enqueue(item: T) {
        queueList.add(item)
    }
    fun dequeue() : T? {
        return if(queueList.isNotEmpty()) {
            queueList.removeAt(0)
        } else null
    }
    fun count() = queueList.size
    fun isEmpty() = count() == 0

}
typealias Visits<T> = (TreeNode<T>) -> Unit

class TreeNode<T>(var dataItem: T) {
    private var children = mutableListOf<TreeNode<T>>()

    fun addNode(item:TreeNode<T>) {
        children.add(item)
    }

    fun letsLevelOrderTraverse(visits: Visits<T>) {
        val queue = LetsQueue<TreeNode<T>>()
        queue.enqueue(this)
        //children.forEach { queue.enqueue(it) }

        var node = queue.dequeue()
        while(node != null) {
            visits(node)
            node.children.forEach {
                queue.enqueue(it)
            }
            node = queue.dequeue()
        }
    }

    //AKA - Pre-Order-Traversal
    fun letsDepthFirstTraverse(visits: Visits<T>) {
        visits(this)
        children.forEach {
            it.letsDepthFirstTraverse(visits)
        }
    }
    
    fun letsPostOrderTraversal(visits: Visits<T>) {
        children.forEach { it.letsPostOrderTraversal(visits) }
        visits(this)
    }

    fun printEachLevel() {
        val queue = LetsQueue<TreeNode<T>>()
        var nodeLeftAtCurrentLevel = 0
        queue.enqueue(this)
        while (!queue.isEmpty()) {
            nodeLeftAtCurrentLevel = queue.count()
            while (nodeLeftAtCurrentLevel > 0) {
                val node = queue.dequeue()
                node?.let {
                    print("${node.dataItem} ")
                    node.children.forEach { queue.enqueue(it) }
                    nodeLeftAtCurrentLevel--
                } ?: break
            }
            println()
        }
    }

}

fun main() {
    addNodes().apply {
      
        //PreOrder Traversal
        //1, 2, 8, 128, 16, 256, 512, 4, 32, 64, 1024, 2048, 4096, 
        println("PreOrder Traversal")
        letsDepthFirstTraverse {
            print("${it.dataItem}, ")
        }

        //Level Order Traversal
        //1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 
        println("\nLevel Order Traversal")
        letsLevelOrderTraverse {
            print("${it.dataItem}, ")
        }

        //Post Order Traversal
        //128, 8, 256, 512, 16, 2, 32, 1024, 2048, 4096, 64, 4, 1, 
        println("\nPost Order Traversal")
        letsPostOrderTraversal {
            print("${it.dataItem}, ")
        }

        /***
        Each Level of Tree
        1 
        2 4 
        8 16 32 64 
        128 256 512 1024 2048 4096 
        **/
        println("\nEach Level of Tree")
        printEachLevel()
    }


}

fun addNodes(): TreeNode<Int> {
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

    return one
}

