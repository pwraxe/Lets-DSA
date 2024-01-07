fun main() {
    var rows = 5

    for (row in 1 .. rows) {
        repeat(rows-row) {
            print("  ")
        }
        repeat(row) {
            print(" *")
        }
        println()
    }
}

         *
       * *
     * * *
   * * * *
 * * * * *
