/**
 * Merge Sort is  Faster than Bubble, Selection and Insertion Sort
 * Complexity Of Merge Sort is : O(n log n)
 * Sorting time of merge sort is minimum, as 'n' no of element to sort
 * 
 * **/
fun main() {
    val list = intArrayOf(5,2,8,4,3,9,0,1,7,6)
    val sortedList = divide(list)
    println("Unsorted : ${list.contentToString()}")
    println("Sorted : ${sortedList.contentToString()}")
}
fun divide(list: IntArray) : IntArray {
    if(list.size <= 1) return list

    val middle = list.size/2
    val leftList = list.copyOfRange(0,middle)
    val rightList = list.copyOfRange(middle,list.size)

    return conquer(divide(leftList),divide(rightList)).toIntArray()
}

fun conquer(left: IntArray,right: IntArray): MutableList<Int> {

    var leftIndex = 0
    var rightIndex = 0
    var mainList = mutableListOf<Int>()

    while (leftIndex < left.size && rightIndex < right.size) {
        if(left[leftIndex] <= right[rightIndex]) {
            mainList.add(left[leftIndex])
            leftIndex++
        } else {
            mainList.add(right[rightIndex])
            rightIndex++
        }
    }

    while (leftIndex < left.size) {
        mainList.add(left[leftIndex])
        leftIndex++
    }

    while (rightIndex < right.size) {
        mainList.add(right[rightIndex])
        rightIndex++
    }
    return mainList
}
