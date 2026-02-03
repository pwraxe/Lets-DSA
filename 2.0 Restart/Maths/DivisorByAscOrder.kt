class Solution {

    fun printDivisors(n:Int) {
        var index = 1
        while (index <= Math.sqrt(n*1.0).toInt()) {
            if (n%index == 0) {
                print("$index ")
            }
            index++
        }

        while (index >= 1) {
            if (n % index == 0) {
                print("${n/index} ")
            }
        }
    }
}

fun main() {
    Solution().apply {
        printDivisors(48)  //1 2 3 4 6 
    }
}
