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

    fun prefixSum(n:IntArray, start:Int = 0, end:Int = n.size-1) {
        val prefix = IntArray(n.size)
        prefix[0] = n[0]
        for (i in 1 .. end) {
            prefix[i] = prefix[i-1] + n[i]
        }
        println(prefix.toTypedArray().contentToString())
        val sum = if (start == 0) {
            prefix[end]
        } else {
            prefix[end] - prefix[start-1]
        }
        println("SubArray Sum (start = $start, end = $end) = $sum")
    }
}
fun main() {
    Solution().apply {
//        subArraySum(intArrayOf(2,4,6,8,10))
//        subArraySumOpt(intArrayOf(4,9,-5,10,-25))

        prefixSum(intArrayOf(2,4,8,10,12))
        prefixSum(intArrayOf(2,4,8,10,12),2,4)
    }
}


//===================
[2, 6, 14, 24, 36]
SubArray Sum (start = 0, end = 4) = 36
[2, 6, 14, 24, 36]
SubArray Sum (start = 2, end = 4) = 30
