fun main() {
   val input = mutableListOf(9,1,7,5,4,9,6,8,2,1,3)
   println("Quick Sort : ${quickSortByHoarePartition(input,0,input.size-1).toList()}")
}

fun quickSortByHoarePartition(list: MutableList<Int>, low: Int, high: Int) : List<Int> {
    
    if(low < high) {
        val partitionIndex = hoarePartition(list, low, high)
        quickSortByHoarePartition(list, low, partitionIndex)
        quickSortByHoarePartition(list, partitionIndex+1, high)
    }
    
    return list.toList()
}

fun hoarePartition(list: MutableList<Int>, low: Int, high: Int) : Int {
    val pivot = list[low]
    var i = low - 1
    var j = high + 1
    while(true) {
        do { ++i }while(list[i] < pivot)
        do { --j }while(list[j] > pivot)
        if(i < j ) {
            list[i] = list[j].also { list[j] = list[i] }
        } else return j
    }
}
