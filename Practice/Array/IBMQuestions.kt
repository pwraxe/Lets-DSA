//Write a Program to Change Decimal Number to Binary?
fun main() {
    val num = 54
    println(num.toBinary(StringBuilder()))
}
fun Int.toBinary(binary: StringBuilder): String {
    if(this == 0) return binary.reverse().toString()
    return (this/2).toBinary(binary.append(this%2))
}

//===============================================================

//Write a Program to generate the Fibonacci Triangle.
fun main() {
    var first = 0
    var second = 1
    var third = 1

    var till = 5
    (1..till).forEach {
        repeat(it) {
            third = first + second
            print("$third ")
            first = second
            second = third
        }
        println()
    }
}

//===============================================================

//Given a number x, determine whether the given number is Armstrong Number or not.
fun main() {
    val num = 153
    var input = num
    var result = 0
    val power = num.toString().length
    while (input != 0) {
        result += Math.pow(input % 10.0,power.toDouble()).toInt()
        input /= 10
    }

    println("$num == $result = ${num == result}")
}

//===============================================================
//Given a number n, print n-th Fibonacci Number.
fun main() {
    val fibbTill = 10
    var first = 0
    var second = 1
    var third = 1
    print("$first $second ")
    for (index in 2 until fibbTill) {
        third = first + second
        print("$third ")
        first = second
        second = third
    }
}
//===============================================================
//Write a program to find HCF of two numbers without using recursion.
fun main() {
    var m = 150
    var n = 120

    while (m != n) {
        if(m > n) m -= n else n -= m
    }
    println("$m | $n")
}
//===============================================================
//Program to check if a given year is leap year
fun main() {
    val year = 2000
    val isLeap = year % 400 == 0 || year % 4 == 0
    println(isLeap)
}
//===============================================================
//Write a program to reverse digits of a number
fun main() {
    val digit = 1234
    var input = digit
    var reverse = ""
    while (input != 0) {
        reverse += input % 10
        input /= 10
    }
    println("$digit == $reverse")
}
//===============================================================
//Program to Check if a Given String is Palindrome
fun main() {
    println("abcba".isPalindrome())
}

fun String.isPalindrome(start: Int = 0, end: Int = this.length-1): Boolean {
    if(start > end) return true
    if(this[start] != this[end]) return false
    return isPalindrome(start+1, end-1)
}
//===============================================================
//Print all prime numbers less than or equal to N
fun main() {
    val primeTill = 100
    (0..primeTill).forEach {
        if(it.isPrime()) {
            print("$it ")
        }
    }
}

fun Int.isPrime(): Boolean {
    var count = 0
    (1..this).forEach {
        if(this % it == 0) count++
    }
    return count == 2
}
//===============================================================
//Program for Sum of the digits of a given number
fun main() {
    var digit = 1234
    var sum = 0
    while (digit != 0) {
        sum += digit % 10
        digit /= 10
    }
    println(sum)
}
==============By Recursively
fun main() {
    println(1234.takeSum(0))
}
fun Int.takeSum(sum: Int): Int {
    if(this == 0) return sum
    return (this/10).takeSum(sum+this%10)
}
//===============================================================
//Given an integer, write a function that returns true
// if the given number is palindrome, else false.
// For example, 12321 is a palindrome, but 1451 is not a palindrome.

fun main() {
    val num = 12321
    var input = num
    var revNum = ""
    while (input != 0) {
        revNum += input % 10
        input /= 10
    }
    println(num == revNum.toInt())
}

//===============================================================
//Reverse a string
fun main() {
    val str = "AQuickBrownFoxJumpOverLazyDog"
    var input = StringBuilder(str)

    var start = 0
    var end = str.length-1
    while (start < end) {
        input[start] = input[end].also { input[end] = input[start] }
        start++
        end--
    }

    println("$str == $input")
}
//===============================================================
// Find the Largest Number Among Three Numbers
fun main() {
    val n1 = 100
    val n2 = 200
    val n3 = 199
    var max = Math.max(n1,n2)
    max = Math.max(max,n3)
    println(max)
}
//===============================================================
