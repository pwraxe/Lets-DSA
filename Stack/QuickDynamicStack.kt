class LetsStack<T> {

    private val elements = mutableListOf<T>()
    val size: Int
        get() = elements.size

    fun push(item: T){
        elements.add(item)
    }
    fun pop(): T? {
        return elements.removeLastOrNull()
    }
    fun peek(): T? {
        return elements.lastOrNull()
    }

    fun read() = elements
}

fun main() {
    LetsStack<Int>().apply {
        pop()
        //null | []
        println("${peek()} | ${read().toTypedArray().contentToString()}")

        push(10)
        push(20)
        push(30)
        push(40)
        push(50)
        push(60)
        push(70)

        //70 | [10, 20, 30, 40, 50, 60, 70]
        println("${peek()} | ${read().toTypedArray().contentToString()}")

        pop()
        pop()

        //50 | [10, 20, 30, 40, 50]
        println("${peek()} | ${read().toTypedArray().contentToString()}")
    }
}
