fun main() {
    val input = intArrayOf(8,2,5,4,1)
    println("Insertion Sorted : ${insertionSort(input).toTypedArray().contentToString()}")
}

//Time Complecity: O(n)
//Space Complexity : O(1)
fun insertionSort(list: IntArray): IntArray {
    for (i in 1 until list.size) {
        val key = list[i]
        var j = i - 1
        while (j >= 0 && list[j] > key) {
            list[j+1] = list[j]
            j--
        }
        list[j+1] = key
    }
    return list
}
 
