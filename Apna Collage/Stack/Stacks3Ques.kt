import java.util.Stack
class Solution {

    fun isValidParenthesis(paren: String): Boolean {
        val stack = Stack<Char>()

        for (par in paren) {
            if (par == '(' || par == '[' || par == '{') {
                stack.push(par)
            } else {
                if (stack.isEmpty()) return false
                val top = stack.peek()
                if (
                    (top == '(' && par == ')') ||
                    (top == '[' && par == ']') ||
                    top == '{' && par == '}') {
                    stack.pop()
                } else return false
            }
        }
        return true
    }

    fun duplicateString(s: String): Boolean {
        val stack = Stack<Char>()
        for (char in s) {
            if (char == ')') {
                var count = 0
                while (stack.isNotEmpty() && stack.pop() != '(') {
                    count++
                }

                if (count < 1) return true
            } else {
                stack.push(char)
            }
        }

        return false
    }

    fun maxHistogramArea(bars: IntArray): Int {
        val nextSmallerLeft = IntArray(bars.size) { -1 }
        val nextSmallerRight = IntArray(bars.size) { bars.size }
        val stack = Stack<Int>()

        for (i in bars.indices) {
            while (stack.isNotEmpty() && bars[stack.peek()] >= bars[i]) stack.pop()
            if (stack.isNotEmpty()) nextSmallerLeft[i] = stack.peek()
            stack.push(i)
        }

        for (i in bars.lastIndex downTo 0) {
            while (stack.isNotEmpty() && bars[stack.peek()] >= bars[i]) stack.pop()
            if (stack.isNotEmpty()) nextSmallerRight[i] = stack.peek()
            stack.push(i)
        }

        var maxArea = 0
        for (i in bars.indices) {
            val ht = bars[i]
            val wd = nextSmallerRight[i] - nextSmallerLeft[i] - 1
            maxArea = Math.max(maxArea, ht * wd)
        }
        return maxArea
    }
}

fun main() {
    Solution().apply {
        println(isValidParenthesis("(())([])")) //T
        println(isValidParenthesis("{([]})")) //F
        println(isValidParenthesis("{{()}}")) //T

        println("===========================================")
        println(duplicateString("(a+b)"))
        println(duplicateString("((a+b))"))

        println("===========================================")
        println(maxHistogramArea(intArrayOf(2,1,5,6,2,3)))
        println(maxHistogramArea(intArrayOf(2,4)))
    }
}


true
false
true
===========================================
false
true
===========================================
10
4

