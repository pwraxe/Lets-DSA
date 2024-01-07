// Iterative
fun main() {
    val rows = 7
    for (row in rows downTo 0) {
        for (col in 0 until row) {
            print("* ")
        }
        println()
    }
}
/*

* * * * * * *
* * * * * *
* * * * *
* * * *
* * *
* *
*

* */
