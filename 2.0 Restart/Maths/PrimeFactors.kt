class Solution {


    //TC: O(sqrt(log n))
    private fun isPrime(num: Int): Boolean {
        if (num == 2 || num == 3) return true
        if (num % 2 == 0 || num % 3 == 0) return false
        for (i in 5 .. Math.sqrt(num.toDouble()).toInt() step 6) {
            if (num %i == 0 || num % (i+2) == 0) return false
        }
        return true
    }
    //TC: (n * sqrt(n) * log(n))
    fun getPrimeFactors1(n: Int) {

        for (i in 2 ..< n) {
            if (isPrime(i)) {
                var temp = i
                while (n % temp == 0) {
                    print("$i ")
                    temp *= i
                }
            }
        }
        println()
    }

    //TC: O(sqrt(n) * log n)
    fun getPrimeFactors2(n: Int) {
        var num = n
        if(num <= 1) return

        for(i in 2 .. Math.sqrt(num.toDouble()).toInt()) {
            while(num % i == 0) {
                print("$i ")
                num /= i
            }
        }
        if(num > 1) println("$num ") else println()
    }

    //O(n + n + sqrt(n)) = O(sqrt(n))
    fun getPrimeFactors3(n: Int) {
        var num = n
        if (num <= 1) return

        while (num % 2 == 0) {
            print("2 ")
            num /= 2
        }

        while (num % 3 == 0) {
            print("3 ")
            num /= 3
        }

        for (i in 5 .. Math.sqrt(num * 1.0).toInt() step 6) {

            while (num%i == 0) {
                print("$i ")
                num /= i
            }

            while (num % (i+2) == 0) {
                print("${i+2} ")
                num /= (i+2)
            }
        }
        if (num > 3) println(num) else println()
    }
}

fun main() {
    Solution().apply {
        val x = 737
        val y = 400
        val z = 1092

        getPrimeFactors1(x)
        getPrimeFactors1(y)
        getPrimeFactors1(z)

        println("=============")
        getPrimeFactors2(x)
        getPrimeFactors2(y)
        getPrimeFactors2(z)

        println("=============")
        getPrimeFactors3(x)
        getPrimeFactors3(y)
        getPrimeFactors3(z)
    }
}



11 67 
2 2 2 2 5 5 
2 2 3 7 13 
=============
11 67 
2 2 2 2 5 5 
2 2 3 7 13 
=============
11 67
2 2 2 2 5 5 
2 2 3 7 13
