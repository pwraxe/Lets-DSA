import kotlin.math.abs

class Solution {

    fun avgOfThree(a:Int, b:Int, c:Int): Int {
        return (a + b + c) / 3
    }

    fun isEven(n:Int): Boolean {
        return n % 2 == 0
    }

    fun isPalindrome(n:Int): Boolean {
        var rev = 0
        var num = n
        while (num > 0) {
            val lastDigit = num % 10
            rev = rev * 10 + lastDigit
            num /= 10
        }
        return n == rev
    }

    fun mathFun() {
        println("=======Math fun Starts===========")
        println("Max = ${Math.max(5,8)}")
        println("Min = ${Math.min(5,8)}")
        println("Sqrt = ${Math.sqrt(16.0)}")
        println("2 pow 3 = ${Math.pow(2.0,3.0)}")
        println("Absolute = ${Math.abs(5-8)}")
        println("=======Math fun Ends==============")
    }

    fun sumOfDigit(n:Int): Int {
        var sum = 0
        var num = n
        while (num > 0) {
            sum += num % 10
            num /= 10
        }
        return sum
    }
}
fun main() {
    Solution().apply {
        println(avgOfThree(5,7,9))
        println(isEven(77))
        println(isPalindrome(121))
        mathFun()
        println(sumOfDigit(123))

    }
}

7
false
true
=======Math fun Starts===========
Max = 8
Min = 5
Sqrt = 4.0
2 pow 3 = 8.0
Absolute = 3
=======Math fun Ends==============
6
