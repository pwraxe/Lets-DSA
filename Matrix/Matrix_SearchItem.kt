import kotlin.random.Random
fun main() {

    val row = 4
    val column = 4
    val twoD = arrayOf(
        intArrayOf(10, 20, 30, 40), //list1,
        intArrayOf(15, 25, 35, 45), //list2,
        intArrayOf(27, 29, 37, 48), //list3,
        intArrayOf(32, 33, 39, 50), //list4
    )

    for (r in 0 until row) {
        for (c in 0 until column) {
            print("${twoD[r][c]}\t")
        }
        println()
    }

    //Search in Matrix : In Linear Time
    //---------------------------------------
    //TimeComplexity : O(r*c)
    val key = 37 //Random.nextInt(10,99)
    println("\nSearch For $key :")
    var rowOf = -1
    var colOf  = -1
    outer@for (row in 0 until row) {
        for (col in 0 until column) {
            if (twoD[row][col] == key) {
                rowOf = row
                colOf = col
                break@outer
            }
        }
    }

    if(rowOf == -1 || colOf == -1) {
        println("Element Not Found")
    } else {
        println("Element found at ($rowOf, $colOf)")
    }
    println()

    //Search in Matrix : In Binary Time O(n log_n)
    //---------------------------------------

    loop@for (list in twoD) {
        val isFound = letsDoBinarySearch(list,key)
        println("is $key Found? in ${list.toTypedArray().contentToString()}: $isFound")
    }
}

fun letsDoBinarySearch(list: IntArray, searchItem: Int) : Boolean {
    var leftIndex = 0
    var rightIndex = list.size-1

    while (leftIndex < rightIndex) {
        val midIndex = (leftIndex + rightIndex) / 2
        if(searchItem < list[midIndex]) rightIndex = midIndex-1
        else if(searchItem > list[midIndex]) leftIndex = midIndex+1
        else return true
    }
    return false
}
