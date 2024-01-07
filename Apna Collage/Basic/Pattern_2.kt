fun main() {
    val rows = 5
    for (row in 1 .. rows) {
        for (col in 1 .. row) {
            print("$col ")
        }
        println()
    }
}

//===============================================

class Solution {
    fun pattern(num:Int, row: Int = 1, col:Int = 1) {
        if (row == num+1) return
        if (col <= row) {
            print("$col ")
            pattern(num, row, col + 1)
        } else {
            println()
            pattern(num, row + 1, 1)
        }
    }
}
fun main() {
    Solution().apply {
        pattern(5)
    }
}

/****************
1 
1 2 
1 2 3 
1 2 3 4 
1 2 3 4 5 
****************/

 
