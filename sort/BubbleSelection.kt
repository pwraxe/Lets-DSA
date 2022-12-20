/**
 * Bubble Sort | O(n*n):    If you want to sort element from end
 * Selection Sort | O(n*n): If you want to sort element from start/beginning
 * **/

fun main() {
    val list = intArrayOf(2,1,8,5,4,2,6,0,1,4,7,12,2,1,3)
    println("Bubble Sort : ${bubbleSort(list).contentToString()}")
    println("Selection Sort : ${selectionSort(list).contentToString()}")
}

//Bubble Sort
fun bubbleSort(list: IntArray): IntArray {
    for (i in 0 until (list.size - 1)) {
        for (j in 0 until (list.size - i - 1)) {
            if(list[j] > list[j+1]) {
                val temp = list[j]
                list[j] = list[j+1]
                list[j+1] = temp
            }
        }
    }
    return list
}

//Selection Sort
fun selectionSort(list: IntArray) : IntArray{
    for (i in 0 until list.size-1) {
        var minValueIndex = i

        //Inner loop is just to find minimum element index in list
        for (j in (i+1) until list.size-1) {
            if(list[minValueIndex] > list[j]) minValueIndex = j
        }

        val temp = list[minValueIndex]
        list[minValueIndex] = list[i]
        list[i] = temp
    }
    return list
}
