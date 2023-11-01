
//class Solution {
//
//    private fun minCost(size:Int, cost: IntArray, result:IntArray):Int {
//        if(size == 0) return cost[0]
//        if (size == 1) return Math.min(cost[0],cost[1])
//        if(result[size] != -1) return result[size]
//
//        val oneStepCost = minCost(size-1, cost, result)+ cost[size]
//        val twoStepCost = minCost(size-2, cost, result)+ cost[size]
//        println("$oneStepCost | $twoStepCost")
//        val sum = oneStepCost + twoStepCost
//        result[size] = Math.min(cost[size], sum)
//        return result[size]
//    }
//    fun minCostClimbingStairs(cost: IntArray): Int {
//        val result = IntArray(cost.size){ -1 }
//        val res = minCost(cost.size-1,cost, result)
//        println(result.toTypedArray().contentToString())
//        return res
//    }
//}


//class Solution {
//
//    fun minCostClimbingStairs(cost: IntArray): Int {
//        val result = IntArray(cost.size)
//        result[0] = cost[0]
//        result[1] = Math.min(cost[0], cost[1])
//        for (index in result.size-1 downTo 0 ) {
//            result[index] = cost[index] + Math.min(result[index+1], result[index+2])
//        }
//        println(result.toTypedArray().contentToString())
//        return result.last()
//    }
//}


//class Solution {
//
//    private fun minCost(index:Int, cost: IntArray, result:IntArray): Int {
//        println("[$index] = ${result.toTypedArray().contentToString()}")
//        if(index == 0) return cost[0]
//        if (index == 1) return Math.min(cost[0], cost[1])
//        if(result[index] != -1) return result[index]
//
////        result[index] = Math.min(minCost(index-1, cost, result), minCost(index-2, cost, result))
//        val doTake = minCost(index-2, cost, result) + cost[index]
//        val doNotTake = minCost(index-1, cost, result)
//        result[index] = Math.min(doTake, doNotTake)
//
//        return result[index]
//    }
//    fun minCostClimbingStairs(cost: IntArray): Int {
//        return minCost(cost.size-1,cost,IntArray(cost.size) { -1 })
//    }
//}

