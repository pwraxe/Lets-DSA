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

    //Search Item in Matrix

    val key = 20
    var startIndex = 0
    var endIndex = twoD.size-1

    while (startIndex < twoD.size && endIndex > 0) {
        if(twoD[startIndex][endIndex] == key) {
            println("Element Found : ($startIndex, $endIndex)")
            break
        }
        if(twoD[startIndex][endIndex] > key) endIndex-- else startIndex++
    }
}
