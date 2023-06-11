fun main() {
   val input = mutableListOf(9,1,7,5,4,9,6,8,2,1,3)
   println("Quick Sort : ${quickSort(input,0,input.size-1).toList()}")
}

fun quickSort(list: MutableList<Int>, low: Int, high: Int) : List<Int> {
    if(low < high) {
        val partitionIndex = lomutosPartition(list, low, high)
        quickSort(list,low,partitionIndex-1)
        quickSort(list, partitionIndex+1,high)
    }
    return list.toList()
}

fun lomutosPartition(list: MutableList<Int>, low: Int, high: Int) : Int {
    
    val pivot = list[high]
    var i = low
    
    for(j in low until high) {
        if(list[j] <= pivot) {
            list[i] = list[j].also { list[j] = list[i] }
        	i++
        }
    }
    
    list[high] = list[i].also { list[i] = list[high] }
    return i
    
}
