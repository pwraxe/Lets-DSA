import org.jetbrains.annotations.NotNull

@MustBeDocumented
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FUNCTION)
annotation class JustMethodDeclaration()


@JustMethodDeclaration
fun isValidMatrix(matrix: Array<Array<*>>) : Boolean {
    /**
     * How valid matrix treated here
     * -> No. of column in each row should be same
     * -> There could be n no of row's but column size should be same for each raw
     * */

    var isValid = true
    val sizeOf0thRow = matrix[0].size
    for (row in matrix) {
        if(sizeOf0thRow != row.size) {
            isValid = false
            break
        }
    }
    return isValid
}

@JustMethodDeclaration
fun addMatrix(firstMatrix: Array<DoubleArray>, secondMatrix : Array<DoubleArray>) : Array<DoubleArray> {

    val resultMatrix = Array(firstMatrix.size) { DoubleArray(firstMatrix[0].size) }

    for (i in firstMatrix.indices) {
        for (j in secondMatrix.indices) {
            resultMatrix[i][j] = firstMatrix[i][j] + secondMatrix[i][j]
        }
    }
    return resultMatrix
}

@JustMethodDeclaration
fun multiplicationMatrix(firstMatrix: Array<DoubleArray>, secondMatrix: Array<DoubleArray>) : Array<DoubleArray> {

    val resultMatrix = Array<DoubleArray>(firstMatrix.size) { DoubleArray(firstMatrix[0].size) }

    for (i in firstMatrix.indices) {
        for (j in secondMatrix.indices) {
            for (k in 0 until firstMatrix[0].size) {
                resultMatrix[i][j] += firstMatrix[i][k] + secondMatrix[k][j]
            }
        }
    }
    return resultMatrix
}



fun main() {
   val alphabets = arrayOf(
       arrayOf("A","AA","AAA"),
       arrayOf("B","BB","BBB","BBBB"),
       arrayOf("C","CC","CCC","CCCC","CCCCC")
   )

    //SetValues
    alphabets[0][1] = "111"
    alphabets[1][2] = "222"
    alphabets[2][3] = "333"

    //Get Array
    println(alphabets[0].contentToString())
    println(alphabets[1].contentToString())
    println(alphabets[2].contentToString())

    //Get Single Element
    for (list in alphabets) {
        for (str in list) {
            println("--> $str")
        }
        println("\n")
    }
}
