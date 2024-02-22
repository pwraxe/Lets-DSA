import java.util.Stack

class MyStack {

    private val list = mutableListOf<Int>()

    fun push(item:Int) {
        list.add(item)
    }
    fun pushAtBottom(item: Int) {
        if (isEmpty()) {
            push(item)
            return
        }
        val top = pop()
        pushAtBottom(item)
        push(top)
    }
    fun pop(): Int {
        if (isEmpty()) return -1
        return list.removeLast()
    }
    fun peek():Int {
        if (isEmpty()) return -1
        return list.last()
    }
    fun read() {
        for (i in list.lastIndex downTo 0) {
            println("| ${list[i]} |")
        }
        println("-----")
    }
    fun isEmpty(): Boolean = list.isEmpty()

    fun revString(s:String): String {
        val stack = Stack<Char>()
        for (char in s) {
            stack.push(char)
        }
        val result = StringBuilder()
        while (stack.isNotEmpty()) {
            result.append(stack.pop())
        }
        return result.toString()
    }
    fun revStack(stack: MyStack) {
        if (stack.isEmpty()) return
        val top = stack.pop()
        revStack(stack)
        stack.pushAtBottom(top)
    }
}

fun main() {

    MyStack().apply {
        (1..5).forEach {
            push(it)
        }

        pushAtBottom(4)
        pushAtBottom(3)
        read()

        println(revString("Akshay"))

        println("====================================Rev Stack")
        revStack(this)
        while (!this.isEmpty()) {
            println(pop())
        }
    }

    println("===============New Stack")
    MyStack().apply {
        (4..9).forEach {
            push(it)
        }
        read()
    }

}




| 5 |
| 4 |
| 3 |
| 2 |
| 1 |
| 4 |
| 3 |
-----
yahskA
====================================Rev Stack
3
4
1
2
3
4
5
===============New Stack
| 9 |
| 8 |
| 7 |
| 6 |
| 5 |
| 4 |
-----
