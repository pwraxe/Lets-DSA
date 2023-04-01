import groovyjarjarantlr4.runtime.tree.Tree

//TODO => Practice DFT(depth First Traversal) and LOT(Level Order Traversal)
//Then Read LOT Doc on Page No : 134

class LetsQueue<T> {
    private var queueData = mutableListOf<T>()
    fun enqueue(dataItem: T) {
        queueData.add(dataItem)
    }

    fun dequeue() : T? {
        return if(queueData.isNotEmpty()) {
            queueData.removeAt(0)
        } else null
    }

    fun getSize() = queueData.size
}

typealias Visitors<T> = (TreeNode<T>) -> Unit

class TreeNode<T> (var dataItem: T) {
    private var childrens = mutableListOf<TreeNode<T>>()

    fun addNode(node: TreeNode<T>) {
        childrens.add(node)
    }

    fun letsTraverseByDepthFirst(visitors: Visitors<T>) {
        visitors(this)
        childrens.forEach {
            it.letsTraverseByDepthFirst(visitors)
        }
    }

    fun letsTraverseByLevelOrder(visitors: Visitors<T>) {
        visitors(this)
        val queue = LetsQueue<TreeNode<T>>()
        childrens.forEach {
            queue.enqueue(it)
        }

        var node = queue.dequeue()
        while (node != null) {
            visitors(node)
            node.childrens.forEach { queue.enqueue(it) }
            node = queue.dequeue()
        }
    }

    fun searchNodeByDFT(node: T) : TreeNode<T>? {
        var searchedNode : TreeNode<T>? = null

        letsTraverseByDepthFirst {
            if(it.dataItem == node) searchedNode = it
        }
        return searchedNode
    }
    fun searchNodeByLOT(node: T) : TreeNode<T>? {
        var searchedNode : TreeNode<T>? = null
        letsTraverseByLevelOrder {
            if(it.dataItem == node) searchedNode = it
        }
        return searchedNode
    }
}

fun main() {

    //Level 0
    val root = TreeNode<Int>(100)

    //Level 1
    val node60 = TreeNode(60)
    val node40 = TreeNode(40)

    //Level 2
    val node20Left = TreeNode(20)
    val node10= TreeNode(10)
    val node30 = TreeNode(30)
    val node20Right = TreeNode(20)

    //Level 3
    val node15 = TreeNode(15)
    val node18 = TreeNode(18)
    val node4 = TreeNode(4)
    val node2 = TreeNode(2)
    val node25 = TreeNode(25)
    val node28 = TreeNode(28)
    val node12 = TreeNode(12)
    val node16 = TreeNode(16)

    //Lets add or Connect them
    root.apply {
        addNode(node40)
        addNode(node60)
    }

    node40.apply {
        addNode(node20Left)
        addNode(node10)
    }

    node60.apply {
        addNode(node30)
        addNode(node20Right)
    }

    node20Left.apply {
        addNode(node15)
        addNode(node18)
    }

    node10.apply {
        addNode(node4)
        addNode(node2)
    }

    node30.apply {
        addNode(node25)
        addNode(node28)
    }

    node20Right.apply {
        addNode(node12)
        addNode(node16)
    }

    println("-----------DFT-----------")
    root.letsTraverseByDepthFirst { println(it.dataItem) }
    println("-------------------------")

    println()

    println("-----------OLT-----------")
    root.letsTraverseByLevelOrder { println(it.dataItem) }
    println("-------------------------")

    val isSearchByDFT = root.searchNodeByDFT(10)?.dataItem != null
    val isSearchByLOT = root.searchNodeByLOT(25)?.dataItem != null

    println("Search By DFT :Element Found? : $isSearchByDFT")
    println("Search By LOT :Element Found? : $isSearchByLOT")
}
