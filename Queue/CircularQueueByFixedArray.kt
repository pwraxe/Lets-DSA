/**Circular Queue**/
class QueueOverflowException(message : String) : RuntimeException(message)
class QueueUnderflowException(message : String) : RuntimeException(message)


class CircularFixedQueue<T> {

    private var elements : Array<Any?>
    private var capacity : Int
    private var front : Int = -1
    private var rear : Int = -1

    constructor(capacity : Int) {
        if(capacity > 0) {
            this.capacity = capacity
            elements = arrayOfNulls<Any?>(capacity)
        } else throw IllegalArgumentException("Invalid Capacity : $capacity")
    }


    fun enqueue(item : T) {

        rear = (rear+1) % capacity
        if(rear == front) throw QueueOverflowException("Queue Overflow...")
        elements[rear] = item
        if(front == -1) front = rear
    }

    fun dequeue() {
        if(isEmpty()) throw QueueUnderflowException("Empty Queue")
        elements[front] = null
        if(front == rear) {
            front = -1
            rear = -1
        } else {
            front = (front + 1) % capacity
        }
    }


    fun front() : T = try{ elements[front] as T }catch ( ex: Exception) { throw QueueUnderflowException("Q Under flow")}

    fun rear() : T = try { elements[rear] as T } catch (ex: Exception) { throw QueueUnderflowException("Q Under Flow")}

    fun isEmpty() = front == -1

    fun isFull() : Boolean{
//        println("Rear : $rear  | \n" +              //-1
//                "(rear+1) : ${rear+1} | \n" +       //-1 + 1 = 0
//                "Capacity : $capacity  | \n" +      //6
//                "((rear + 1) % capacity) : ${(rear + 1) % capacity} || \n" +  //0
//                "Front : $front\n\n")               //-1

        val newRear = rear + 1
        println("${newRear} % $capacity = ${newRear%capacity}")
        return (rear + 1) % capacity == front
    }

    fun getAllElements(): Array<Any?> = elements

    override fun toString(): String = elements.contentToString()
}

fun main() {

    CircularFixedQueue<Any>(6).apply {

        enqueue(11)
        enqueue(12)
        enqueue(13)
        enqueue(14)
        enqueue(15)
        enqueue(16)

        dequeue()
        dequeue()
        dequeue()

        enqueue(17)
        enqueue(18)
        enqueue(19)

        println("List : ${toString()}")
        println("Front : ${front()} | Rear : ${rear()} | ${isEmpty()} | ${isFull()}")



        //Front And Rear Works on Following Logic
//        repeat(7) {
//            val modWith = 4
//            println("$it % $modWith = ${it % modWith}")
//        }



    }
}
