class Solution {


    //TC: O(sqrt(n) * log n)
    fun getPrimeFactors1(n: Int) {
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

    //O(sqrt(n))
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
        getPrimeFactors1(737) // 11 67
        getPrimeFactors3(400) // 2 2 2 2 5 5 1
        getPrimeFactors3(1092) // 2 2 2 2 5 5 1
    }
}

