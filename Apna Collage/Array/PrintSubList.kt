class Solution {
    fun printSubArray(n:IntArray) {
        for (s in 1 .. n.size) {

            for (i in 0 .. n.size-s) {
                val list = mutableListOf<Int>()
                for (j in i until i + s) {
                    list.add(n[j])
                }
                println(list.toTypedArray().contentToString())
                list.clear()
            }
            println()
        }

    }
}
fun main() {
    Solution().apply {
        printSubArray(intArrayOf(2,4,6,8,10))
    }
}


//===================output=======================

[2]
[4]
[6]
[8]
[10]

[2, 4]
[4, 6]
[6, 8]
[8, 10]

[2, 4, 6]
[4, 6, 8]
[6, 8, 10]

[2, 4, 6, 8]
[4, 6, 8, 10]

[2, 4, 6, 8, 10]
