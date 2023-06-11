fun main() {
   val input = mutableListOf(9,1,7,5,4,9,6,8,2,1,3)
   println("Quick Sort by LomutoPartition: ${quickSortByLomutoPartition(input,0,input.size-1).toList()}")
   println("Quick Sort by HoaresPartition: ${quickSortByHoaresPartition(input,0,input.size-1).toList()}")
}

//Time Complexity : O(n*n) // WC : if list sorted
//Space Complexity : O(1)
fun quickSortByLomutoPartition(list: MutableList<Int>, low: Int, high: Int) : List<Int> {
    if(low < high) {
        val lomutoPartitionIndex = lomutosPartition(list, low, high)
        quickSortByLomutoPartition(list, low, lomutoPartitionIndex-1)
        quickSortByLomutoPartition(list, lomutoPartitionIndex+1,high)
    }
    return list.toList()
}
fun lomutosPartition(list: MutableList<Int>, low: Int, high: Int) : Int {
    val pivot = list[high]
    var i = low
    for(j in low until high) {
        if(list[j] < pivot) {
            list[i] = list[j].also { list[j] = list[i] }
            i++
        }
    }
    list[high] = list[i].also { list[i] = list[high] }
    return i
}

//Time Complexity : O(n)
//Space Complexity : O(1)
fun quickSortByHoaresPartition(list: MutableList<Int>, low: Int, high: Int) : List<Int> {
    if(low < high) {
        val hoarePartitionIndex = hoaresPartion(list, low, high)
        quickSortByHoaresPartition(list,low, hoarePartitionIndex)
        quickSortByHoaresPartition(list, hoarePartitionIndex+1, high)
    }
    return list.toList()
}
fun hoaresPartion(list: MutableList<Int>, low: Int, high: Int) : Int {
    
    val pivot = list[low] 
    var i = low - 1
    var j = high + 1
    while(true) {
        do { i++ }while(list[i] < pivot)
        do { j-- }while(list[j] > pivot)
        if(i < j) {
            list[i] = list[j].also { list[j] = list[i] }
        } else return j
    } 
}
