class Node(var dataItem: Int, var next: Node? = null)

//Assignment
class LinkedList {
    private var headNode: Node? = null

    init {
        headNode = Node(1, Node(2, Node(3,
                Node(4, Node(5, Node(6,
                Node(7, Node(8, Node(9, Node(10))))))))))
    }

    fun read() {
        var node = headNode
        while (node != null) {
            print("-> ${node.dataItem}")
            node = node.next
        }
        println()
    }

    //Question - 1
    fun findMergingPoint(head1:Node?, head2: Node?): Node? {
        var node1 = head1
        var node2 = head2
        while (node1 != node2) {
            if (node1 == null) node1 = head2
            if (node2 == null) node2 = head1
            if (node1 == node2) break
            node1 = node1?.next
            node2 = node2?.next
        }
        return node1
    }

    //Question - 2 || Problematic
    fun delete_M_NodeAfterN_Node(m:Int, n: Int) {

        var index = 1
        var node = headNode
        while (node != null) {

            while (index < m && node != null) {
                index++
                node = node.next
            }
            if (node == null) return

            var temp = node.next

            index = 1
            while (index <= n && temp != null) {
                index++
                val t = temp
                temp = temp.next
            }
            node.next = temp
            node = temp
        }
    }

}

fun main() {
    LinkedList().apply {

        val node7 = Node(7)
        val node6 = Node(6, node7)
        val node5 = Node(5, node6)
        val node4 = Node(4, node5)
        val node3 = Node(3, node6)
        val node2 = Node(2, node3)
        val node1 = Node(1, node2)

        val head1 = node1
        val head2 = node4

        //println(findMergingPoint(head1, head2)?.dataItem)
    }

    LinkedList().apply {
        //read()
        delete_M_NodeAfterN_Node(2,2)
        read()
    }
}
