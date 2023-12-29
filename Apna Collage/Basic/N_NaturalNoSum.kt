class Solution {
    fun Int.toSum(): Int {
        var sum = 0
        (1..this).forEach {
            sum += it
        }
        return sum
    }
}
fun main() {
    Solution().apply {
        println(4.toSum())
    }
}
