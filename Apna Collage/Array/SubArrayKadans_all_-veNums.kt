class Solution {
    fun maxKadansSum(arr:IntArray) {
        var sum = arr.first()
        var maxSum = sum
        for(i in 1 ..< arr.size) {
            if (sum < 0) { sum = 0 }
            sum += arr[i]
            maxSum = Math.max(sum, maxSum)
        }
        println("Max Sum: $maxSum")
    }
}
fun main() {
    Solution().apply {
        maxKadansSum(intArrayOf(-1,-2,-3,-4))
        maxKadansSum(intArrayOf(-5,-4,-7,-9))
    }
}

