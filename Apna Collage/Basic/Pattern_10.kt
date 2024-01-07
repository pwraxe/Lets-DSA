fun main() {
    val rows = 5
    for (row in rows downTo 1) {
        repeat(row) {
            print("  ")
        }
        repeat(rows) {
            print("* ")
        }
        println()
    }
}



/**
          * * * * * 
        * * * * * 
      * * * * * 
    * * * * * 
  * * * * * 
  
**/
