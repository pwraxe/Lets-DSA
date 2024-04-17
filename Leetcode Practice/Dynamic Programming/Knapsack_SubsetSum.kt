import kotlin.math.max

class DynamicProgramming {

    private lateinit var result: Array<IntArray>
    private lateinit var weight: IntArray
    private lateinit var profit: IntArray

    private fun fillKnapsack(capacity: Int, index: Int): Int {
        if (capacity == 0 || index == 0) return 0

        result[index][capacity] = if (weight[index-1] <= capacity) {
            max(profit[index-1] + fillKnapsack(capacity-weight[index-1], index-1), fillKnapsack(capacity, index-1))
        } else {
            fillKnapsack(capacity, index-1)
        }
        return result[index][capacity]
    }
    fun fillKnapsack(weight: IntArray, profit: IntArray, capaCT:Int): Int {

        //Memorization
        result = Array(weight.size+1) { IntArray(capaCT + 1) }
        this.weight = weight
        this.profit = profit
        //return fillKnapsack(capaCT,weight.size)

        //Tabulation
        for (index in 1 .. weight.size) {
            for (capacity in 1 .. capaCT) {
                if (weight[index-1] <= capaCT) {
                    val take = if (capacity-weight[index-1] >= 0) {
                        profit[index-1] + result[index-1][capacity-weight[index-1]]
                    } else 0
                    val not = result[index-1][capacity]
                    result[index][capacity] = max(take,not)
                }
            }
        }
        return result[weight.size][capaCT]
    }

    //=============================================================================================

    private lateinit var result2: Array<BooleanArray>
    private lateinit var nums: IntArray
    private fun subsetSum(index:Int, target: Int): Boolean {
        if (index == 0 && target > 0) return false
        if (index == 0 || target == 0) return true

        if (nums[index-1] <= target) {
            val take = subsetSum(index-1, target-nums[index-1])
            val not = subsetSum(index-1,target)
            result2[index][target] = take || not
        } else {
            val not = subsetSum(index-1,target)
            result2[index][target] = not
        }
        return result2[index][target]
    }
    fun subsetSum(nums: IntArray, target:Int): Boolean {
        //Memorization
        result2 = Array(nums.size+1) { BooleanArray(target+1) }
        this.nums = nums
//        subsetSum(nums.size,target)
//        return result2[nums.size][target]

        //Tabulation
        for (r in 0 .. nums.size) {
            result2[r][0] = true
        }

        for (index in 1 .. nums.size) {
            for (sum in 1 .. target) {
                if (nums[index-1] <= target) {
                    val take = if (sum - nums[index-1] >= 0) {
                        result2[index-1][sum - nums[index-1]]
                    } else false
                    val not  = result2[index-1][sum]
                    result2[index][sum] = take || not
                } else {
                    result2[index][sum] = result2[index-1][sum]
                }
            }
        }
        return result2[nums.size][target]
    }
}

fun main() {
    DynamicProgramming().apply {
        val weight1 = intArrayOf(3,4,6,5)
        val profit1 = intArrayOf(2,3,1,4)
        println(fillKnapsack(weight1,profit1,8))

        println("========")

        val weight2 = intArrayOf(2,3,4,5)
        val profit2 = intArrayOf(1,2,5,6)
        println(fillKnapsack(weight2,profit2,8))
        println("========")

        println(subsetSum(intArrayOf(2,3,7,8,10),11))
        println(subsetSum(intArrayOf(2,3,7,8,10),14))
        println(subsetSum(intArrayOf(2,3,7,8,10),12))
    }
}



6
========
8
========
true
false
true
