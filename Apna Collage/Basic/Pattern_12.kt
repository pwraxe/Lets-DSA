fun main() {
    val rows = 7
    for (row in 1 .. rows step 2) {
        val star = row
        val space = (rows - star) / 2
        repeat(space) {
            print("  ")
        }
        repeat(star) {
            print("* ")
        }
        repeat(space) {
            print("  ")
        }
        println()
    }
    
    for (row in rows downTo 1 step 2) {
        val star = row
        val space = (rows - star) / 2
        repeat(space) {
            print("  ")
        }
        repeat(star) {
            print("* ")
        }
        repeat(space) {
            print("  ")
        }
        println()
    }
}

/***
      *       
    * * *     
  * * * * *   
* * * * * * * 
* * * * * * * 
  * * * * *   
    * * *     
      *       
**/
