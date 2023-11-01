class Solution {
    fun minCostClimbingStairs(cost: IntArray): Int {
        val minList = IntArray(cost.size + 1)
        for (index in 2 until minList.size) {
            val oneStep = minList[index - 1] + cost[index-1]
            val twoStep = minList[index - 2] + cost[index-2]
            minList[index] = Math.min(oneStep,twoStep)
        }
        return minList[minList.size-1]
    }
}

// class Solution {
//
//     private fun minCost(index:Int, cost: IntArray, result:IntArray): Int {
//         if(index >= cost.size) return 0
//         if(result[index] != -1) return result[index]
//
//         val oneStep = cost[index] + minCost(index+1,cost, result)
//         val twoStep = cost[index] + minCost(index+2,cost, result)
//         result[index] = Math.min(oneStep, twoStep)
//         return result[index]
//     }
//
//     fun minCostClimbingStairs(cost: IntArray): Int {
//         val result = IntArray(cost.size) { -1 }
//         val cost1 = minCost(0, cost, result)
//         val cost2 = minCost(1, cost, result)
//         return Math.min(cost1, cost2)
//     }
// }

//===========================================================================================

// class Solution {

//     private fun minCost(index:Int, cost: IntArray, result:IntArray): Int {
        
//         //Cost size is base case
//         if(index >= cost.size) return 0
//         if(result[index] != -1) return result[index]
        
//         //Going towards cost length by incrementing index 
//         val oneStep = minCost(index+1,cost, result)
//         val twoStep = minCost(index+2,cost, result)
        
//         result[index] = Math.min(oneStep, twoStep) + cost[index]
//         return result[index]
//     }
//     fun minCostClimbingStairs(cost: IntArray): Int {
//         val result = IntArray(cost.size) { -1 }
//         return Math.min(minCost(0, cost, result),minCost(1,cost, result))
//     }
// }
