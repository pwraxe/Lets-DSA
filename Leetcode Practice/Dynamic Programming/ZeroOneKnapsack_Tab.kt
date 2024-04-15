//Formula by simple based on take not take concept
//Math.max([r-1][c], [r-1][c-w[r]]+profit[r])

class ZeroOneKnapsack {

    fun fillBag(weight:IntArray, profit:IntArray, capacity:Int): Int {
        val pairs = Array<IntArray>(weight.size) { IntArray(2) }
        for (i in weight.indices) {
            pairs[i][0] = weight[i]
            pairs[i][1] = profit[i]
        }

        pairs.sortBy { it.first() }

        val result = Array(weight.size+1) { IntArray(capacity+1) }

        for (row in 1 .. weight.size) {
            val currentWeight = pairs[row-1][0]
            val currentProfit = pairs[row-1][1]

            //Formula
            //Math.max([r-1][c], [r-1][c-w[r]]+profit[r])

            for (col in 1 .. capacity) {
                if (col-currentWeight >= 0) {
                    result[row][col] = Math.max(result[row-1][col], result[row-1][col-currentWeight]+currentProfit)
                } else {
                    result[row][col] = result[row-1][col]
                }
            }
        }
        result.forEach {
            println(it.toTypedArray().contentToString())
        }
        return result[result.lastIndex][result[0].lastIndex]
    }
}

fun main() {

    ZeroOneKnapsack().apply {
        println(fillBag(intArrayOf(3,4,6,5),intArrayOf(2,3,1,4),8))
        println("=======================================")

        println(fillBag(intArrayOf(2,3,4,5), intArrayOf(1,2,5,6),8))
    }
}



[0, 0, 0, 0, 0, 0, 0, 0, 0]
[0, 0, 0, 2, 2, 2, 2, 2, 2]
[0, 0, 0, 2, 3, 3, 3, 5, 5]
[0, 0, 0, 2, 3, 4, 4, 5, 6]
[0, 0, 0, 2, 3, 4, 4, 5, 6]
6
=======================================
[0, 0, 0, 0, 0, 0, 0, 0, 0]
[0, 0, 1, 1, 1, 1, 1, 1, 1]
[0, 0, 1, 2, 2, 3, 3, 3, 3]
[0, 0, 1, 2, 5, 5, 6, 7, 7]
[0, 0, 1, 2, 5, 6, 6, 7, 8]
8
