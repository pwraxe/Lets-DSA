import java.util.Objects.hash
class LetsHashMap<K,V> {

    private val minCapacity = 1 shl 4       //(2 pow 4)  = 16
    private val maxCapacity = 1 shl 30      //(2 pow 30) = 1073741824

    private var table : Array<Node<K,V>?>
    private var size = 0

    constructor() {
        table = arrayOfNulls(minCapacity)
    }
    constructor(capacity : Int) {
        if(capacity < 0) throw IllegalArgumentException("Invalid Capacity : $capacity")
        val finalCapacity = when {
            capacity < minCapacity -> minCapacity
            capacity > maxCapacity -> maxCapacity
            else -> fetchNearestCapacity(capacity)
        }
        this.table = arrayOfNulls(finalCapacity)
    }

    private fun fetchNearestCapacity(n: Int): Int {
        var num = n - 1
        while (num and num - 1 != 0) { num = num and num - 1 }
        return num shl 1
    }

    private class Node<K,V>(
        var hash: Int,
        var key: K,
        var value: V,
        var nextNode: Node<K, V>?,
    ) {

        override fun hashCode(): Int = (key?.hashCode() ?: 0).xor(value?.hashCode() ?: 0)

        override fun equals(other: Any?): Boolean {
            if(other === this) return true
            if(other is Node<*,*> && other.key == this.key && other.value == this.value) return true
            return false
        }

        override fun toString(): String = "(Key : $key, Value : $value)"
    }

    fun putValue(key: K,value: V, ifAbsence: Boolean = false) {
        val hash = hash(key)
        val size = table.size
        val index = hash and (size-1)
        var element = table[index] //OR --> table[(hash(key) and (table.size-1))]
//        println("PUT >>---> $hash | $size | $index | $element | ${element?.value}\n")
        if(element == null) {
            table[index] = Node(hash,key,value,null)
            this.size++
        } else {
            var node : Node<K,V>?
            var k = element.key
            if(element.hash == hash && (element.key == key || element.key === key)) {
                element.value = value
            } else {
                while (true) {
                    node = element?.nextNode
                    if(node == null) {
                        element?.nextNode = Node(hash,key,value,null)
                        this.size++
                        break
                    }
                    k = node.key
                    if(node.hash == hash && (k == key || k === key)) {
                        node.value = value
                        break
                    }
                    element = node
                }
            }
        }
    }

    fun getValue(key: K) : V? {
        val hash = hash(key)
        val size = table.size
        val index = hash and (size-1)
        val element = table[index]

        return if(element != null) {
            var temp : V? = null
            do {
                val isFound = (element.key == key || element.key === key) && element.hash == hash
                if(isFound){
                    temp = element.value
                    break
                }
            }while (element.nextNode != null)
            temp
        } else null
    }

    fun removeValue(key:K) : V? {
        val hash = hash(key)
        val index = (hash and (table.size - 1))
        var first = table[index]

        if(table.isNotEmpty() && first != null) {
            var node : Node<K,V>? = null
            var k = first.key
            if(first.hash == hash && (key == k || key === k)) {
                node = first
            } else {
                var nextNode = first.nextNode
                if(nextNode != null) {
                    do{
                        k = nextNode?.key!!
                        if(nextNode.hash == hash && (k == key || k === key)) {
                            node = nextNode
                            break
                        }
                        first = nextNode
                        nextNode = nextNode.nextNode
                    }while (nextNode != null)
                }
            }
            //-------------------------------------------------------
            if(node != null) {
                if(node == first) table[index] = node.nextNode
                else first?.nextNode = node.nextNode
                size--
                return node.value
            }
        }
        return null
    }
}

//***************************************************************OWN WAY ***********************************

class LetsHashMapOwnWay<K,V>{
    private var minCapacity : Int = 1 shl 4
    private var maxCapacity : Int = 1 shl 30
    private var table : Array<Node<K,V>?>? = null
    private var size: Int = 0

