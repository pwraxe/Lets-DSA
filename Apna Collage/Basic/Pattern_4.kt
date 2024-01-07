fun main() {
    val rows = 8
    val cols = 8
    for (row in 1..rows) {

        if (row == 1 || row == rows) {
            for (col in 1..cols) {
                print("* ")
            }
        } else {
            for (col in 1..cols) {
                if (col == 1 || col == cols) {
                    print("* ")
                } else print("  ")
            }
        }

        println()
    }
}
/***

* * * * * * * * 
*             * 
*             * 
*             * 
*             * 
*             * 
*             * 
* * * * * * * * 

**/
