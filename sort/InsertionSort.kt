/***
 * * Same As Selection Sort and Bubble Sort
 * * Insertion Sort is faster than both above
 * * this Algorithm will use in Dynamic Collection
 * * As Like Bubble Sort, it also has 2 sub array 1 is sorted(0th element) and 2nd is unsorted (1..nth = element)
 * * As array is getting sorted, size of sorted array increased and size of unsorted array decreasing
 * * Complexity : O(n*n)
 * */


fun main() {
    val list = intArrayOf(2,1,8,5,4,6,0,7,12,3)
    println("Insertion Sort : ${insertionSort(list).contentToString()}")
}

fun insertionSort(list : IntArray) : IntArray{

    for (i in 1 until list.size) {
        val key = list[i]
        var j = i-1
        while (j >= 0 && list[j] > key) {
            list[j+1] = list[j]
            j--
        }
        list[j+1] = key
    }
    return list
}
