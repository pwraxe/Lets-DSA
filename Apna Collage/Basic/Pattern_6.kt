fun main() {
    var rows = 5

    for (row in rows downTo 1) {
        for (col in 1 .. row) {
            print("$col ")
        }
        println()
    }
}

1 2 3 4 5 
1 2 3 4 
1 2 3 
1 2 
1
