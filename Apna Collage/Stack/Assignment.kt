import java.lang.StringBuilder
import java.util.Stack

data class Node(val data:Char, var next: Node? = null)
class StackAssignment {
    private var headNode: Node? = null
    private var tailNode: Node? = null
    private var size: Int = 0

    fun addLast(item :Char) {
        val node = Node(item)
        size++
        if (headNode == null) {
            headNode = node
            tailNode = node
            return
        }
        tailNode?.next = node
        tailNode = node
    }
    fun read() {
        var node = headNode
        while (node != null) {
            print("-> ${node.data} ")
            node = node.next
        }
        println()
    }
    fun isPalindrome(): Boolean {
        var slow = headNode
        var fast = headNode?.next
        while (fast?.next != null) {
            slow = slow?.next
            fast = fast.next?.next
        }
        var left = headNode
        var right = slow?.next
        slow?.next = null

        //Reverse Next Half
        var prev: Node? = null
        var current = right
        while (current != null) {
            val next = current.next
            current.next = prev
            prev = current
            current = next
        }
        right = prev

        while (right != null) {
            if (left?.data != right.data) {
                return false
            }
            left = left.next
            right = right.next
        }
        return true
    }

    fun decodeString(s: String): String {
        val stack = Stack<String>()
        for (char in s) {
            if (char != ']') {
                stack.push(char.toString())
            } else {
                var subString = ""
                var nums = ""

                //Get substring first
                while (stack.isNotEmpty() && stack.peek() != "[") {
                    subString = "${stack.pop()}${subString}"
                }
                stack.pop()

                //get number then
                while (stack.isNotEmpty() && stack.peek() in "0" .. "9") {
                    nums = "${stack.pop()}${nums}"
                }

                val newSubstring = StringBuilder()
                repeat(nums.toInt()) {
                    newSubstring.append(subString)
                }
                stack.push(newSubstring.toString())
            }
        }
        return stack.joinToString("")
    }
}

fun main() {
    StackAssignment().apply {
        addLast('A')
        addLast('B')
        addLast('C')
        addLast('B')
        addLast('A')

        read()
        println(isPalindrome())
        //========================Q2

        println(decodeString("2[cv]"))
        println(decodeString("3[a]2[cb]"))
        println(decodeString("3[b2[v]]"))
    }
}


-> A -> B -> C -> B -> A 
true
cvcv
aaacbcb
bvvbvvbvv
