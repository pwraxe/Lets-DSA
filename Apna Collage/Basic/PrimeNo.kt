class Solution {
    private fun check(n:Int, div: Int): Boolean {
        if (n == div) return true
        if (n % div == 0) return false
        return check(n,div+1)
    }
    fun Int.isPrime(): Boolean {
        return check(this,2)
    }
}
fun main() {

    Solution().apply {
        println(30.isPrime())
    }
}
