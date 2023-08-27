sealed class Stack {
    class StackOverflowError(message: String): RuntimeException(message)
    class StackUnderflowError(message: String): RuntimeException(message)
}
class FixedGenStack {

    private val stack = IntArray(10) { 0 }
    private val size: Int
        get() = stack.size
    private var index = -1

    fun push(item: Int) {
        if (index >= size-1) throw Stack.StackOverflowError("No More Size available")
        stack[++index] = item
    }
    fun pop(): Int {
        return if(index >= 0) {
            val num = stack[index]
            stack[index] = 0
            --index
              num
        } else throw Stack.StackUnderflowError("No More Elements")
    }
    fun peek(): Int {
        return if(index >= 0) stack[index] else 0
    }
    fun read() = stack
}

fun main() {
    FixedGenStack().apply {
        push(10)
        push(20)
        push(30)
        push(40)
        push(50)
        push(60)
        push(70)

        println("${peek()} | ${read().toTypedArray().contentToString()}")

        pop()
        pop()

        println("${peek()} | ${read().toTypedArray().contentToString()}")
    }
}
