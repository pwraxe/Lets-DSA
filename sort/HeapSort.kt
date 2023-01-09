//-----------------------Own Understanding-------------------
/**
 * Complexity : O(n log n)
 * **/
fun main() {
    val list =  intArrayOf(8,5,7,3,1,0,4,6,9,2,78,62)
    val sorted = heapSort(list)
    println("UnSorted List : ${list.toTypedArray().contentToString()}")
    println("Sorted List : ${sorted.contentToString()}")
}

fun heapSort(list: IntArray): IntArray {t

    val middleIndex = list.size / 2 - 1
    //Sort in Descending Order
    for (i in middleIndex downTo 0) {
        heapify(list,list.size,i)
    }
    println("List --> ${list.contentToString()}")
    //Swap First and last to sort ascending
    for (i in list.size-1 downTo 0) {
        //Swap i and 0th element
        list[0] = list[i].also { list[i] = list[0] }
        heapify(list,i,0)
    }
    return list
}

fun heapify(list: IntArray, heapSize: Int,rootIndex: Int) {
    var largeElementIndex = rootIndex
    val leftNodeIndex = 2 * rootIndex + 1
    val rightNodeIndex = 2 * rootIndex + 2

    if(leftNodeIndex < heapSize && list[leftNodeIndex] > list[largeElementIndex]) largeElementIndex = leftNodeIndex
    if(rightNodeIndex < heapSize && list[rightNodeIndex] > list[largeElementIndex]) largeElementIndex = rightNodeIndex

    //We are not swap when root Element is Larger than both its child, else swap
    if(largeElementIndex != rootIndex) {
        list[rootIndex] = list[largeElementIndex].also { list[largeElementIndex] = list[rootIndex] }
        heapify(list,heapSize,largeElementIndex)
    }
}



//-----------------------From Book---------------------------

fun main() {
    val list =  intArrayOf(8,5,7,3,1,0,4,6,9,2)
    val sorted = list.toTypedArray().heapSort()
    println("UnSorted List : ${list.toTypedArray().contentToString()}")
    println("Sorted List : ${sorted.contentToString()}")
}

fun <E: Comparable<E>> Array<E>.heapSort(): Array<E> {
    val middle = size / 2 - 1
    for (i in middle downTo 0) {
        heapify(this,size,i)
    }

    for (i in size-1 downTo 0) {
        //Swap i and 0th element
        this[0] = this[i].also { this[i] = this[0] }
        heapify(this,i,0)
    }

    return this
}

private fun <E: Comparable<E>> heapify(array: Array<E>,heapSize: Int,root:Int) {
    var largestElement = root
    val leftNode = 2 * root + 1
    val rightNode = 2 * root + 2
    if(leftNode < heapSize && array[leftNode] > array[largestElement]) largestElement = leftNode
    if(rightNode < heapSize && array[rightNode] > array[largestElement]) largestElement = rightNode
    if(largestElement != root) {
        val temp = array[largestElement]
        array[largestElement] = array[root]
        array[root] = temp
        //Alternative Swapping
        //array[largestElement] = array[root].also { array[root] = array[largestElement] }
        heapify(array,heapSize,largestElement)
    }
}
