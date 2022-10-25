//TODO  --> 8. Create Stack Using Vector
class StackByVector<T> {

    private var minCapacity : Int = 6
    private var elements : Array<Any?>?
    private var size : Int = 0

    constructor() {
        elements = arrayOfNulls(minCapacity)
    }

    constructor(capacity : Int) {
        if(capacity < 0) throw IllegalArgumentException("Invalid Capacity : $capacity")
        elements = arrayOfNulls(capacity)
    }

    //CREATE
    fun push(item:T) {
        if(size == elements?.size) {
            val incCapacity = size shr 1
            val newArray = StackByVector<T>(minCapacity + incCapacity)
            System.arraycopy(elements!!,0,newArray.elements!!,0,size)
            elements = newArray.elements
        }
        elements?.set(size, item)
        size++
    }

    //READ
    fun getSize() : Int = size
    fun getPeak() : T? = elements?.get(getSize()-1) as T?
    fun getAll() : Array<Any?>? = elements

    //DELETE
    fun pop() {
        if(size > 0) {
            elements?.set(getSize()-1,null)
            size--
        }
    }
    fun popAll() {
        elements = arrayOfNulls(getSize())
        size = 0
    }

    //UPDATE
    fun set(index:Int,item: T) {
        if(index > size || index < 0) throw IndexOutOfBoundsException("Invalid index : $index")
        elements?.set(index,item)
    }
}
fun main() {

    StackByVector<Any> (4).apply {
        push(10)
        push(11)
        push(12)
        push(13)

        set(2,128)

        pop()
        println("${getPeak()} | ${getAll().contentToString()} | ${getSize()}")

        popAll()
        println("${getAll().contentToString()}")
    }
}
