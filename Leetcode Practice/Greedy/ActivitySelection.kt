//Conceptual
class Solution {
    fun activitySelection(start: IntArray, end:IntArray):Int {
        val pairs = mutableListOf<Pair<Int, Int>>()
        start.indices.forEach {
            pairs.add(Pair(start[it], end[it]))
        }
        pairs.sortBy { it.second }
        var count = 1
        var prev = pairs.first()
        for (index in 1 until pairs.size) {
            val current = pairs[index]
            if (prev.second <= current.first) {
                count++
                prev = current
            }
        }
        return count
    }
}

fun main() {
    Solution().apply {
        println(activitySelection(intArrayOf(10,12,20), intArrayOf(20,25,30)))
        println(activitySelection(intArrayOf(2,9,12,18), intArrayOf(8,18,16,30)))
    }
}
