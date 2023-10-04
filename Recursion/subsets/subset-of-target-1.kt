fun main() {
    val nums = intArrayOf(4,8,7,3,1,5,9,7,5,2)
    val list = mutableListOf<List<Int>>()
    getSumNums(nums,0,15, mutableListOf(),list)

    list.forEach {
        println("${it.sum()} | ${it.toTypedArray().contentToString()}")
    }
}

fun getSumNums(nums: IntArray, index: Int, target: Int, subList: MutableList<Int>, list: MutableList<List<Int>>) : MutableList<List<Int>> {
    if(index == nums.size) {
        return list
    }

    if(subList.sum() == target) {
        list.add(subList.toList())
    }

    //take item
    subList.add(nums[index])
    getSumNums(nums, index+1, target, subList, list)

    //!take item
    subList.removeLast()
    getSumNums(nums, index+1, target, subList, list)

    return list
}
