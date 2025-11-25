
internal object Solution {
    fun getFirstDigitOfFactorialNum(n:Int):Int {

        /**
         * 12! = 479001600
         *
         * totalDigits = Math.log10(1.0) + Math.log10(2.0) + Math.log10(3.0) + .. + Math.log10(12.0) ==> 8.680336964082644
         * factionPartOnly = 8.680336964082644 - 8 = 0.680336964082644
         *
         * Power : 10.0 ^ 0.680336964082644 = 4.790016000000004 ==> return toInt() > 4
         *
         * Hence, the First Digit of a factorial is: 4
         *
         * */

        var totalDigits = 0.0
        for (i in 1 .. n) {
            totalDigits += Math.log10(i*1.0)
        }

        val factionPartOnly = totalDigits - totalDigits.toInt()

        return Math.pow(10.0, factionPartOnly).toInt()
    }
    fun getTotalDigitsInFactorial(n:Int):Int {
        var sum = 0.0
        for(i in 1 .. n) {
            sum += Math.log10(i*1.0)
        }
        return sum.toInt()
    }
}

fun main() {
    println(Solution.fact(12)) 
}
