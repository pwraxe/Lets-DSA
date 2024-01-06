class Solution {

    fun jobSequencing(triple: MutableList<Triple<Int,Int, Char>>): Int {
        triple.sortByDescending { it.second }
        var count = 1
        var time = triple.first().first
        var seq = "${triple.first().third} "
        for (index in 1 until triple.size) {
            val current = triple[index]
            if (current.first > time) {
                count++
                seq += "${current.third} "
                time = current.first
            }
        }
        println(seq)
        return count
    }
}
fun main() {

    Solution().apply {
        val triple = mutableListOf<Triple<Int,Int,Char>>().also {
            it.add(Triple(4,20,'A'))
            it.add(Triple(1,10,'B'))
            it.add(Triple(1,40,'C'))
            it.add(Triple(1,30,'D'))
        }
        println(jobSequencing(triple))
    }
}
