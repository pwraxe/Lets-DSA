//subset-of-target-1.2.kt extends subset-of-target-1.1.kt
//Followup: list should be distinct sublist, remove duplicates
fun main() {
    val list = mutableListOf<List<Int>>()
    val nums = intArrayOf(1,2,3,4,5,6,7,8,9)
    nums.shuffle()
    getUniqueSubList(nums,0,16, mutableListOf(),list)

    list.sortBy { it.size }
    list.forEach {
        println("${it.sum()} | ${it.toTypedArray().contentToString()}")
    }
}

fun getUniqueSubList(nums: IntArray, index: Int, target: Int, subList: MutableList<Int>, list: MutableList<List<Int>>) {
    if(index == nums.size) {
        return
    }

    if(subList.sum() == target) {
        if(list.isNotEmpty()) {
            val hasSameSize = list.any { it.size == subList.size }
            if(!hasSameSize) {
                list.add(subList.toList())
            }
        } else list.add(subList.toList())
    }

    //Take Element
    subList.add(nums[index])
    getUniqueSubList(nums, index+1, target, subList, list)

    //!Take Element
    subList.removeLast()
    getUniqueSubList(nums, index+1, target, subList, list)

}
/**OUTPUT
16 | [9, 7]
16 | [8, 2, 6]
16 | [8, 5, 2, 1]
 **/
