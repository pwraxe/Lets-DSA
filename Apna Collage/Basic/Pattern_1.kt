// Iterative
fun main() {
    val rows = 7
    for (row in rows downTo 0) {
        for (col in 0 until row) {
            print("* ")
        }
        println()
    }
}

//=====================================================================
//Recursive
class Solution {

    fun pattern(row: Int, col:Int = 0) {
        if (row == 0) return
        if (col < row) {
            print("* ")
            pattern(row, col+1)
        } else {
            println()
            pattern(row-1, 0)
        }
    }
}
fun main() {
    Solution().apply {
        pattern(7)
    }
}

/*

* * * * * * *
* * * * * *
* * * * *
* * * *
* * *
* *
*

* */
