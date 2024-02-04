class Solution {
    fun tailingProblem(n: Int): Int {
        if(n <= 1) return 1
        return tailingProblem(n-1) + tailingProblem(n-2)
    }
    fun friendsPair(n:Int): Int {
        if (n == 1 || n == 2) return n
        return friendsPair(n-1) + (n-1) * friendsPair(n-2)
    }
    fun printBinString(size: Int, lastBit: String, result: String) {
        if (size == 0) {
            println(result)
            return
        }
        if (lastBit == "0") {
            printBinString(size-1,  "1", result + "1")
        }
        printBinString(size-1, "0", result+"0")
    }
}
fun main() {
    Solution().apply {
        println(tailingProblem(4))
        println(friendsPair(3))
        printBinString(3,"0","")
    }

}


5
4
101
100
010
001
000
