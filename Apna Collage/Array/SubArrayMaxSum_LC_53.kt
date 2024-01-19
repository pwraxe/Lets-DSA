class Solution {

    //O(n * n * n)
    fun printSubArray(n:IntArray) {
        var maxSum = 0
        for (s in 1 .. n.size) {

            for (i in 0 .. n.size-s) {
                var sum = 0
                for (j in i until i + s) {
                    sum += n[j]
                }
                maxSum = Math.max(sum, maxSum)
            }
        }
        println("MAX SUM: $maxSum")
    }

    //O(n) 
    fun kadensSum(n:IntArray) {
        var sum = 0
        var maxSum = Int.MIN_VALUE
        for (i in n.indices) {
            sum += n[i]
            maxSum = Math.max(maxSum, sum)
            if (sum < 0) sum = 0
        }
        println("Max: $maxSum")
    }
}
fun main() {
    Solution().apply {
//        val list = intArrayOf(2,-3,5,-6,-7,8,4,-1)   //12
        val list = intArrayOf(2,-3,4,-1, -2, 1,5,-3)  //7
        printSubArray(list)
        kadensSum(list)
    }
}
