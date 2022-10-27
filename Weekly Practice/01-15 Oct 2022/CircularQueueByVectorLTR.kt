
//TODO --> 17. Circular Queue by Vector (LTR) Enqueue From Left/Front/Start AND Dequeue From Right/Rear/End

class CircularQueueByVectorLTR<T> {

    private var minCapacity : Int = 6
    private var elements : Array<Any?>
    private var size : Int = 0
    private var frontIndex : Int = -1
    private var rearIndex : Int = -1

    constructor() {
        elements = arrayOfNulls(minCapacity)
    }

    constructor(capacity : Int) {
        if(capacity < 0) throw IllegalArgumentException("Invalid Capacity : $capacity")
        elements = arrayOfNulls(capacity)
    }

    //CREATE
    //Enqueue From Left/Front/Start
    fun enqueue(item: T) {

        rearIndex = (rearIndex + 1) % minCapacity
        if(rearIndex == frontIndex) { //Full
            val newArray = CircularQueueByVectorLTR<T>(size + minCapacity)
            System.arraycopy(elements,0,newArray.elements,0,getSize())
            elements = newArray.elements
            frontIndex = 0
            rearIndex = size-1
        }
        System.arraycopy(elements,0,elements,1,getSize())
        if(frontIndex == -1) frontIndex = rearIndex
        elements[0] = item
        size++
    }

    //READ
    fun getSize()  = size
    fun getFront() : Any? = if(elements.isNotEmpty()) elements[0] else null
    fun getRear() : Any? = if(elements.isNotEmpty()) elements[getSize()-1] else null
    fun getAll() = elements

    //UPDATE
    fun updateFront(item: T) {
        if(getSize() > 0) {
            elements[0] = item
        }
    }
    fun updateRear(item: T) {
        if(getSize() > 0) {
            elements[getSize()-1] = item
        }
    }
    fun updateIndex(index:Int,item: T) {
        if(index > size || index < 0) throw IndexOutOfBoundsException("Invalid index : $index")

        when(index) {
            0 -> updateFront(item)
            getSize() -> updateRear(item)
            else -> {
                elements[index] = item
            }
        }
    }

    //DELETE
    //Dequeue From Right/Rear/End
    fun dequeue() {
        if(getSize() > 0) {
            if(frontIndex == rearIndex) {
                frontIndex = -1
                rearIndex = -1
                size = 0
            } else {
                elements[getSize()-1] = null
                size--
                rearIndex--
            }
        }
    }

    //OTHER
    fun checkForCircular(num: Int) {

        var index = -1
        repeat(num) {
            index = (index+1) % minCapacity
            println(">>--> ${elements[index]}")
        }
    }
}

fun main() {
    CircularQueueByVectorLTR<Int>().apply {

        enqueue(10)
        enqueue(9)
        enqueue(8)
        enqueue(7)
        enqueue(6)
        enqueue(5)

        checkForCircular(12)

        updateFront(55)
        updateRear(100)
        updateIndex(2,125)

        dequeue()
        dequeue()
        dequeue()

        println("${getSize()} || ${getFront()} | ${getAll().contentToString()} | ${getRear()}")
    }
}
