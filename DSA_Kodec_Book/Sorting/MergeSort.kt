fun main() {
    val input = listOf<Int>(8,2,1,9,4,3,6,7,5) //Output : [1,2,3,4,5,6,7,8,9]
    println("Merge Sort : ${mergeSort(input).toTypedArray().contentToString()}")
}

//Time Complexity : O(n log_n)
//Space Complexity : O(n)
fun <T: Comparable<T>> mergeSort(element: List<T>) : List<T> {
    return divide(element)
}

fun <T: Comparable<T>> divide(element: List<T>) : List<T> {

    //Lets Divide List
    val list = element.toMutableList()
    if(list.size < 2) return list
    val middleIndex = list.size/2
    val leftList = list.subList(0,middleIndex)
    val rightList = list.subList(middleIndex,list.size)

    return merge(divide(leftList), divide(rightList))
}

fun <T: Comparable<T>> merge(leftList: List<T>, rightList: List<T>) : List<T> {
    var leftIndex = 0
    var rightIndex = 0
    val list = mutableListOf<T>()

    while (leftIndex < leftList.size && rightIndex < rightList.size) {
        if(leftList[leftIndex] < rightList[rightIndex]) {
            list.add(leftList[leftIndex])
            leftIndex++
        } else{
            list.add(rightList[rightIndex])
            rightIndex++
        }
    }

    while (leftIndex < leftList.size) {
        list.add(leftList[leftIndex])
        leftIndex++
    }

    while (rightIndex < rightList.size) {
        list.add(rightList[rightIndex])
        rightIndex++
    }

    return list
}

