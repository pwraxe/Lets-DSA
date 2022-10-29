//TODO --> HashMap

class LetsHashMap<K,V> {
    private var minCapacity : Int = 1 shl 4
    private var maxCapacity : Int = 1 shl 16
    private var size : Int = 0

    class Node<K,V>(
        var hashCode : Int,
        var key: K,
        var value : V,
        var nextNode: Node<K,V>?) {

        override fun hashCode(): Int = (key?.hashCode() ?: 0).xor(value.hashCode() ?: 0)
        override fun equals(other: Any?): Boolean {
            if(other == this) return true
            if(other is Node<*,*> && other.key == key && other.hashCode == hashCode) return true
            return false
        }
        override fun toString(): String = "$key = $value"
    }

    private var table: Array<Node<K,V>?>

    constructor() {
        table = arrayOfNulls(minCapacity)
    }

    constructor(capacity : Int) {
        if(capacity < 0) throw IllegalArgumentException("Invalid Capacity : $capacity")
        val finalCapacity = when {
            capacity < minCapacity -> minCapacity
            capacity > maxCapacity -> maxCapacity
            else -> getNearestCapacity(capacity)
        }
        table = arrayOfNulls(finalCapacity)
    }

    private fun getNearestCapacity(capacity: Int): Int {
        var num = capacity - 1
        while (num and num -1 == 0) num = num and num - 1
        return num shr 1
    }

    //CREATE, UPDATE
    fun put(key:K,value: V) {
        val hashV = hash(key)
        val tableSize = table.size-1
        val index = hashV and tableSize
        var element = table[index]

        if(element == null) {
            Node<K,V>(hashV,key,value,null).apply {
                table[index] = this
                size++
            }
        } else {
            if(element.nextNode != null) {
                //More than 1 element
                do {

                    if(element.key == key && element.hashCode == hashV) {
                        element?.value = value
                        break
                    }

                    if (element?.nextNode == null) {
                        Node<K,V>(hashV,key,value,null).apply {
                            element.nextNode = this
                            size++
                        }
                        break
                    }

                }while (element.nextNode != null)
            } else {
                //single element,
                if(element.key == key && element.hashCode == hashV) {
                    //Update Value
                    element.value = value
                } else {
                    Node<K,V>(hashV,key,value,null).apply {
                        element.nextNode = this
                        size++
                    }
                }
            }
        }
    }

    //READ
    fun getAll() : List<String> {

        val list = arrayOfNulls<String>(table.size)

        for (index in 0 until table.size-1) {

            val element = table[index]
            if(element != null) {
                do{
                    list[index] = "${element.key} = ${element.value.toString()}"
                } while (element.nextNode != null)
            }
        }
        return list.filterNotNull()
    }
    fun getSize() = size

    //DELETE
    fun remove(key: K) {

        val hashV = hash(key)
        val tableSize = table.size-1
        val index = hashV and tableSize
        var element = table[index]

        //no element
        //1 element
        //more than 1 element

        if (element == null) {
            //no element at index
            println("No Element Found")
        } else {
            if(element.nextNode != null) {
                //more than element
                do {
                    val node = element.nextNode
                    if (node?.key == key && node?.hashCode == hashV) {
                        if (node.nextNode == null) {
                            element.nextNode = null
                            size--
                            break
                        } else {
                            element.nextNode = node.nextNode
                            size--
                            break
                        }
                    }
                }while (element.nextNode != null)

            } else {
                //one element
                if(element.key == key && element.hashCode == hashV) {
                    table[index] = null
                    size--
                } else {
                    println("Cant found matched element")
                }
            }
        }
    }
}

fun main() {

    LetsHashMap<String,String>().apply {

        //CREATE
        put("K001","Akshay-001")
        put("K002","Akshay-002")
        put("K003","Akshay-003")
        put("K004","Akshay-004")

        //UPDATE
        put("K001","A001")
        put("K002","A002")
        put("K003","A003")
        put("K004","A004")

        //REMOVE
        remove("K001")
        remove("K002")
        remove("K003")
        remove("K004")

        //READ
        println("${getSize()} | ${getAll()}")
    }
}
