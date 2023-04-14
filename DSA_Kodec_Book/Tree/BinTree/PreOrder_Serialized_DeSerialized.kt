/**
 * Note : Here Deserialization returning null values extra even Deserialization complete
 * **/

typealias Visitor<T> = (T?) -> Unit

class BinNode<T> (val node :T) {
    var leftNode : BinNode<T>? = null
    var rightNode : BinNode<T>? = null

    fun preOrderTraversalWithNull(visitor: Visitor<T>) {
        visitor(node)
        leftNode?.preOrderTraversalWithNull(visitor) ?: visitor(null)
        rightNode?.preOrderTraversalWithNull(visitor) ?: visitor(null)
    }

    //Challenge 2 : Serialization
    fun preOrderTraversalSerialisation(node: BinNode<T>? = this) : MutableList<T?> {
        val list = mutableListOf<T?>()
        node?.preOrderTraversalWithNull {
            list.add(it)
        }
        return list
    }

    //Challenge 2 : Deserialization
    fun preOrderTraversalDeSerialisation(list: MutableList<T?>) : BinNode<T?>? {
        val rootValue =  if(list.size > 0) list.removeAt(list.size-1) else return null
        val root = BinNode<T?>(rootValue)
        root.leftNode = preOrderTraversalDeSerialisation(list)
        root.rightNode = preOrderTraversalDeSerialisation(list)
        return root
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

    val serialisedList = one.preOrderTraversalSerialisation()
    println("List : $serialisedList")

    val rootNode = one.preOrderTraversalDeSerialisation(serialisedList)
    rootNode?.preOrderTraversalWithNull {
        print("$it, ")
    }
}

/**
 * 
 * Serialization List : [1, 2, 8, 128, null, null, 256, null, null, 16, null, null, 4, 32, 512, null, null, 1024, null, null, 64, null, null]
 * Deserialization List : null, null, 64, null, null, 1024, null, null, 512, 32, 4, null, null, 16, null, null, 256, null, null, 128, 8, 2, 1, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
 * Deserialization List size : 47
 **/
