data class Node<T>(var dataItem: T?, var nextNode: Node<T>? = null) {
    override fun toString(): String {
        return if(nextNode != null) {
            "$dataItem -> ${nextNode?.toString()}"
        } else "$dataItem"
    }
}

fun main() {
    val n1 = Node("A")
    val n2 = Node("K")
    val n3 = Node("S")
    val n4 = Node("H")
    val n5 = Node("A")
    val n6 = Node("Y")

    n1.nextNode = n2
    n2.nextNode = n3
    n3.nextNode = n4
    n4.nextNode = n5
    n5.nextNode = n6

    println(n1)
}
