interface Stacks<T> {
    fun push(element: T)
    fun pop() : T
    fun peek() : T?
    fun stackSize() : Int
    fun isEmpty() : Boolean
}

class LetsStack<T> : Stacks<T> {

    private var stackData = arrayListOf<T>()

    override fun toString() = buildString {
        println("----TOP----")
        for (i in stackData.size-1 downTo 0) {
            println(stackData[i])
        }
        println("-----------")
    }

    companion object {
        fun <T> createStack(vararg list : T) : Stacks<T> {
            val stack = LetsStack<T>()
            for (item in list) {
                stack.push(item)
            }
            return stack
        }
    }

    override fun push(element: T) {
        stackData.add(element)
    }

    override fun pop(): T {
        return if(stackData.size > 0) {
            stackData.removeAt(stackData.size-1)
        } else "No Element in Stack" as T
    }

    override fun peek() : T? {
        return if(stackData.size > 0) stackData[stackData.size-1] else toString() as T
    }

    override fun stackSize(): Int = stackData.size

    override fun isEmpty(): Boolean = stackData.size == 0
}

fun main() {
    LetsStack<Int>().apply {
        push(10)
        push(11)
        push(12)
        push(13)

        println("size : ${stackSize()} | Peek : ${peek()} | is-MT : ${isEmpty()}")

        println(this.toString())
    }
    LetsStack.createStack(listOf("A","B","C","D","E","F","G","H")).apply {
        println(this)
        println("size : ${stackSize()} | Peek : ${peek()} | is-MT : ${isEmpty()}")
    }
}
