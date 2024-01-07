fun main() {
    var rows = 5

    for (row in rows downTo 1) {
        for (col in 1 .. row) {
            print("$col ")
        }
        println()
    }
}

//================================================

class Solution {

    fun pattern(row:Int, col:Int) {
        if (row == 0) return
        if (col <= row) {
            print("$col ")
            pattern(row, col+1)
        } else {
            println()
            pattern(row-1, 1)
        }
    }
}

fun main() {
    Solution().apply {
        pattern(5,1)
    }
}


/*******************
1 2 3 4 5 
1 2 3 4 
1 2 3 
1 2 
1
*******************/
