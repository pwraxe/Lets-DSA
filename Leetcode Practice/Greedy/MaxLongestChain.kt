class Solution {
    fun longestChainOfPair(pairs:MutableList<Pair<Int,Int>>): Int {
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
        val pair = mutableListOf<Pair<Int,Int>>().also {
            it.add(Pair(5,24))
            it.add(Pair(39,60))
            it.add(Pair(39,60))
            it.add(Pair(5,28))
            it.add(Pair(27,40))
            it.add(Pair(50,90))
        }
        val count = longestChainOfPair(pair)
        println(count) //3
    }
}
