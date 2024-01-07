fun main() {
    val rows = 5
    var num = 1
    for (row in 1 .. rows) {
        val space = rows - row
        repeat(space) {
            print(" ")
        }
        repeat(row) {
            print("$num ")
        }
        num++
        println()
    }
}

/**
    1 
   2 2 
  3 3 3 
 4 4 4 4 
5 5 5 5 5 

**/
