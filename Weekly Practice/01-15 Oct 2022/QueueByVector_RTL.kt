//TODO --> 11. Create Queue Using Vector (From RTL) (Insert From Right and Remove From Left)

class QueueByVector<T> {

    private var minCapacity : Int = 6
    private var elements : Array<Any?>?
    private var size : Int = 0

    constructor() {
        elements = arrayOfNulls(minCapacity)
    }

    constructor(capacity : Int) {
        if(capacity < 0) {
            throw IllegalArgumentException("Invalid Capacity Entered")
        }
        elements = arrayOfNulls(capacity)
    }

    //CREATE
    fun enqueue(item : Int) {
        if(size == elements?.size) {
            val incCapacity = size shr 1
            val newArray = QueueByVector<T>(size + incCapacity)
            System.arraycopy(elements!!,0,newArray.elements!!,0,size)
            elements = newArray.elements
        }
        elements?.set(size, item)
        size++
    }

    //READ
    fun getSize() : Int = size
    fun getFront() : Any? = if(getSize() > 0) elements?.get(0) else null
    fun getRear() : Any? = if(getSize() > 0) elements?.get(getSize()-1) else null
    fun getAll() = elements

    //UPDATE
    fun updateFirst(item: T) {
        if(size > 0) {
            elements?.set(0,item)
        } else {
            println("Cant Update First, Empty Q")
        }
    }
    fun updateLast(item: T) {
        if(size > 0) {
            elements?.set(getSize()-1,item)
        }else {
            println("Cant Update Last, Empty Q")
        }
    }
    fun updateIndex(index:Int,item: T){
        if(index > size || index < 0) throw IndexOutOfBoundsException("Invalid Index : $index")
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
            System.arraycopy(elements,1,elements,0,size)
            elements?.set(size, null)
            size--
        } else{
            println("No Element in Queue")
        }
    }

    //OTHER
    fun find(item2Find: T) : String {
        var item : String = "Not Found"
        if(size > 0) {
            for (index in 0 until getSize()) {
                if(elements?.get(index) == item2Find) {
                    item = "elements[${index}] = ${elements?.get(index)}"
                    break
                }
            }
        }
        return item
    }
}

fun main() {

    QueueByVector<Int>().apply {

        enqueue(20)
        enqueue(21)
        enqueue(22)
        enqueue(23)
        enqueue(24)
        enqueue(25)
        enqueue(26)
        
        updateFirst(200)
        updateIndex(2,222)
        updateLast(260)

        dequeue()
        dequeue()
        dequeue()
        
        println("${getSize()} || ${getFront()} | ${getAll().contentToString()} | ${getRear()} ||| ${find(260)}")
    }

}
