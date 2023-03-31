typealias Visitors<T> = (TreeNode<T>) -> Unit

class TreeNode<T>(var dataItem: T) {

    private var children = mutableListOf<TreeNode<T>>()
    fun addNode(node: TreeNode<T>) {
        children.add(node)
    }
    //Starts Travel from Root Node : Root -> Left -> Right
    fun forEachDepthFirst(visitors: Visitors<T>) {
        visitors(this)
        children.forEach {
            it.forEachDepthFirst(visitors)
        }
    }
}
fun addNodes() : TreeNode<Int> {
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

fun main() {
    addNodes().forEachDepthFirst {
        println(it.dataItem)
    }
}
=============================================================================================================================
typealias Visitor<T> = (TreeNode<T>) -> Unit

class TreeNode<T>(val dataItem: T) {
    private var children = mutableListOf<TreeNode<T>>()

    fun addNode(node: TreeNode<T>) {
        children.add(node)
    }

    fun letsTravelToDepthFirst(visitor: Visitor<T>) {
        visitor(this)
        children.forEach {
            it.letsTravelToDepthFirst(visitor)
        }
    }
}

fun main() {
    val root = TreeNode(1)
    val leftRoot = TreeNode(10)
    val rightRoot = TreeNode(20)

    val leftLeft = TreeNode(5)
    val leftRight = TreeNode(7)

    root.addNode(leftRoot)
    root.addNode(rightRoot)

    leftRoot.addNode(leftLeft)
    leftRoot.addNode(leftRight)

    root.letsTravelToDepthFirst {
        println(it.dataItem)
    }
}
=====================================================================================================================================
    
    typealias Visitor<T> = (TreeNode<T>) -> Unit

class TreeNode<T>(val dataItem: T) {
    private var children = mutableListOf<TreeNode<T>>()

    fun addNode(node: TreeNode<T>) {
        children.add(node)
    }

    fun letsTravelToDepthFirst(visitor: Visitor<T>) {
        visitor(this)
        children.forEach {
            it.letsTravelToDepthFirst(visitor)
        }
    }
}

fun main() {

    val root = TreeNode(1)
    val node1 = TreeNode(10)
    val node11 = TreeNode(5)
    val node12 = TreeNode(7)

    val node2 = TreeNode(20)
    val node21 = TreeNode(2)
    val node211 = TreeNode(8)
    val node212 = TreeNode(11)

    val node22 = TreeNode(9)

    //To add or Connect them
    root.addNode(node1)
    root.addNode(node2)

    node1.addNode(node11)
    node1.addNode(node12)

    node2.addNode(node21)
    node2.addNode(node22)

    node21.addNode(node211)
    node21.addNode(node212)

    root.letsTravelToDepthFirst {
        println(it.dataItem)
    }
}
