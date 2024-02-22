import java.util.Stack

class Solution {
    fun stockSpan(stocks: IntArray) {
        val span = IntArray(stocks.size)
        val stack = Stack<Int>()
        span[0] = 1
        stack.push(0)

        for (index in stocks.indices) {
            val currentPrice = stocks[index]
            while (stack.isNotEmpty() && currentPrice > stocks[stack.peek()]) {
                stack.pop()
            }
            if (stack.isEmpty()) {
                span[index] = index+1
            } else {
                span[index] = index - stack.peek()
            }
            stack.push(index)
        }

        println(span.toTypedArray().contentToString())
    }
    fun nextGreaterRight(list: IntArray) {
        val result = IntArray(list.size) { -1 }
        val stack = Stack<Int>()
        for (index in list.lastIndex downTo 0) {
            while (stack.isNotEmpty() && list[stack.peek()] <= list[index]) {
                stack.pop()
            }
            if (stack.isEmpty()) {
                result[index] = -1
            } else {
                result[index] = list[stack.peek()]
            }
            stack.push(index)
        }

        println("Next Greater Right: ${result.toTypedArray().contentToString()}")
    }
    fun nextGreaterLeft(list: IntArray) {
        val result = IntArray(list.size) { -1 }
        val stack = Stack<Int>()
        for (index in list.indices) {
            while (stack.isNotEmpty() && list[stack.peek()] <= list[index]) {
                stack.pop()
            }
            if (stack.isEmpty()) {
                result[index] = -1
            } else {
                result[index] = list[stack.peek()]
            }
            stack.push(index)
        }

        println("Next Greater Left: ${result.toTypedArray().contentToString()}")
    }
    fun nextSmallerRight(list: IntArray) {
        val result = IntArray(list.size) { -1 }
        val stack = Stack<Int>()
        for (index in list.lastIndex downTo 0) {
            while (stack.isNotEmpty() && list[stack.peek()] >= list[index]) {
                stack.pop()
            }
            if (stack.isEmpty()) {
                result[index] = -1
            } else {
                result[index] = list[stack.peek()]
            }
            stack.push(index)
        }

        println("Next Smaller Right: ${result.toTypedArray().contentToString()}")
    }
    fun nextSmallerLeft(list: IntArray) {
        val result = IntArray(list.size) { -1 }
        val stack = Stack<Int>()
        for (index in list.indices) {
            while (stack.isNotEmpty() && list[stack.peek()] >= list[index]) {
                stack.pop()
            }
            if (stack.isEmpty()) {
                result[index] = -1
            } else {
                result[index] = list[stack.peek()]
            }
            stack.push(index)
        }

        println("Next Smaller Left: ${result.toTypedArray().contentToString()}")
    }
}

fun main() {
    Solution().apply {
        stockSpan(intArrayOf(100,80,60,70,60,85,100))
        val list = intArrayOf(6,8,0,1,3)
        println("Input: ${list.toTypedArray().contentToString()}")
        nextGreaterRight(list)
        nextGreaterLeft(list)
        nextSmallerRight(list)
        nextSmallerLeft(list)
    }
}




[0, 1, 1, 2, 1, 5, 6]
Input: [6, 8, 0, 1, 3]
Next Greater Right: [8, -1, 1, 3, -1]
Next Greater Left: [-1, -1, 8, 8, 8]
Next Smaller Right: [0, 0, -1, -1, -1]
Next Smaller Left: [-1, 6, -1, 0, 1]
