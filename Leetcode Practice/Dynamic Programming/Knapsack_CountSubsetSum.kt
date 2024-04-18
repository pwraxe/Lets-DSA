class Knapsack {

    private lateinit var result: Array<IntArray>
    private fun getSubsetSumCount(index: Int, nums: IntArray, target: Int): Int {
        if (index == 0 && target > 0) return 0
        if (index >= 0 && target == 0) return 1
        if (result[index][target] != 0) return result[index][target]
        result[index][target] = if (nums[index-1] <= target) {
            val take = getSubsetSumCount(index-1, nums, target-nums[index-1])
            val not = getSubsetSumCount(index-1, nums, target)
            take + not
        } else {
            getSubsetSumCount(index-1, nums, target)
        }

        return result[index][target]
    }
    fun totalSubsetsum(nums:IntArray, target:Int) : Int {

        //Memorization (Top-Down Approach)
        result = Array(nums.size+1) { IntArray(target+1) { 0 } }
        //getSubsetSumCount(nums.size,nums, target)
        //return result[nums.size][target]

        //Tabulation (Bottom-Up Approach)
        for (r in 0 .. nums.size) {
            result[r][0] = 1
        }

        for (r in 1 .. nums.size) {
            for (c in 1 .. target) {
                val take = if (c-nums[r-1] >= 0) result[r-1][c-nums[r-1]] else 0
                result[r][c] = take + (result[r-1][c])
            }
        }
        return result[nums.size][target]
    }
}

fun main() {

    Knapsack().apply {
        println(totalSubsetsum(intArrayOf(2,3,5,6,8,10),10))
    }
}

//OUTPUT
3
