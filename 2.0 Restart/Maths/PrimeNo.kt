class Solution {
    
    //TC: O(num)
    fun isPrime1(num: Int): Boolean {
        for(i in 2 ..< num) {
            if(num%i == 0) return false
        }
        return true
    }

    //TC: O(sqrt(num))
    fun isPrime2(num: Int): Boolean {
        for(i in 2 .. Math.sqrt(num*1.0).toInt()) {
            if(num%i == 0) return false
        }
        return true
    }

    //O(log(sqrt(n)))
    private fun isPrime(num: Int): Boolean {
        if(num <= 1) return false
        if (num == 2 || num == 3) return true
        if (num % 2 == 0 || num % 3 == 0) return false

        for (i in 5 ..Math.sqrt(num.toDouble()).toInt() step 6) {
            if (num%i == 0 || num%(i+2) == 0) return false
        }
        return true
    }
}

fun main() {
    Solution().apply {
        
        println(isPrime1(7))  //true
        println(isPrime2(13)) //true
        println(isPrime3(29)) //true
    }
}

