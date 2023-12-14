//Print Pattern using recursion
fun main() {
    pattern(4,0)
}

fun pattern(row: Int, col: Int) {
    if (row == 0) return
    if (col < row) {
        print("* ")
        pattern(row, col+1)

    } else {
        println()
        pattern(row-1, 0)
    }
}
