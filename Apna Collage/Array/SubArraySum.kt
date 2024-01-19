class Solution {
    fun printSubArray(n:IntArray) {
        var maxSum = 0
        for (s in 1 .. n.size) {

            for (i in 0 .. n.size-s) {
                val list = mutableListOf<Int>()
                var sum = 0
                for (j in i until i + s) {
                    list.add(n[j])
                    sum += n[j]
                }
                maxSum = Math.max(sum, maxSum)
                println(list.toTypedArray().contentToString())
                println("sum: $sum | $maxSum")
                list.clear()
            }

            println()
        }
        println("MAX SUM: $maxSum")
    }
}
fun main() {
    Solution().apply {
        printSubArray(intArrayOf(2,4,6,8,10))
    }
}
