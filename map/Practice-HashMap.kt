import java.util.Objects.hash
import kotlin.math.max

class LetsHashMap<K,V>(capacity: Int) {

    private class MapNode<K,V>(
        var nodeKey: K?,
        var nodeValue: V?,
        var nodeHashCode:Int?,
        var nextMapNode: MapNode<K,V>?) {

        override fun hashCode(): Int {
            //Logic of book
            val code = (nodeKey.hashCode() ?: 0).xor(nodeValue?.hashCode() ?: 0)

            //Own Logic
            val hCode = (97 * nodeKey.hashCode()).rem(97 * nodeValue.hashCode()).times(nodeKey.hashCode() + nodeValue.hashCode())
            println("My Own Hash Code : $hCode")
            return hCode
        }
        override fun equals(other: Any?): Boolean {
            //Default in Book Logic
            /***
            if (other === this) return true
            if((other is MapNode<*,*>) && other.nodeKey == this.nodeKey && other.nodeValue == nodeValue) return true
            return false
            ***/


            //My Own Logic, ~same as above
            if(other == this) return true
            if(other.hashCode() == this.hashCode()) return true
            val otherNode = this as MapNode<*, *>       //as MapNode<Any?, Any?> --> Unchecked Cast,
            if (otherNode.nodeKey == this.nodeKey && otherNode.nodeValue == this.nodeValue) return true
            return false
        }
        override fun toString(): String =  "[$nodeKey] = $nodeValue"  //"${this.javaClass.name}[$nodeKey] = $nodeValue"
    }


    private var elementTable: Array<MapNode<K,V>?>
    private var minCapacity = 1 shl 4  //(2.pow(4))
    private var maxCapacity = 1 shl 30 //(2.pow(30))
    private var size = 0


    init {
        val finalCapacity = when {
            capacity < minCapacity -> minCapacity
            capacity > maxCapacity -> maxCapacity
            else -> requestNearestCapacity(capacity)
        }
        elementTable = arrayOfNulls(finalCapacity)
    }

    private fun requestNearestCapacity(capacity: Int) : Int {
        var num = capacity -1
        while (num and num - 1 != 0) { num = num and num -1}
        return num shl 1
    }

    //Add Element, Update Element
    fun put(key:K?, value: V?) {
        val hash = hash(key)
        val index = (elementTable.size - 1) and hash
        var first = elementTable[index]

        if(first == null) {
            elementTable[index] = MapNode(key,value,hash,null)
            ++size
        } else {
            //Collision happened, Either Add Node or Update Value
            var node: MapNode<K,V>? = null
            while (true) {
                node = first?.nextMapNode
                if(node == null) { //Create
                    first?.nextMapNode = MapNode(key,value,hash,null)
                    break
                }
                if(node.nodeKey === key && node.nodeHashCode == hash) { //Update
                    node.nodeValue = value
                    break
                }
                first = node
            }
        }
    }

    //Get
    fun getHashValue(key: K?) : V? {
        val hashOfThisKey = hash(key)
        val index = (elementTable.size - 1) and hashOfThisKey
        var firstNode = elementTable[index]
        var value : V? = null

        if(firstNode != null) {
            if(key === firstNode.nodeKey && hashOfThisKey == firstNode.nodeHashCode) {
                value = firstNode.nodeValue
            } else {
                var node : MapNode<K,V>? = null
                while (true) {
                    node = firstNode?.nextMapNode
                    if (node != null) {
                        if(key === node.nodeKey && hashOfThisKey == node.nodeHashCode) {
                            value = node.nodeValue
                            break
                        }
                        firstNode = node
                    } else break
                }
            }
        }

        return value
    }

    //Get All
    fun returnAllElement(): ArrayList<String> {
        var mapList = arrayListOf<String>()
        for ((index, element) in elementTable.withIndex()) {
            if(element != null) {
                var node = elementTable[index]
                mapList.add(node.toString())
                while (node?.nextMapNode != null) {
                    mapList.add(node.toString())
                    node = node.nextMapNode
                }
            }
        }
        return mapList
    }

    //Remove
    fun deleteElement(key: K?) {
        val hash = hash(key)
        val index = (elementTable.size -1) and hash
        var first = elementTable[index]

        if(first != null) {
            if(first.nodeKey === key && first.nodeHashCode == hash) {
                elementTable[index] = first.nextMapNode
                size--
            } else {
                while (true) {
                    val head = first?.nextMapNode
                    if(head != null) {
                        if(head.nodeKey === key && head.nodeHashCode == hash) {
                            first?.nextMapNode = head.nextMapNode
                            size--
                            break
                        }
                    }
                    first = head?.nextMapNode
                }
            }
        } else println("Cant Delete, Key $key Not Found in Map")
    }
}

fun main() {
    LetsHashMap<Int,String>(16).apply {


        repeat(64) {
            val num = it % 64
            put(num,"ASP-$num")
        }

        repeat(32) {
            val num = it % 32
            put(num,"UPDATE-$num")
        }

        deleteElement(1)
        println(returnAllElement().toTypedArray().contentToString())

    }
}
