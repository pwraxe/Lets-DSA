import java.util.*

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

    fun readAllData(): List<T> {
        return queueData.map {
            (it as TreeNode<T>).dataItem
        }
    }
}

typealias Visitor<T> = (TreeNode<T>) -> Unit

class TreeNode<T>(val dataItem: T) {
    private var children = mutableListOf<TreeNode<T>>()

    fun addNode(node: TreeNode<T>) {
        children.add(node)
    }

    //Depth First travel
    fun letsTravelToDepthFirst(visitor: Visitor<T>) {
        visitor(this)
        children.forEach {
            it.letsTravelToDepthFirst(visitor)
        }
    }

    //Level Order Travel
    //Visits Each node at level before going below level
    fun letsForLevelOrder(visitor: Visitor<T> /* = (TreeNode<T>) -> kotlin.Unit */) {
        visitor(this)
        val queue =  LetsQueue<TreeNode<T>>()
        children.forEach {
            queue.enqueue(it)
        }
        var node = queue.dequeue()
        while (node != null) {
            visitor(node)
            node.children.forEach {
                queue.enqueue(it)
            }
            node = queue.dequeue()
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

    println("Depth First Traversal")
    root.letsTravelToDepthFirst {
        println(it.dataItem)
    }
    println("Level Order ")
    root.letsForLevelOrder {
      println(it.dataItem)
    }
}
