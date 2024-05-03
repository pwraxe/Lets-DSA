class MatrixChainMultiplication {

    private fun mcm(i:Int, j:Int, list: IntArray, dp:Array<IntArray>) : Int {
        if (i == j) return 0
        if (dp[i][j] != -1) return dp[i][j]

        var result = Int.MAX_VALUE
        for (k in i ..< j) {
            val cost1 = mcm(i, k, list, dp)
            val cost2 = mcm(k+1, j, list, dp)
            val cost3 = list[i-1] * list[k] * list[j]  // a x b x d
            val finalCost = cost1 + cost2 + cost3
            result = Math.min(result, finalCost)
        }
        dp[i][j] = result
        return dp[i][j]
    }
    fun matrixChainMult(list: IntArray) {
        val dp = Array(list.size) { IntArray(list.size) { -1 } }
        val res = mcm(1,list.size-1, list,dp)
        dp.forEach {
            println(it.toTypedArray().contentToString())
        }
        println("res : $res")
    }
}

fun main() {
    MatrixChainMultiplication().apply {
        matrixChainMult(intArrayOf(1,2,3,4,3))
        matrixChainMult(intArrayOf(1,2,3,4,5))
        matrixChainMult(intArrayOf(4,2,5,1,9))
    }
}




[-1, -1, -1, -1, -1]
[-1, -1, 6, 18, 30]
[-1, -1, -1, 24, 48]
[-1, -1, -1, -1, 36]
[-1, -1, -1, -1, -1]
res : 30
[-1, -1, -1, -1, -1]
[-1, -1, 6, 18, 38]
[-1, -1, -1, 24, 64]
[-1, -1, -1, -1, 60]
[-1, -1, -1, -1, -1]
res : 38
[-1, -1, -1, -1, -1]
[-1, -1, 40, 18, 54]
[-1, -1, -1, 10, 28]
[-1, -1, -1, -1, 45]
[-1, -1, -1, -1, -1]
res : 54
