//https://www.risingstars-uk.com/blog/march-2018/blog-march-2018-magic-maths-blog
class Solution {

    fun guessNum(n: Int):Int {
        if (n !in 0..10) return -1
        var num = n

        //Add 2.
        num += 2

        //Multiply by 2.
        num *= 2

        //Subtract 2.
        num -= 2

        //Divide by 2.
        num /= 2

        //Subtract your original number.
        num -= n
        return num
    }
}
fun main() {
    Solution().apply {
        println(guessNum(4))
    }
}
