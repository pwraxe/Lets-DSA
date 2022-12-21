fun main() {
    val list = intArrayOf(5,2,8,4,3,9,0,1,7,6)
    val middleIndex = list.size / 2

    /**Following is PreDefine Method/Fun to divide List**/
    val leftList = list.copyOfRange(0,middleIndex)
    val rightList = list.copyOfRange(middleIndex,list.size)

    /**for Now, We are passing two sorted list for merge**/
    leftList.sort()
    rightList.sort()

    println("List : ${list.contentToString()}")
    val sortedList = mergeSort(list,leftList,rightList)

    println("Sorted : ${sortedList.contentToString()}")
}

fun mergeSort(list: IntArray, leftList : IntArray, rightList:IntArray) : IntArray {

    var listIndex = 0
    var leftListIndex = 0
    var rightListIndex = 0

    val leftListSize = leftList.size
    val rightListSize = rightList.size

    while (leftListIndex < leftListSize && rightListIndex < rightListSize) {
        if (leftList[leftListIndex] < rightList[rightListIndex]) {
            list[listIndex] = leftList[leftListIndex]
            leftListIndex++
        } else {
            list[listIndex] = rightList[rightListIndex]
            rightListIndex++
        }
        listIndex++
    }

    while (leftListIndex < leftListSize) {
        list[listIndex] = leftList[leftListIndex]
        leftListIndex++
        listIndex++
    }

    while (rightListIndex < rightListSize) {
        list[listIndex] = rightList[rightListIndex]
        rightListIndex++
        listIndex++
    }

    return list
}
