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

/***********************
1 
2 3 
4 5 6 
7 8 9 10 
11 12 13 14 15 
***********************/
