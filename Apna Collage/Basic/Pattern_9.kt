fun main() {
    val rows = 8

    for (row in 1 .. rows) {
        repeat(row) {
            print("* ")
        }
        val space = rows - (2 * row)
        repeat(space) {
            print("  ")
        }
        repeat(row) {
            print("* ")
        }
        if (space == 0) break
        println()
    }
    println()

    var space = 0
    for (row in rows/2 downTo 1) {
        repeat(row) {
            print("* ")
        }
        repeat(space) {
            print("  ")
        }
        space += 2

        repeat(row) {
            print("* ")
        }
        println()
    }
}

/***

*             * 
* *         * * 
* * *     * * * 
* * * * * * * * 
* * * * * * * * 
* * *     * * * 
* *         * * 
*             * 

**/  
