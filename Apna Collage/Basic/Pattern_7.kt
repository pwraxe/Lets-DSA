fun main() {
    val rows = 5
    var sum = 1
    for (row in 1 .. rows) {
        for (col in 1 .. row) {
            print("${sum++} ")
        }
        println()
    }
}


//======================================================
class Solution {
    private val rows = 5
    fun pattern(row:Int, col:Int, sum:Int) {
        if (row == rows) return
        if (col <= row) {
            print("$sum ")
            pattern(row, col+1, sum+1)
        } else {
            println()
            pattern(row+1, 0, sum)
        }
    }
}

fun main() {
    Solution().apply {
        pattern(0,0, 1)
    }
}




/***********************
1 
2 3 
4 5 6 
7 8 9 10 
11 12 13 14 15 
***********************/
