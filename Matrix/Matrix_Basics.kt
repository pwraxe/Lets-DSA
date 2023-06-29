import kotlin.random.Random

fun main() {
    val rows = 3
    val col = 3
    val depth = 3

    //Matrix Declaration with default values
    val oneD = Array(rows) { 0 }
    val twoD = Array(rows) { Array(col) { 0 } }
    val threeD = Array(rows) { Array(col) { Array(depth) { 0 } } }
    
    //Insert values in matrix
    //O(n*n)
    for(i in 0 until rows) {
        for(j in 0 until col) {
            twoD[i][j] = Random.nextInt(1,9)
        }
    }
    
    //Read values from matrix
    //O(n*n)
    for(i in 0 until rows) {
        for(j in 0 until col) {
            print("${twoD[i][j]}\t")
        }
        println()
    }
}
