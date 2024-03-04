import java.util.ArrayDeque
import java.util.Deque
import java.util.Stack

class Solution {
    fun firstNonRepeatingChar(s:String) {
        val queue = ArrayDeque<Char>()
        val freq = IntArray(26)
        for (char in s) {
            freq[char - 'a']++
            queue.offer(char)
            while (queue.isNotEmpty() && freq[queue.peek() - 'a'] > 1){
                queue.poll()
            }
            if (queue.isEmpty()) {
                print("-1 ")
            } else {
                print("${queue.peek()} ")
            }
        }
        println()
    }
    fun interleave2HalvesQueue(first:ArrayDeque<Int>) {
        val mid = first.size/2

        val second = ArrayDeque<Int>()
        repeat(mid) {
            second.offer(first.poll())
        }
        while (second.isNotEmpty()) {
            first.offer(second.poll())
            first.add(first.poll())
        }
        println(first.toTypedArray().contentToString())
    }
    fun reverseQueueByRecursion(nums: ArrayDeque<Int>): ArrayDeque<Int> {
        if (nums.isEmpty()) return nums
        val last = nums.poll()
        reverseQueueByRecursion(nums)
        nums.offer(last)
        return nums
    }
    fun reverseQueueByIteration(nums: ArrayDeque<Int>) {
        val stack = Stack<Int>()
        while (nums.isNotEmpty()) stack.push(nums.poll())
        while (stack.isNotEmpty()) nums.offer(stack.pop())
        println(nums.toTypedArray().contentToString())
    }
}

fun main() {
    Solution().apply {
        firstNonRepeatingChar("aabccxb")
        val list = ArrayDeque<Int>().also {
            for (num in 1 .. 10) it.offer(num)
        }
        interleave2HalvesQueue(list)
        val list2 = ArrayDeque<Int>().also {
            for (num in 1 .. 10) it.offer(num)
        }
        println(reverseQueueByRecursion(list2).toTypedArray().contentToString())
        reverseQueueByIteration(list2)
    }
}


a -1 b b b b x 
[1, 6, 2, 7, 3, 8, 4, 9, 5, 10]
[10, 9, 8, 7, 6, 5, 4, 3, 2, 1]
[1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
