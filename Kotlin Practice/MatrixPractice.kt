import java.util.*

//Add Matrix  by traditional Method
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


-------------------------------------------------------------------------------
 
//Add Matrix, show it consized method

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
    //-----------------------------------------------------> 6 - time

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
        println(matrix1[i].contentToString())
    }
    //--------------------------------------------------> O(n*n)
    println("\n\n")

    //Print Second Matrix
    for (i in matrix2.indices) {
        println(matrix2[i].contentToString())
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
        println(matrix3[i].contentToString())
    }
    //--------------------------------------------------> O(n*n)

}
//---------------------------------------------------------------- O(6(n*n))

import java.util.*

//Subtract Matrix

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
    //-----------------------------------------------------> 6 - time

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
        println(matrix1[i].contentToString())
    }
    //--------------------------------------------------> O(n)
    println("\n\n")

    //Print Second Matrix
    for (i in matrix2.indices) {
        println(matrix2[i].contentToString())
    }
    //--------------------------------------------------> O(n)


    //Add Both Matrix1 + Matrix2
    for (i in matrix1.indices) {
        for (j in matrix2.indices) {
            matrix3[i][j] = matrix1[i][j] - matrix2[i][j]
        }
    }
    //--------------------------------------------------> O(n*n)

    println("\n\n")
    //Print Sum of Both Matrix
    for (i in matrix3.indices) {
        println(matrix3[i].contentToString())
    }
    //--------------------------------------------------> O(n)
    //--------------> O(3n*n) + O(3n) ==> 3n(n+1)    ...
}


====================================================================================
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
    //-----------------------------------------------------> 6 - time

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
        println(matrix1[i].contentToString())
    }
    //--------------------------------------------------> O(n)
    println("\n\n")

    //Print Second Matrix
    for (i in matrix2.indices) {
        println(matrix2[i].contentToString())
    }
    //--------------------------------------------------> O(n)


    var isIdentical = true
    //Add Both Matrix1 + Matrix2
    outer@for (i in matrix1.indices) {
        for (j in matrix2.indices) {
             if(matrix1[i][j] != matrix2[i][j]) {
                 isIdentical = false
                break@outer
             }
        }
    }
    //--------------------------------------------------> O(n*n)
    println(if(isIdentical) "Yes Identical" else "No, Not Identical")
    
    // O(3n*n) + O(2n) => 3n*n + 2n => 3n(n+2) ...
}
==================================================================================
    
//Check identical, contains only 0 or 1
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
    //-----------------------------------------------------> 6 - time

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
        println(matrix1[i].contentToString())
    }
    //--------------------------------------------------> O(n)
    println("\n\n")

    //Print Second Matrix
    for (i in matrix2.indices) {
        println(matrix2[i].contentToString())
    }
    //--------------------------------------------------> O(n)


    var isIdentical = false
    //check  matrix1 is identical or not
    //Identical mean all data is either 0 or 1
    outer@for (i in matrix1.indices) {
        for (j in matrix1.indices) {
            if(matrix1[i][j] == 0 || matrix1[i][j] == 1) {
                isIdentical = true
            } else {
                isIdentical = false
                break@outer
            }
        }
    }
    //--------------------------------------------------> O(n*n) + 2
    println(if(isIdentical) "Yes Identical" else "No, Not Identical")

    // O(3n*n) + O(2n) => 3n*n + 2n => 3n(n+2)
}

    
======================================================================================================
    
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
    //-----------------------------------------------------> 6 - time

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
        println(matrix1[i].contentToString())
    }
    //--------------------------------------------------> O(n)
    println("\n\n")

    //Print Second Matrix
    for (i in matrix2.indices) {
        println(matrix2[i].contentToString())
    }
    //--------------------------------------------------> O(n)


    //Lower Triangular matrix
    outer@for (i in matrix1.indices) {
        for (j in matrix1.indices) {
            if(j > i) matrix1[i][j] = 0
        }
    }
    println("\n")
    //--------------------------------------------------> O(n*n) + 2
    for (i in matrix1.indices) {
        println(matrix1[i].contentToString())  //---------> O(n)
    }

    // O(3n*n) + O(2n) => 3n*n + 2n + n => 3n(n+1)
}
=====================================================================================================================
    
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
    //-----------------------------------------------------> 6 - time

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
        println(matrix1[i].contentToString())
    }
    //--------------------------------------------------> O(n)
    println("\n\n")

    //Print Second Matrix
    for (i in matrix2.indices) {
        println(matrix2[i].contentToString())
    }
    //--------------------------------------------------> O(n)


    //Uppar Triangular matrix
    outer@for (i in matrix1.indices) {
        for (j in matrix1.indices) {
            if(j < i) matrix1[i][j] = 0
        }
    }
    println("\n")
    //--------------------------------------------------> O(n*n) + 2
    for (i in matrix1.indices) {
        println(matrix1[i].contentToString())  //---------> O(n)
    }

    // O(3n*n) + O(2n) => 3n*n + 2n + n => 3n(n+1)
}
==================================================================================================================
    
import java.util.*
//check even and odd numbers in matrix

fun main() {

    //Define Rows and column
    val rows = 3
    val column = 3

    //Declare Array
    val matrix1 = Array(rows) { IntArray(column) }

    //Define input
    val scanner = Scanner(System.`in`)
    //-----------------------------------------------------> 6 - time

    //Take First Matrix Elements
    for (i in matrix1.indices) {
        for (j in matrix1.indices) {
            print("Enter matrix1[$i][$j] : ")
            matrix1[i][j] = scanner.nextInt()
        }
    }
    //--------------------------------------------------> O(n*n)
    println("\n\n")
    //Print First Matrix
    for (i in matrix1.indices) {
        println(matrix1[i].contentToString())
    }
    //--------------------------------------------------> O(n)

    var evenCount = 0
    var oddCount = 0
    //Upper Triangular matrix
    outer@for (i in matrix1.indices) {
        for (j in matrix1.indices) {
            if(matrix1[i][j] %2 == 0) evenCount++ else oddCount++
        }
    }
    println()
    println("Total $evenCount Even and $oddCount Odd No.s in matrix")


    // O(n*n) + O(n) + 6 ==> n(n+1) + 6  ...
}
===============================================================================================
    
//Multiplication of matrix

import java.util.*

//Add Matrix, show it consized method

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
    //-----------------------------------------------------> 6 - time

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
        println(matrix1[i].contentToString())
    }
    //--------------------------------------------------> O(n*n)
    println("\n\n")

    //Print Second Matrix
    for (i in matrix2.indices) {
        println(matrix2[i].contentToString())
    }
    //--------------------------------------------------> O(n*n)


    //Multiply Both Matrix1 * Matrix2
    for (i in matrix1.indices) {
        for (j in matrix2.indices) {
            for (k in matrix3.indices) {
                matrix3[i][j] += (matrix1[i][j] * matrix2[i][j])
            }
        }
    }
    //--------------------------------------------------> O(n*n*n)

    println("\n\n")
    for (i in matrix3.indices) {
        println(matrix3[i].contentToString())
    }
    //--------------------------------------------------> O(n*n)
    //-->  O(5*n*n) + O(n*n*n) => 5n*n(n+1)
}

