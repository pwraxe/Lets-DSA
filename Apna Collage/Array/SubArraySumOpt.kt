class Solution {
    fun subArraySum(n:IntArray) {
        for (i in 0 until n.size) {
            val list = mutableListOf<Int>()
            var sum = 0
            for (j in 0 until i+1) {
                list.add(n[j])
                sum += n[j]
            }
            println("${list.toTypedArray().contentToString()} | $sum")
        }
    }

    fun subArraySumOpt(n:IntArray) {
        val sum = IntArray(n.size)
        sum[0] = n[0]
        for (i in 1 until n.size) {
            sum[i] = sum[i-1] + n[i]
        }
        println(sum.toTypedArray().contentToString())
        println("Max Sum: ${sum[sum.lastIndex]} | ${sum.last()}")
    }
}
fun main() {
    Solution().apply {
        subArraySum(intArrayOf(2,4,6,8,10))
        subArraySumOpt(intArrayOf(4,9,-5,10,-25))
    }
}
//========================================================

[2] | 2
[2, 4] | 6
[2, 4, 6] | 12
[2, 4, 6, 8] | 20
[2, 4, 6, 8, 10] | 30
[4, 13, 8, 18, -7]

Max Sum: -7 | -7
