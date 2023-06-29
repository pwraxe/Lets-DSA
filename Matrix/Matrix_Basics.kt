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
    //O(r*c)
    for(i in 0 until rows) {
        for(j in 0 until col) {
            twoD[i][j] = Random.nextInt(1,9)
        }
    }

    //Read values from matrix
    //O(r*c)
    for(i in 0 until rows) {
        for(j in 0 until col) {
            print("${twoD[i][j]}\t")
        }
        println()
    }


    //Search in Matrix
    //O(r*c)
    val itemToSearch = 5
    var isFound = false
    loop@for(i in 0 until rows) {
        for(j in 0 until col) {
            val item = twoD[i][j]
            if (itemToSearch == item){
                isFound = true
                break@loop
            }
        }
    }
    println("is $itemToSearch found? --> $isFound")


    println("\nPrint Primary Diagonal (from  topLeft to bottomRight)")
    //Print diagonals (left-to-right)
    //O(r*c)
    for(i in 0 until rows) {
        for(j in 0 until col) {
            if(i == j) print("${twoD[i][j]}\t")
        }
    }

    println("\nPrint Secondary Diagonal (from  topRight to bottomLeft)")
    for(i in 0 until rows) {
        for(j in 0 until col) {
            if((i+j) == (col-1)) print("${twoD[i][j]}\t")
        }
    }
}


//Output
7	3	8	
4	6	2	
7	7	8	
is 5 found? --> false

Print Primary Diagonal (from  topLeft to bottomRight)
7	6	8	
Print Secondary Diagonal (from  topRight to bottomLeft)
8	6	7	
