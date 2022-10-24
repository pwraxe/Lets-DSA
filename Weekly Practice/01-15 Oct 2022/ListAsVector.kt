//TODO --> 2. Vector

class ListAsVector<T> {

    private var minCapacity : Int = 6
    private var elements : Array<Any?>? = null
    private var size : Int = 0

    constructor() {
        elements = arrayOfNulls(minCapacity)
    }
    constructor(capacity : Int) {
        if (capacity < 0) throw IllegalArgumentException("Invalid Capacity : $capacity")
        elements = arrayOfNulls(capacity)
    }

    //CREATE
    fun addFirst(item:T) {
        if(size > 0) {

            if(size == elements?.size) {
                //we are full of list, create new with big size
                val incSize = size shr 1
                val newArray = arrayOfNulls<Any>(size+incSize)
                System.arraycopy(elements!!,0,newArray,0,size)
                elements = newArray
            } else {
                val newArray = arrayOfNulls<Any>(elements?.size!!)
                System.arraycopy(elements!!,0,newArray,1,size)
                elements = newArray
            }
        }
        elements?.set(0,item as T)
        size++
    }
    fun addAt(index:Int,item:T) {

        if(index < 0 || index > size) throw IndexOutOfBoundsException("Invalid Index : $index")
        if(size == elements?.size) {
            val incSize = size shr 1
            val newArray = arrayOfNulls<Any>(incSize+size)
            System.arraycopy(elements,0,newArray,0,size)
            elements = newArray
        }
        System.arraycopy(elements,index,elements,index+1,size-index)
        elements?.set(index, item as T)
        size++
    }
    fun add(item:T) {

        if(size == elements?.size) {
            val incSize = size shr 1
            val newArray = ListAsVector<T>(size+incSize).elements
            System.arraycopy(elements,0,newArray,0,size)
            elements = newArray
        }
        elements?.set(size,item)
        size++
    }

    //READ
    fun getSize() : Int = size
    fun getFirst() : T? = elements?.get(0) as T?
    fun get(index:Int):T {
        if(index < 0 || index > size) IndexOutOfBoundsException("Invalid index : $index")
        return elements?.get(index) as T
    }
    fun getAll() : Array<Any?> = elements!!
    fun getLast() : T? = if(size > 0) {
        elements?.get(size-1) as T
    } else null

    //UPDATE
    fun setAt(index:Int,item:T){
        if(index < 0 || index > size) throw IndexOutOfBoundsException("Invalid Index : $index")
        elements?.set(index,item)
    }
    fun setFirst(item:T){
        if(size > 0) elements?.set(0,item)
    }
    fun setLast(item:T) {
        if(size > 0) elements?.set(size - 1, item)
    }

    //DELETE But Just Assingning Null to index
    //Suffix with Nullable is remove element at index but assing null value there
    fun removeFirstNullable(){
        if(size > 0) {
            elements?.set(0,null)
            size--
        }
    }
    fun removeAtNullable(index:Int){
        if(index < 0 || index > size ) IndexOutOfBoundsException("Invalid Index : $index")
        elements?.set(index,null)
        size--
    }
    fun removeLastNullable() {
        if(size > 0) {
            elements?.set(size-1,null)
            size--
        }
    }

    fun removeFirst() {
        if (size > 0) {
            System.arraycopy(elements,1,elements,0,size-1)
            elements?.set(size-1,null)
            size--
        }
    }
    fun removeAt(index:Int){
        if(index < 0 || index > elements?.size!!) {
            throw IndexOutOfBoundsException("Invalid Index : $index")
        }
        System.arraycopy(elements,index+1,elements,index,size-index-1)
        elements?.set(size-1,null)
        size--
    }
    fun removeLast() {
        if(size > 0) {
            elements?.set(size-1,null)
            size--
        }
    }
}

fun main() {

    ListAsVector<Int>().apply {
        addFirst(10)
        addFirst(9)
        addFirst(8)
        addFirst(7)
        addAt(3,33)
        addAt(5,55)
        add(77)
        add(88)
        add(99)

        println(getAll().contentToString())

        println("First : ${getFirst()} | ${get(3)} | ${getLast()} | ${getSize()}")

        setAt(2,99)
        setFirst(77)
        setLast(999)

        println(getAll().contentToString())

        removeFirst()
        removeAt(3)
        removeLast()

        println(getAll().contentToString())

        //assign null to index
        removeFirstNullable()
        removeLastNullable()
        removeAtNullable(3)

        println(getAll().contentToString())
    }
}
