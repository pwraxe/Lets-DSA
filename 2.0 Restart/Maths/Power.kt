class Solution {

    //Naive Solution
    fun power1(b: Int, p: Int): Int {
        if(p == 0) return 1
        if(p == 1) return b
        return b * power1(b, p-1)
    }

    //O(n*n)
    fun power2(b:Int, p: Int): Int {
        if(p == 1) return b
        val res = power2(b, p/2) * power2(b, p/2)
        return if(p%2 == 0) {
            res
        }else res * b
    }

    //TC: O(log(n)), SC: O(n)
    fun power3(b:Int, p: Int): Int {
        if(p == 1) return b
        val pow = power3(b, p/2)
        val res = pow * pow
        return if(p%2==0) res else res * b
    }
}


fun main() {
    Solution().apply {
        println(power1(2,5))
        println(power2(2,5))
        println(power3(2,5))
    }
}
