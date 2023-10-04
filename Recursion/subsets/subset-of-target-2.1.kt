fun main() {
    val list = mutableSetOf<List<Int>>()
    val nums = intArrayOf(1,2,3,4,5,6,7,8,9)
    nums.shuffle()
    getUniqueSubList(nums,0,16, mutableListOf(),list)

    list.forEach {
        println("${it.sum()} | ${it.toTypedArray().contentToString()}")
    }
}

fun getUniqueSubList(nums: IntArray, index: Int, target: Int, subList: MutableList<Int>, list: MutableSet<List<Int>>) {
    if(index == nums.size) {
        return
    }

    if(subList.sum() == target) {
        list.add(subList.toList())
    }

    //Take Element
    subList.add(nums[index])
    getUniqueSubList(nums, index+1, target, subList, list)

    //!Take Element
    subList.removeLast()
    getUniqueSubList(nums, index+1, target, subList, list)
}

//OUTPUT
16 | [3, 6, 7]
16 | [3, 6, 2, 5]
16 | [3, 7, 2, 4]
16 | [3, 8, 5]
16 | [3, 9, 4]
16 | [6, 8, 2]
16 | [7, 5, 4]
16 | [7, 9]
16 | [2, 5, 9]
