//QUEUE Direction From : RTL (Enqueue from right, Dequeue from left)
class NoElementInListException(message: String) : RuntimeException(message)

class QueueByArray<T> {

    private var minSize : Int = 6
    private var elements : Array<Any?>
    private var size: Int = 0

    constructor() {
        elements = arrayOfNulls<Any?>(minSize)
    }

    constructor(capacity : Int ) {
        elements = when {
            capacity == 0 -> arrayOfNulls<Any?>(minSize)
            capacity > 0 -> arrayOfNulls<Any?>(capacity)
            else -> throw IllegalArgumentException("Invalid Capacity : $capacity")
        }
    }

    fun enqueue(item : T) {

        if(size == elements.size) {
            val newArray = QueueByArray<T>(size + (size shr 1))
            System.arraycopy(elements,0,newArray.elements,0,size)
            elements = newArray.elements
        }
        elements[size] = item
        ++size
    }

    fun dequeue() {
        if(size <= elements.size) {
            System.arraycopy(elements,1,elements,0,size-1)
            elements[size-1] = null
            --size
        } else {
            throw NoElementInListException("Empty List")
        }
    }

    fun getList() : Array<Any?> = elements

    fun frontElement() : Any? = if(elements.isNotEmpty())
        elements[0] else throw NoElementInListException("No Element in list")

    fun rearElement() : Any? = if(elements.isNotEmpty()) elements[size-1]
        else throw NoElementInListException("No Element in list")

}


fun main() {

    QueueByArray<Any>().apply {

        enqueue(10)
        enqueue(20)
        enqueue(30)
        enqueue(40)
        enqueue(50)
        enqueue(60)
        enqueue(70)
        enqueue(80)
        enqueue(90)
        println("List : ${getList().contentToString()}")
        println("FRONT : ${frontElement()}  |  REAR : ${rearElement()}")

        dequeue()
        dequeue()
        dequeue()
        dequeue()

        println("List : ${getList().contentToString()}")
        println("FRONT : ${frontElement()}  |  REAR : ${rearElement()}")
    }
}
