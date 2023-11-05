fun combinations(nums: IntArray): List<List<Int>> {
    val result = mutableListOf<List<Int>>()

    //Add empty list
    result.add(emptyList())

    //Method 1 ===================================================
    nums.forEach {num ->
        val currentList: ArrayList<List<Int>> = ArrayList(result)
        currentList.forEach { list ->
            val combination: ArrayList<Int> = ArrayList(list)
            combination.add(num)
            result.add(combination)
        }
    }

    //Method 2 ===================================================
    nums.forEach {num ->
        ArrayList(result).forEach { list ->
            result.add(ArrayList(list).also { it.add(num) })
        }
    }


    //Choose from either Method 1   OR  Method 2 Both works same

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
