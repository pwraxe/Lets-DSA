class MatrixChainMultiplication {
    
    fun matrixChainMultTabu(list: IntArray) {
        val dp = Array(list.size) { IntArray (list.size) }
        for (length in 2 ..< list.size) {
            for (i in 1 .. list.size-length) {
                val j = i+length-1
                dp[i][j] = Int.MAX_VALUE
                for (k in i ..< j) {
                    val cost1 = dp[i][k]
                    val cost2 = dp[k+1][j]
                    val cost3 = list[i-1] * list[k] * list[j]
                    val final = cost1 + cost2 + cost3
                    dp[i][j] = Math.min(dp[i][j], final)
                }
            }
        }

        val result = dp[1][list.size-1]
        dp.forEach {
            println(it.toTypedArray().contentToString())
        }
        println("Result: $result")
    }
}

fun main() {
    MatrixChainMultiplication().apply {

        matrixChainMultTabu(intArrayOf(1,2,3,4,3))
        matrixChainMultTabu(intArrayOf(1,2,3,4,5))
        matrixChainMultTabu(intArrayOf(4,2,5,1,9))
    
    }
}





[0, 0, 0, 0, 0]
[0, 0, 6, 18, 30]
[0, 0, 0, 24, 48]
[0, 0, 0, 0, 36]
[0, 0, 0, 0, 0]
Result: 30
[0, 0, 0, 0, 0]
[0, 0, 6, 18, 38]
[0, 0, 0, 24, 64]
[0, 0, 0, 0, 60]
[0, 0, 0, 0, 0]
Result: 38
[0, 0, 0, 0, 0]
[0, 0, 40, 18, 54]
[0, 0, 0, 10, 28]
[0, 0, 0, 0, 45]
[0, 0, 0, 0, 0]
Result: 54
