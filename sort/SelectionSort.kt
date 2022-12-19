fun main() {
    val list = intArrayOf(5,3,2,1,7,8,5,2,4,0,1,2)
    println(selectionSort(list).contentToString())
}

fun selectionSort(list: IntArray) : IntArray {

    //interate 'i' to end of list with 1 index before
    for (i in 0 until list.size-1) {

        //taking i as minimum index, becoz when swap, we will swap using index
        var minIndex = i
        
        //j start from 1st index, to find minimum than 'minIndex' value index
        for (j in (i+1) until list.size) {
            if(list[minIndex] > list[j]) minIndex = j
        }
        //here we will have minValue index, we will swap element using index
        val temp = list[minIndex]
        list[minIndex] = list[i]
        list[i] = temp
    }
    return list
}
