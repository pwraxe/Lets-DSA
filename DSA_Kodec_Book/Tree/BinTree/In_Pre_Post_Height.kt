import kotlin.math.max

typealias Visitor<T> = (T) -> Unit

class BinNode<T> (val node :T) {
    var leftNode : BinNode<T>? = null
    var rightNode : BinNode<T>? = null

    fun preOrderTraversal(visitor: Visitor<T>) {
        visitor(node)
        leftNode?.preOrderTraversal(visitor)
        rightNode?.preOrderTraversal(visitor)
    }

    fun inOrderTraverse(visitor: Visitor<T>) {
        leftNode?.inOrderTraverse(visitor)
        visitor(node)
        rightNode?.inOrderTraverse(visitor)
    }

    fun postOrderTraversal(visitor: Visitor<T>) {
        leftNode?.postOrderTraversal(visitor)
        rightNode?.postOrderTraversal(visitor)
        visitor(node)
    }

    fun heightOfTree(node: BinNode<T>? = this) : Int {
        return node?.let {
            1 + max(heightOfTree(node.leftNode), heightOfTree(node.rightNode))
        } ?: -1
    }

    


}
fun main() {

    val one = BinNode(1)
    val two = BinNode(2)
    val four = BinNode(4)
    val eight = BinNode(8)
    val sixteen = BinNode(16)
    val thirty2 = BinNode(32)
    val sixty4 = BinNode(64)
    val one28 = BinNode(128)
    val two56 = BinNode(256)
    val five12 = BinNode(512)
    val ten24 = BinNode(1024)


    one.leftNode = two
    one.rightNode = four

    two.leftNode = eight
    two.rightNode = sixteen

    eight.leftNode = one28
    eight.rightNode = two56

    four.leftNode = thirty2
    four.rightNode = sixty4

    thirty2.leftNode = five12
    thirty2.rightNode = ten24

    print("Pre : ")
    one.preOrderTraversal {
        print("$it, ")
    }

    println("\n-------------------------------")

    print("In : ")
    one.inOrderTraverse {
        print("$it, ")
    }
    println("\n-------------------------------")

    print("Post : ")
    one.postOrderTraversal {
        print("$it, ")
    }
    println("\n")

    println("Height of Node : ${one.heightOfTree(one)}")
}
