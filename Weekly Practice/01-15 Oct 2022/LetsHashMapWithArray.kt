/**
 * DisAdvantages of HashMap :
 *  -> As HashMap Store data in Node so each node requires storing address of next node
 *  -> Most indexes in Hashmap could be null
 *
 *  To Remove above disadvantages, lets create new list with following objective
 *   * Objective :
 *  -> Create HashMap with Vector Array of objects/Node
 *  -> Instead of Node, Store data in Object
 *  -> try to make dynamic array
 * **/
//Own Code, Own Program
//Analysis
//This code have worst case complexity, 
//Bcoz, each time insert or update need to search element i.e O(n)
//CRUD : O(n)

class LetsHashMapWithArray<K,V> {

    class Node<K,V> (
        var hashCode : Int,
        var key:K,
        var value:V) {

        override fun hashCode(): Int = (key.hashCode() ?: 0).xor(value.hashCode() ?:0)

        override fun equals(other: Any?): Boolean {
            if(other == this) return true
            if(other is Node<*,*> && other.key == key && other.hashCode == hashCode) return true
            return false
        }
        override fun toString(): String = "$key -> $value"
    }

    private var capacity : Int = 6
    private var table : Array<Node<K,V>?>? = null
    private var size : Int = 0

    constructor() {
        table = arrayOfNulls<Node<K,V>>( capacity)
    }

    constructor(cap : Int) {
        if(cap < 0) throw IllegalArgumentException("Invalid Capacity Bro : $cap")
        table = arrayOfNulls(cap)
    }

    //CREATE, UPDATE
    fun put(key:K,value:V) {
        val hashCode = hash(key)
        if (size == table?.size) {
            val newArray = LetsHashMapWithArray<K,V>((size+capacity)).table
            System.arraycopy(table,0,newArray,0,size)
            table = newArray
        }
        //search for existing value
        var isFound = false
        for (index in 0 until size) {
            val element = table?.get(index)
            if (element?.key == key && element?.hashCode == hashCode) {
                isFound = true
                //Update Value
                element.value = value
            }
        }
        if (!isFound) {
            //add new value
            table?.set(size,Node<K,V>(hashCode,key, value))
            size++
        }
    }

    //READ
    fun getIndex(index:Int) : V? {
        if(index > size || index < 0) throw IndexOutOfBoundsException("Invalid index BRO : $index")
        return table?.get(index)?.value
    }
    fun getAll() : Array<String?> {
        val list = arrayOfNulls<String>(table?.size!!)
        table?.forEachIndexed { index, node ->
            list[index] = "${node?.key} -> ${node?.value}"
        }
        return list
    }
    fun getSize() : Int = size

    //DELETE
    fun remove(key: K) {
        val hashCode : Int = hash(key)
        var isFound = false

        for (index in 0 until size) {
            val element = table?.get(index)
            if(element?.key == key && element?.hashCode == hashCode) {
                isFound = true
                System.arraycopy(table,index+1,table,index,size-index)
                size--
                break
            }
        }
        println(if (isFound) "Element Removed" else "No element found")
    }
}

fun main() {

    LetsHashMapWithArray<Int, String>(8).apply {

        //CREATE
        put(1,"Akshay")
        put(2,"Aman")
        put(3,"Babli")
        put(4,"Cyan")

        //Update
        put(2, "FAANG")
        put(5,"NEW DATA")

        //REMOVE
        remove(3)

        //READ
        println("${getSize()} | ${getAll().contentToString()} | ${getIndex(2)}")
    }

}
