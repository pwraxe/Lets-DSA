class Solution {
    fun getPrimeFactors(n: Int) {
        var num = n
        if(num <= 1) return

        for(i in 2 .. Math.sqrt(num.toDouble()).toInt()) {
            while(num % i == 0) {
                print("$i ")
                num /= i
            }
        }
        if(num > 0) println("$num ")
    }
}

fun main() {
    Solution().apply {
        getPrimeFactors(737) // 11 67
        getPrimeFactors(400) // 2 2 2 2 5 5 1
    }
}

