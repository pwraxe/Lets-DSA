fun main() {
    var isOne = true
    val rows = 5

    for (row in 1.. rows) {
        for (col in 1 .. row) {
            print("${if (isOne) 1 else 0 } ")
            isOne = !isOne
        }
        println()
    }
}

//=============================================================

class Solution {
    private val rows = 5
    private var isOne = true
    fun pattern(row:Int, col:Int) {
        if (row == rows) return
        if (col <= row) {
            print("${if (isOne) 1 else 0 } ")
            isOne = !isOne
            pattern(row, col+1)
        } else {
            println()
            pattern(row+1, 0)
        }
    }
}

fun main() {
    Solution().apply {
        pattern(0,0)
    }
}

/**
1 
0 1 
0 1 0 
1 0 1 0 
1 0 1 0 1 
**/
