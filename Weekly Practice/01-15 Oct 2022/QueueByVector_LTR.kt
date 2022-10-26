//TODO --> 11. Create Queue Using Vector (From LTR) (Insert From Left/Start/Front **AND** Remove From Right/End/Rear)

class QueueByVectorLTR<T> {

    private var minCapacity : Int = 6
    private var elements : Array<Any?>?
    private var size : Int = 0
    
    constructor() {
        elements = arrayOfNulls(minCapacity)
    }
    constructor(capacity : Int) {
        if(capacity < 0 ) throw IllegalArgumentException("Invalid Capacity : $capacity")
        elements = arrayOfNulls(capacity)
    }

    //CREATE
    fun enqueue(item : T) {
        if(size == elements?.size) {
            val incCapacity = size shr 1
            val newArray = QueueByVectorLTR<T>(size + incCapacity)
            System.arraycopy(elements!!,0,newArray.elements!!,1,size)
            elements = newArray.elements
        } else {
            System.arraycopy(elements,0,elements,1,size)
        }
        elements?.set(0,item)
        size++
    }

    //READ
    fun getFront() : Any? = if (size > 0) elements?.get(0)  else null
    fun getRear() : Any? = if (size > 0) elements?.get(getSize()-1) else null
    fun getSize() = size
    fun getAll() = elements

    //UPDATE
    fun updateFirst(item: T) {
        if(size > 0) {
            elements?.set(0,item)
        } else println("MT, Cant update first")
    }
    fun updateLast(item: T) {
        if(size > 0) {
            elements?.set(getSize()-1,item)
        } else println("MT, Cant update last")
    }
    fun updateIndex(index: Int,item: T) {
        if(index > size || index < 0) throw IndexOutOfBoundsException("Invalid index : $index")
        when(index) {
            0 -> updateFirst(item)
            getSize() -> updateLast(item)
            else -> {
                elements?.set(index,item)
            }
        }
    }

    //DELETE
    fun dequeue() {
        if(size > 0) {
            elements?.set(getSize()-1,null)
            size--
        }
    }
}

fun main() {

    QueueByVectorLTR<Any>().apply {
        enqueue(10)
        enqueue(11)
        enqueue(12)
        enqueue(13)


        updateFirst(133)
        updateIndex(2,111)
        updateLast(100)

        dequeue()

        // 4 | 133 | 133,12,111,null | 111
        println("${getSize()} || ${getFront()} | ${getAll().contentToString()} | ${getRear()} | ")
    }
}
