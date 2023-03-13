fun main() {
    val list = mutableListOf(18,65,23,77,10,98,20)
    val sorted = divide(list.toIntArray())
    println(sorted.contentToString())
}

fun divide(list:IntArray) : IntArray {

    if(list.size <= 1) return list
    val middle = list.size/2
    val leftArray = list.copyOfRange(0,middle)
    val rightArray = list.copyOfRange(middle,list.size)
    return conquer(divide(leftArray), divide(rightArray))
}

fun conquer(leftArray: IntArray, rightArray: IntArray) : IntArray {

    var leftIndex = 0
    var rightIndex = 0
    val list = mutableListOf<Int>()

    while (leftIndex < leftArray.size && rightIndex < rightArray.size) {
        if(leftArray[leftIndex] < rightArray[rightIndex]) {
            list.add(leftArray[leftIndex])
            leftIndex++
        } else {
            list.add(rightArray[rightIndex])
            rightIndex++
        }
    }

    while (leftIndex < leftArray.size) {
        list.add(leftArray[leftIndex])
        leftIndex++
    }

    while (rightIndex < rightArray.size) {
        list.add(rightArray[rightIndex])
        rightIndex++
    }

    return list.toIntArray()

}
