/***
 * WHAT IS HEAPIFY?
 * To Convert Tree in Max Heap for all element, (root Node should grater than for all its child node)
 *
 *
 * My Mistakes Here
 *  -> forget to add (-1) to find middle
 *  -> wrote wrong formula for rightNodeIndex
 *  -> compared rightNode Index with leftNodeIndex and vice-versa for both if()
 *  -> Checked size for complete list instead of given heap size
 * */

fun main() {

    val list = mutableListOf<Int>(12,9,10,75,3,44,72,100)

    val middle = (list.size/2)-1
    //First For Loop to do Heapify i.e. convert tree in max heap for all element
    for (i in middle downTo 0) {
        heapify(list,list.size,i)
    }

    //Second for Loop swap max element and again to do heapify
    for (i in list.size-1 downTo 0) {
        list[0] = list[i].also { list[i] = list[0] }
        heapify(list,i,0)
    }

    println(list.toTypedArray().contentToString())
}

fun heapify(list:MutableList<Int>,size:Int, rootIndex:Int) {
    var largestElementIndex = rootIndex
    val leftNodeIndex = (rootIndex * 2) + 1
    val rightNodeIndex = (rootIndex * 2) + 2

    if(leftNodeIndex < size && list[leftNodeIndex] > list[largestElementIndex]) {
        largestElementIndex = leftNodeIndex
    }
    if(rightNodeIndex < size && list[rightNodeIndex] > list[largestElementIndex]){
        largestElementIndex = rightNodeIndex
    }

    if(rootIndex != largestElementIndex) {
        list[rootIndex] = list[largestElementIndex].also { list[largestElementIndex] = list[rootIndex] }
        heapify(list,size, largestElementIndex)
    }
}
