class Solution {

    fun jobSequencing(sequence: Array<IntArray>): Int {
        sequence.sortByDescending { it[1] }
        var count = 0
        var time = 0
        var jobs = ""
        for (index in 0 until sequence.size) {
            val current = sequence[index]
            if (current[0] > time) {
                count++
                time = current[0]
                jobs += "${current[2].toChar()} -> "
            }
        }
        jobs = jobs.removeSuffix(" -> ")
        println(jobs)
        return count
    }
}
fun main() {

    Solution().apply {
        val seq = arrayOf(
            intArrayOf(4, 20, 65),
            intArrayOf(1, 10, 66),
            intArrayOf(1, 40, 67),
            intArrayOf(1, 30, 68)
        )

        println(jobSequencing(seq))
    }
}


// C -> A
// 2
