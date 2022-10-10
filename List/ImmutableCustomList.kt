import kotlin.math.min

/** Create Custom Immutable List (Custom Not_Changeable List)**/

class ImmutableAnyDataList<G> {

    private val minCapacity = 6
    private var listElements : Array<Any?>
    private var size = 0

    constructor(){
        //listElements = arrayOf() //--> thrown ArrayIndexOutOfBoundsException

        listElements = Array<Any?>(minCapacity) { null }
        //OR
        //listElements = ImmutableAnyDataList<G>(minCapacity).listElements
    }

    constructor(capacity: Int) {
        when {
            capacity == 0|| capacity > 0 -> listElements = Array(capacity){ null }
            else -> throw IllegalArgumentException("Invalid Capacity : $capacity")
        }
    }

    constructor(vararg items: Any?) {
        listElements = items as Array<Any?>
    }

    fun add(item: G) {

        if(size == listElements.size) {

            val newArray = ImmutableAnyDataList<G>(size + (getNewCapacity(size)))
            System.arraycopy(listElements,0,newArray.listElements,0,size)
            listElements = newArray.listElements
        }
        listElements[size] = item
        size += 1
    }

    fun getElements() = listElements

    fun get(index: Int) : Any {
        if(index > size) {
            throw ArrayIndexOutOfBoundsException("Getting Elements from Invalid Index : $index")
        }
        return listElements[index]!!
    }

    fun getOrNull(index: Int) : Any?{
        if(index > listElements.size) {
            throw IllegalArgumentException("Getting Elements from Invalid Index : $index")
        }
        return listElements[index]
    }

    fun set(index: Int, item: G) {
        if(index > size) {
            throw IllegalArgumentException("Setting Elements to Invalid Index : $index")
        }
        listElements[index] = item
    }

    fun setIfNull(index: Int, item: G) {
        if(index > listElements.size) {
            throw IllegalArgumentException("Setting Elements to Invalid Index : $index")
        }
        listElements[index] = item
    }

    fun isEmpty() = size == 0

    fun originalSize() = size

    fun listSize() = listElements.size

    fun isExists(item : G?) : Boolean {
        var flag = false
        lable@ for (element in listElements) {
            /** Due to this code loop will run till end of the list**/
            //if (element == item) flag = true

            //println("Element : $element | $item == ${element == item}")
            /** Due to this loop will run till element found else till end of list **/
            if (element == item) {
                flag = true
                break@lable
            }
        }
        return flag
    }

    fun indexOf(element:G?) : Int {
        var indx = -1
        out@ for ((index,value) in listElements.withIndex()) {
            if(element == value) { //OR listElements[index]
                indx = index
                break@out
            }
        }
        if(indx == -1) throw NoSuchElementException("$element Not Found In List")
        return indx
    }

    fun lastIndexOf(element: G?) : Int {
        var indx = -1
        for ((index,value) in listElements.withIndex()) {
            if(element == value) indx = index
        }
        if(indx == -1) throw NoSuchElementException("$element Not Found In List")
        return indx
    }

    private fun getNewCapacity(current: Int) : Int {
        return if(current > 0) {
            current shr 1
        } else throw IllegalArgumentException("Invalid Capacity Entererd")
    }
}


fun main() {
    ImmutableAnyDataList<Any?> ().apply {

        println("is Empty : ${isEmpty()}")

        add("Akshay")
        add(26)
        add(true)
        println(this.getElements().contentToString())

        println("Element (1)   : ${get(1)}")
        //println("Exception (4) : ${get(4)}")  ArrayIndexOutOfBoundsException
        println("Element : ${getOrNull(2)}")
        println("Element or Null : ${getOrNull(3)}")
        set(2,100)
        setIfNull(5,"NEW ELEMENT")
        println("List after Set/Update : ${getElements().contentToString()}")
        println("is Empty : ${isEmpty()}")
        println("List Size / Total Elements : ${listSize()} / ${originalSize()}")
        println("Is Exists : ${isExists("26")} | isExist : ${isExists(26)}")
        println("Index Of : ${indexOf("Akshay")}  |  ${indexOf(null)} ")

        add(26)
        add("26")
        println("\n Elements : ${getElements().contentToString()}")
        println("Last Index of ${lastIndexOf(26)}")
    }

    ImmutableAnyDataList<Any?>(8).apply {
        add("Hi")
        add(8.88)
        add(false)
        println(this.getElements().contentToString())
    }

    ImmutableAnyDataList<Any?>("111","222","333").apply {
        println(this.getElements().contentToString())
    }
}


 

//No Use of this method, Just written for use in future
inline fun <T> isWorking(letsCheck:()-> T) : T? {
    return if(true) letsCheck() else null
}