    class Node<K,V>(
        var hashCode: Int,
        var key: K,
        var value: V,
        var nextNode:Node<K,V>?) {

        override fun hashCode(): Int {
            return (key.hashCode() ?: 0).xor(value?.hashCode() ?: 0)
        }

        override fun equals(other: Any?): Boolean {
            if(other == this) return true
            if(other is Node<*, *> && other.key == this.key && other.value == this.value) return true
            return false
        }

        override fun toString(): String = "$key >>--> $value"
    }
    constructor() {
        table = arrayOfNulls(minCapacity)
    }
    constructor(capacity: Int) {
        val finalCapacity = when {
            capacity > maxCapacity ->maxCapacity
            capacity < minCapacity -> minCapacity
            else -> requestNearestPowOf2(capacity)
        }
        table = arrayOfNulls(finalCapacity)
    }
    private fun requestNearestPowOf2(capacity: Int) : Int {
        var num = capacity-1
        while (num and num -1 != 0) {
            num = num and num - 1
        }
        return num shl 1
    }

    fun put(key: K, value:V) {

        val hashCode = hash(key)
        val tableSize = table?.size!! - 1
        val index = hashCode and tableSize
        var element = table?.get(index)

        if(element == null) {
            table?.set(index,Node<K,V>(hashCode,key,value,null))
            size++
        } else {
            //We already have element at index
            if(element.nextNode != null) {
                //we have next element in list
                do {

                    if(element.key == key && element.hashCode == hashCode) {
                        element.value = value
                        break
                    }
                    if(element.nextNode == null) {
                        element.nextNode = Node<K,V>(hashCode,key,value,null)
                        size++
                        break
                    }
                }while (element.nextNode != null)

            } else {
                //We have 1 element in list
                if(element.key == key && element.hashCode == hashCode) {
                    element.value = value
                } else {
                    element.nextNode = Node<K,V>(hashCode,key,value,null)
                    size++
                }
            }
        }
    }

    fun get(key: K) : V? {

        var hashCode = hash(key)
        var index = (table?.size!!-1) and hashCode
        val element = table?.get(index)
        var value : V? = null
        if(element == null) return null
        else {
            if(element.nextNode == null) value = element.value
            else {
                do {
                    if(element.key == key && element.hashCode == hashCode) {
                        value = element.value
                        break
                    }
                }while (element.nextNode != null)
            }
        }
        return value
    }

    fun remove(key:K) {
        val hash = hash(key)
        val index = (table?.size!! - 1) and hash
        var element = table?.get(index)

        if(element != null) {

            if(element.nextNode != null) {
                //we have more than 2 element in list
                //Check for first node
                if(element.key == key && element.hashCode == hash) {
                    table?.set(index,element.nextNode)
                    size--
                } else {
                    do{
                        val node = element?.nextNode
                        if(node?.key == key && node?.hashCode == hash) {
                            element?.nextNode = if(node.nextNode != null) {
                                //delete middle node
                                 node.nextNode
                            } else {
                                //delete last node
                                null
                            }
                            size--
                            break
                        }
                        element = node

                    }while (node?.nextNode != null)
                }
            } else {
                //we have only one element in list
                if(element.key == key && element.hashCode == hash) {
                    table?.set(index,null)
                    size--
                }
            }
        }
    }

    //TimeComplexity : O(n*n) (supposed) (!confirm)
    fun getAllElements(): Array<String?> {
        var list = Array<String?>(table?.size!!){ null }

        for (index in 0 until table?.size!!-1) {
            val element = table?.get(index)
            if(element != null) {
                do {
                    list[index] = "[${index}] --> ${element.key} = ${element.value}"
                }while (element.nextNode != null)
            }
        }
        return list
    }
}

fun main() {

    LetsHashMapOwnWay<String,String>().apply {

        //Insert
        put("K-01","Akshay1")
        put("K-02","Akshay2")
        put("K-03","Akshay3")

        //Update
        put("K-02","Science")

        //Read
        println(getAllElements().contentToString())

        //Delete
        remove("K-02")

        //Read for cheking delete
        println(getAllElements().contentToString())
    }
    
    LetsHashMap<String, String>().apply {
        //PUT
        putValue("K-001","Akshay")
        putValue("K-002","Alex")
        //GET
        println("Value : ${getValue("K-001")}")

        //PUT
        putValue("K-003","Aman")
        putValue("K-004","Bikaner")

        //UPDATE
        putValue("K-003","Google")
        println("Value : ${getValue("K-003")}")

        //REMOVE
        println("Value B4 Remove : ${getValue("K-002")}")
        removeValue("K-002")
        println("Value After REmove : ${getValue("K-002")}")
    }
}
