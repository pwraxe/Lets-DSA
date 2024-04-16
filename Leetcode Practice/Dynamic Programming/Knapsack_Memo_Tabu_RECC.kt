//THIS IS ALSO USE TO UNDERSTAND PURPOSE,
//HOW MEMORISATION GET CONVERTED INTO TABULATION
//
//VVVVVVVVVVVVVVVVVVVVVVVVV...VVVVV   IMP
import kotlin.math.max

class ZeroOneKnapsack {

    private lateinit var result:Array<IntArray>
    private fun fillKnapsack(weight: IntArray, profit: IntArray, index: Int, capacity: Int): Int {
        if (index == 0 || capacity == 0) {
            return 0
        }
        if (result[index][capacity] != -1) return result[index][capacity]
        result[index][capacity] = if (weight[index-1] <= capacity) {
            val take = fillKnapsack(weight, profit, index-1, capacity-weight[index-1]) + profit[index-1]
            val not = fillKnapsack(weight, profit, index-1, capacity)
            max(take, not)
        } else {
            fillKnapsack(weight, profit, index-1, capacity)
        }
        return result[index][capacity]
    }
    fun fillBag(weight: IntArray, profit: IntArray, capaCT: Int): Int {

        //Memorization
        result = Array(weight.size+1) { row ->
            IntArray(capaCT+1) {
                if (it == 0 || row == 0) 0 else -1
            }
        }
        //return fillKnapsack(weight, profit, weight.size, capacity)


        //Tabulation

        for (index in 1 .. weight.size) {
            for (capacity in 1 .. capaCT) {
                val take = if (capacity-weight[index-1] >= 0) {
                    result[index-1][capacity-weight[index-1]] + profit[index-1]
                } else 0

                val not = result[index-1][capacity]
                result[index][capacity] = Math.max(take,not)
            }
        }
        return result[weight.size][capaCT]


    }
}

fun main() {
    ZeroOneKnapsack().apply {

        val weight1 = intArrayOf(3,4,6,5)
        val profit1 = intArrayOf(2,3,1,4)
        println(fillBag(weight1,profit1,8))

        println("========")

        val weight2 = intArrayOf(2,3,4,5)
        val profit2 = intArrayOf(1,2,5,6)
        println(fillBag(weight2,profit2,8))
        println("========")
    }
}
