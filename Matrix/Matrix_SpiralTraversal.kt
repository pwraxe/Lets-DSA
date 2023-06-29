import kotlin.random.Random
//Spiral Traversal Matrix
fun main() {

    val twoD = Array(3) { Array(3) { 0 } }

    for (row in 0 until 3) {
        for (col in 0 until 3) {
            twoD[row][col] = Random.nextInt(10,99)
        }
    }


    for (row in 0 until 3) {
        for (col in 0 until 3) {
            print("${twoD[row][col]}\t")
        }
        println()
    }

    println()

    println("Spiral List : ${spiralTraversalMatrix(twoD).toTypedArray().contentToString()}")
}

fun spiralTraversalMatrix(matrix: Array<Array<Int>>) : List<Int> {

    //Create Empty List for Spiral Order Traversal
    val spiralOrderList = mutableListOf<Int>()

    //if Matrix is Empty, return from here
    if(matrix.isEmpty()) return spiralOrderList

    //get rows and column in matrix
    val rows = matrix.size
    val cols = matrix[0].size

    //create new boolean matrix to keep track of element is visited
    val seenMatrix = Array(rows) { BooleanArray(cols) { false } }


    val dr = intArrayOf(0, 1, 0, -1)
    val dc = intArrayOf(1, 0, -1, 0)

    //x considered as rows which will change
    var x = 0

    //y consider as col which will change
    var y = 0

    //direction shown in which direction travel
    var direction = 0

    //navigate from 0 to all elements by multiply row and column
    for (i in 0 until rows*cols) {

        //First add elements to spiralList
        spiralOrderList.add(matrix[x][y])

        //update boolean matrix, that element at position is visited
        seenMatrix[x][y] = true

        //Update Current Rows (cr)
        val cr = x + dr[direction]

        //Update Current Column (cc)
        val cc = y + dc[direction]

        //Check
        // - CurrentRows is under boundry of row
        // - Current Column is under boundry of colm
        // - seen matrix is not updated to true or element not visited yet
        if(cr in 0 until rows && 0 <= cc && cc < cols && !seenMatrix[cr][cc]) {
            //Update x and y accordingly
            x = cr
            y = cc
        } else {

            //Update Direction
            direction = (direction+1) % 4
            x += dr[direction]
            y += dc[direction]
        }
    }
    return spiralOrderList
}
