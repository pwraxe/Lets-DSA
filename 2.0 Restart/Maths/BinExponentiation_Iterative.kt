class Solution {

    fun binExp(base:Long, exp:Long) {

        //1. Treat `exp` as a binary representation internally
        //2. Traverse `exp` and consider only 1 bit of a number
        //3. square base each time to get the respective power, like x = x*x
        //4. Add multiplication only when we get 1 bit

        var exponent = exp
        var res = 1L
        var multi = base

        while (exponent > 0) {
            //Getting the LSB (Last bit), is 1 or not
            if (exponent and 1L == 1L) {
                res *= multi
            }

            //This is the same as like we're doing half tree multiplication and reusing the same for the next half in recursion
            multi *= multi

            //halving the number in binary form, which takes log(n) time
            exponent = exponent shr 1
        }
        println(res)
    }
}

fun main() {
    Solution().apply {
        binExp(3L,12L)
    }
}
