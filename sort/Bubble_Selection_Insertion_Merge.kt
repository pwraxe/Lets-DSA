fun main() {
    val list = intArrayOf(5,2,1,6,8,0,7,9,3,4)
    val bubbleSortedList = bubbleSort(list)
    println("Bubble Sorted : ${bubbleSortedList.contentToString()}")

    val selectionSorted = selectionSort(list)
    println("Selection Sort : ${selectionSorted.contentToString()}")

    val insertionSorted = insertionSort(list)
    println("Insertion Sort : ${insertionSorted.contentToString()}")

    val mergeSorted = mergeSort(list)
    println("Merge Sort : ${mergeSorted.contentToString()}")
}

//Bubble Sort  :  O(n*n)
fun bubbleSort(list: IntArray) : IntArray {

    for (i in 0 until list.size-1) {
        for (j in 0 until (list.size-i-1)) {
            if(list[j] > list[j+1]) {
                val temp = list[j]
                list[j] = list[j+1]
                list[j+1] = temp
            }
        }
    }
    return list
}

//Selection Sort : O(n*n)
fun selectionSort(list: IntArray) : IntArray {

    for (i in 0 until list.size) {
        var minValueIndex = i

        for (j in (i+1) until list.size) {
            if(list[minValueIndex] > list[j]) minValueIndex = j
        }
        val temp = list[i]
        list[i] = list[minValueIndex]
        list[minValueIndex] = temp
    }

    return list
}

//Insertion Sort  :  O(n*n)
fun insertionSort(list: IntArray) : IntArray {

    for (i in 1 until list.size) {
        val backUpElement = list[i]
        var j = i-1

        while (j >= 0 && list[j] > backUpElement) {
            list[j+1] = list[j]
            j--
        }
        list[j+1] = backUpElement
    }

    return list
}

//Merge Sort  :  O(n log n)
fun mergeSort(list: IntArray) : IntArray {

    if(list.size <= 1) return list

    val middleIndex = list.size / 2
    val leftList = list.copyOfRange(0, middleIndex)
    val rightList = list.copyOfRange(middleIndex,list.size)
    return letsMergeIt(mergeSort(leftList), mergeSort(rightList))
}
fun letsMergeIt(leftList: IntArray,rightList: IntArray) : IntArray {
    val mainList = mutableListOf<Int>()
    var leftListIndex = 0
    var rightListIndex = 0

    while (leftListIndex < leftList.size && rightListIndex < rightList.size) {
        if(leftList[leftListIndex] < rightList[rightListIndex]) {
            mainList.add(leftList[leftListIndex])
            leftListIndex++
        } else {
            mainList.add(rightList[rightListIndex])
            rightListIndex++
        }
    }

    while (leftListIndex < leftList.size) {
        mainList.add(leftList[leftListIndex])
        leftListIndex++
    }

    while (rightListIndex < rightList.size) {
        mainList.add(rightList[rightListIndex])
        rightListIndex++
    }

    return mainList.toIntArray()
}
