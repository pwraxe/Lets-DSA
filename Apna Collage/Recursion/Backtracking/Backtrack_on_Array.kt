class Solution {

    private fun getList(list: IntArray, index: Int): IntArray {
        if (index == list.size) {
            return list
        }

        list[index] = index+1
        getList(list, index+1)
        list[index] = index-1

        return list
    }
    fun getUpdatedList(): IntArray {
        return getList(IntArray(5),0)
    }
}

fun main() {
    Solution().apply {
        println(getUpdatedList().toTypedArray().contentToString())
    }
}

// [-1, 0, 1, 2, 3]
