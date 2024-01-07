fun main() {
    val rows = 7
    for (row in 1 .. rows step 2) {
        val star = row
        val space = (rows - star) / 2
        repeat(space) {
            print("  ")
        }
        var isStar = true
        repeat(star) {
            print("${if (isStar) "*" else " "} ")
            isStar = !isStar
        }
        repeat(space) {
            print("  ")
        }
        println()
    }
}

      *       
    *   *     
  *   *   *   
*   *   *   * 
  
