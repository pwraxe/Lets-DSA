//NOTE: Code is SAME, Just Look at Output,
//For Each Output, had practice of code




//repeat-subset-of-target-3.1.kt
fun main() {
    val list = mutableListOf<List<Int>>()
    val nums = intArrayOf(1,2)
    val target = 4
    getTargetSubList(nums,0,target,0, mutableListOf(),list)
    println(list.toTypedArray().contentToString())
}

fun getTargetSubList(nums: IntArray, index :Int, target: Int, sum: Int,subList:MutableList<Int>,list: MutableList<List<Int>>) {
    if(index == nums.size) return
    if(sum > target) return
    if(sum == target) {
        list.add(subList.toList())
        return
    }

    getTargetSubList(nums, index+1, target, sum, subList, list)

    var add = sum
    add += nums[index]
    subList.add(nums[index])

    getTargetSubList(nums, index, target, add, subList, list)

    add -= nums[index]
    subList.removeLast()
}

// Input: [1,2], Target: 4
// OUTPUT
// [[2, 2], [1, 1, 2], [1, 1, 1, 1]]
//============================================================================================================================================

//Input: [1,1,1], Target: 8
/** OUTPUT
[
    [1, 1, 1, 1, 1, 1, 1, 1], //45 times
]
**/
