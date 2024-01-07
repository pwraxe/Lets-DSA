fun main() {
    val rows = 5
    var space = 5
    for (row in rows downTo 1) {
        repeat(space--) {
            print("  ")
        }
        if (row == 1 || row == rows) {
            repeat(rows) {
                print("* ")
            }
        } else {
            print("* ")
            repeat(rows-2) {
                print("  ")
            }
            print("* ")
        }

        println()
    }
}

/**

          * * * * * 
        *       * 
      *       * 
    *       * 
  * * * * * 

**/
