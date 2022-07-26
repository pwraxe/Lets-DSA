import java.util.*

//Add Matrix

fun main() {

    //Define Rows and column
    val rows = 3
    val column = 3

    //Declare Array
    val matrix1 = Array(rows) { IntArray(column) }
    val matrix2 = Array(rows) { IntArray(column) }
    val matrix3 = Array(rows) { IntArray(column) }

    //Define input
    val scanner = Scanner(System.`in`)
    //-----------------------------------------------------> above 6 line runs once

    //Take First Matrix Elements
    for (i in matrix1.indices) {
        for (j in matrix1.indices) {
            print("Enter matrix1[$i][$j] : ")
            matrix1[i][j] = scanner.nextInt()
        }
    }
    //--------------------------------------------------> O(n*n)
    println("\n\n")

    //Take Second Matrix Elements
    for (i in matrix2.indices) {
        for (j in matrix2.indices) {
            print("Enter matrix2[$i][$j] : ")
            matrix2[i][j] = scanner.nextInt()
        }
    }
    //--------------------------------------------------> O(n*n)
    println("\n\n")
    //Print First Matrix
    for (i in matrix1.indices) {
        for (j in matrix1.indices) {
            print("${matrix1[i][j]} \t")
        }
        println()
    }
    //--------------------------------------------------> O(n*n)
    println("\n\n")

    //Print Second Matrix
    for (i in matrix2.indices) {
        for (j in matrix2.indices) {
            print("${matrix2[i][j]} \t")
        }
        println()
    }
    //--------------------------------------------------> O(n*n)


    //Add Both Matrix1 + Matrix2
    for (i in matrix1.indices) {
        for (j in matrix2.indices) {
            matrix3[i][j] = matrix1[i][j] + matrix2[i][j]
        }
    }
    //--------------------------------------------------> O(n*n)

    println("\n\n")
    //Print Sum of Both Matrix
    for (i in matrix3.indices) {
        for (j in matrix3.indices) {
            print("${matrix3[i][j]}\t")
        }
        println()
    }
    //--------------------------------------------------> O(n*n)
}

// O(n*n) + O(n*n) + O(n*n) + O(n*n) + O(n*n) + O(n*n) + 6 = O(6*(n*n))  (Bigo of 6 into n square) ...
