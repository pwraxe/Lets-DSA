interface Stacks<T> {
    fun push(element: T)
    fun pop() : T?
    fun peek() : T?
    fun stackSize() : Int
    fun isEmpty() : Boolean
}

//Overall Time and Space Complexity : O(n)
class LetsStack<T> : Stacks<T> {

    private var stackData = arrayListOf<T>()

    //This also perform same functionality to reverse list
    override fun toString() = buildString {
        println("----TOP----")
        for (i in stackData.size-1 downTo 0) {
            println(stackData[i])
        }
        println("-----------")
    }

    //Time and Space Complexity : O(n)
    companion object {
        fun <T> createStack(vararg list : T) : Stacks<T> {
            val stack = LetsStack<T>()
            for (item in list) {
                stack.push(item)
            }
            return stack
        }
    }

    //Time and Space Complexity : O(n)
    override fun push(element: T) {
        stackData.add(element)
    }

    //Time and Space Complexity : O(n)
    override fun pop(): T? {
        return if(stackData.size > 0) {
            stackData.removeAt(stackData.size-1)
        } else null
    }

    //Time and Space Complexity : O(1)
    override fun peek() : T? {
        return if(stackData.size > 0) stackData[stackData.size-1] else toString() as T
    }

    //Time and Space Complexity : O(1)
    override fun stackSize(): Int = stackData.size

    //Time and Space Complexity : O(1)
    override fun isEmpty(): Boolean = stackData.size == 0

    //Time and Space Complexity : O(n)
    fun printInReverseOrder() {

        //Make Copy
        val stackDataCopy = LetsStack<T>()
        for (item in stackData) {
            //Push
            stackDataCopy.push(item)
        }

        println(stackDataCopy.stackData)

        //Pop to Print
        var item = stackDataCopy.pop()
        println("-=-=-=-=-=-=-=-")
        while (item != null) {
            println("$item")
            item = stackDataCopy.pop()
        }
        println("-=-=-=-=-=-=-=-")
    }
}

fun main() {
    LetsStack<Int>().apply {
        push(10)
        push(11)
        push(12)
        push(13)
        push(14)
        push(15)

        printInReverseOrder()

        println("size : ${stackSize()} | Peek : ${peek()} | is-MT : ${isEmpty()}")
        println(this.toString())
    }
}
