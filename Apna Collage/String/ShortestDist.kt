class Solution {
    fun getShortestPat(path:String) {
        var x = 0
        var y = 0

        path.forEach {
            when(it) {
                'E' -> x++
                'W' -> x--
                'S' -> y--
                'N' -> y++
            }
        }
        
        val sq = (x*x) + (y*y)
        val dist = Math.sqrt(sq.toDouble())
        println("Path: ($x, $y) | Distance : $dist")
    }
}

fun main() {
    Solution().apply {
        getShortestPat("WNEENESENNN")
    }
}

// Path: (3, 4) | Distance : 5.0
