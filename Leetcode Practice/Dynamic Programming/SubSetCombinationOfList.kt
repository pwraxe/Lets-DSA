fun combinations(nums: IntArray): List<List<Int>> {
    val result = mutableListOf<List<Int>>()

    //Add empty list
    result.add(emptyList())
    
    nums.forEach {num ->
        val currentList: ArrayList<List<Int>> = ArrayList(result)
        currentList.forEach { list ->
            val combination: ArrayList<Int> = ArrayList(list)
            combination.add(num)
            result.add(combination)
        }
    }

    //remove empty list
    result.removeFirst()
    return result
}

fun main() {
    val inputArray = intArrayOf(1, 2, 3)
    val combinationsList = combinations(inputArray)
    combinationsList.sortedBy { it.size }.forEach {
        println("${it.size} | ${it.toTypedArray().contentToString()}")
    }

}
//Output
1 | [1]
1 | [2]
1 | [3]
2 | [1, 2]
2 | [1, 3]
2 | [2, 3]
3 | [1, 2, 3]
